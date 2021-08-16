package com.example.jpatest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.example.jpatest.entity.Brand;
import com.example.jpatest.entity.Model;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void saveBrand() throws Exception {
		Brand brand = new Brand();
		brand.setName("toyota");
		
		HttpEntity<Brand> request = new HttpEntity<>(brand);
		
		ResponseEntity<String> result = this.restTemplate.postForEntity("http://localhost:" + port + "/v1/car/brand", 
				request, String.class);
		
		assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void saveModel() throws Exception {
		Model model = new Model();
		model.setName("supra");
		model.setYear(2018);
		model.setBrand_id((long) 1);
		
		HttpEntity<Model> request = new HttpEntity<>(model);
		
		ResponseEntity<String> result = this.restTemplate.postForEntity("http://localhost:" + port + "/v1/car/model", 
				request, String.class);
		
		assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void getBrand() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/car/brand",
				String.class)).contains("toyota");

	}

	@Test
	public void delModel() throws Exception {
		Model model = new Model();
		model.setId((long) 1);
		
		HttpEntity<Model> request = new HttpEntity<>(model);
		ResponseEntity<String> result = this.restTemplate.exchange("http://localhost:" + port + "/v1/car/model", 
				HttpMethod.DELETE, request, String.class);
		
		assertEquals(200, result.getStatusCodeValue());
	} 
	
	@Test
	public void getModel() throws Exception {
		assertFalse(this.restTemplate.getForObject("http://localhost:" + port + "/v1/car/model",
				String.class).contains("supra"));
	}
}
