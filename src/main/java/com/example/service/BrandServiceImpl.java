package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Brand;
import com.example.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Iterable<Brand> findAll() {
		return brandRepository.findAll();
	}
	
	@Override
	public void save(Brand brand) {
		brandRepository.save(brand);
	}
	
	@Override
	public void delete(Brand brand) {
		brandRepository.deleteById(brand.getId());
	}
	
	@Override
	public Optional<Brand> findById(Long id) {
		return brandRepository.findById(id);	    
    }
}
