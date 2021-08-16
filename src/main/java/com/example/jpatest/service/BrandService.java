package com.example.jpatest.service;

import java.util.Optional;

import com.example.jpatest.entity.Brand;

public interface BrandService {
	Iterable<Brand> findAll();
	
	Brand save(Brand brand);
	
	void delete(Brand brand);
	
	Optional<Brand> findById(Long id);
}
