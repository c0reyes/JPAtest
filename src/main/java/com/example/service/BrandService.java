package com.example.service;

import com.example.model.Brand;

import java.util.Optional;

public interface BrandService {
	Iterable<Brand> findAll();
	
	Brand save(Brand brand);
	
	void delete(Brand brand);
	
	Optional<Brand> findById(Long id);
}
