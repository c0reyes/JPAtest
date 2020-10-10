package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Brand;
import com.example.model.Model;
import com.example.repository.BrandRepository;
import com.example.repository.ModelRepository;

@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Iterable<Model> findAll() {
		return modelRepository.findAll();
	}
	
	@Override
	public Long save(Model model) {
		Optional<Brand> brand = brandRepository.findById(model.getBrand_id());
		
		if(brand.isPresent()) {
			model.setBrand(brand.get());
			Model m = modelRepository.save(model);
			return m.getId();
		}
		
		return (long) -1;
	}
	
	@Override
	public void delete(Model model) {
		modelRepository.deleteById(model.getId());
	}
}
