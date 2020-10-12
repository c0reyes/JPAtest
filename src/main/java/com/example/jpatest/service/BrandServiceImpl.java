package com.example.jpatest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpatest.exception.NotFoundException;
import com.example.jpatest.model.Brand;
import com.example.jpatest.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Iterable<Brand> findAll() {
		return brandRepository.findAll();
	}
	
	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}
	
	@Override
	public void delete(Brand brand) {
		if(!brandRepository.existsById(brand.getId())) throw new NotFoundException("Brand not found");
		brandRepository.deleteById(brand.getId());
	}
	
	@Override
	public Optional<Brand> findById(Long id) {
		return brandRepository.findById(id);	    
    }
}
