package com.example.jpatest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpatest.model.Brand;
import com.example.jpatest.model.Model;
import com.example.jpatest.repository.BrandRepository;
import com.example.jpatest.repository.ModelRepository;

@SpringBootTest
public class MemoryDBTest {
	@Resource
	private BrandRepository brandRepository;
	
	@Resource
	private ModelRepository modelRepository;
	
	@Test
	public void saveBrand() {
		Brand brand = new Brand();
		brand.setName("toyota");
		
		brandRepository.save(brand);
		
		Optional<Brand> brandFind = brandRepository.findById((long)1);
		assertTrue(brandFind.isPresent());
	}
	
	@Test
	public void saveModel() {
		Brand brand = new Brand();
		brand.setName("toyota");
		
		brandRepository.save(brand);
		
		Model model = new Model();
		model.setName("supra");
		model.setBrand(brand);
		model.setYear(2018);
		
		modelRepository.save(model);
		
		Optional<Model> modelFind = modelRepository.findById((long)1);
		assertTrue(modelFind.isPresent());
	}
}
