package com.example.service;

import com.example.model.Model;

public interface ModelService {
	Iterable<Model> findAll();
	
	Long save(Model model);
	
	void delete(Model model);
}
