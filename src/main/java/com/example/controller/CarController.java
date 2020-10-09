package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Brand;
import com.example.model.Model;
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
	public @ResponseBody String setBrand(@RequestBody Brand brand) {
		brandService.save(brand);
		return "saved";
	}
	
	@DeleteMapping("/brand")
	public @ResponseBody String delBrand(@RequestBody Brand brand) {
		brandService.delete(brand);
		return "deleted";
	}
	
	@GetMapping("/model")
	public @ResponseBody Iterable<Model> getAllModels() {
		return modelService.findAll();
	}
	
	@PostMapping("/model")
	public @ResponseBody String setModel(@RequestBody Model model) {
		modelService.save(model);
		return "saved";
	}
	
	@DeleteMapping("/model")
	public @ResponseBody String delModel(@RequestBody Model model) {
		modelService.delete(model);
		return "deleted";
	}
}
