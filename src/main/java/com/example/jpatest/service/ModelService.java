package com.example.jpatest.service;

import com.example.jpatest.entity.Model;

public interface ModelService {
	Iterable<Model> findAll();
	
	Long save(Model model);
	
	void delete(Model model);
}
