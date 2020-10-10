package com.example.jpatest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpatest.model.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
	public Optional<Brand> findById(Long id);
}
