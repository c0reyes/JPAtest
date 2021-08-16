package com.example.jpatest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpatest.entity.Brand;
import com.example.jpatest.entity.Model;
import com.example.jpatest.exception.NotFoundException;
import com.example.jpatest.repository.BrandRepository;
import com.example.jpatest.repository.ModelRepository;

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
		
		throw new NotFoundException("Brand not found");
	}
	
	@Override
	public void delete(Model model) {
		if(!modelRepository.existsById(model.getId())) throw new NotFoundException("Model not found");
		modelRepository.deleteById(model.getId());
	}
}
