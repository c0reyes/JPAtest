package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Brand;
import com.example.model.Model;
import com.example.model.RepBase;
import com.example.service.BrandServiceImpl;
import com.example.service.ModelServiceImpl;

@RestController
@RequestMapping("/v1/car")
public class CarController {
	
	@Autowired
	BrandServiceImpl brandService;
	
	@Autowired
	ModelServiceImpl modelService;
	
	@GetMapping("/brand")
	public @ResponseBody Iterable<Brand> getAllBrands() {
		return brandService.findAll();
	}
	
	@PostMapping("/brand")
	public ResponseEntity<RepBase> setBrand(@RequestBody Brand brand) {
		return ResponseEntity.ok(new RepBase(brandService.save(brand)));
	}
	
	@DeleteMapping("/brand")
	public ResponseEntity<RepBase> delBrand(@RequestBody Brand brand) {
		brandService.delete(brand);
		return ResponseEntity.ok(new RepBase());
	}
	
	@GetMapping("/model")
	public @ResponseBody Iterable<Model> getAllModels() {
		return modelService.findAll();
	}
	
	@PostMapping("/model")
	public ResponseEntity<RepBase> setModel(@RequestBody Model model) {
		return ResponseEntity.ok(new RepBase(modelService.save(model)));
	}
	
	@DeleteMapping("/model")
	public ResponseEntity<RepBase> delModel(@RequestBody Model model) {
		modelService.delete(model);
		return ResponseEntity.ok(new RepBase());
	}
}
