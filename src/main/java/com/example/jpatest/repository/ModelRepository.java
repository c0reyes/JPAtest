package com.example.jpatest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpatest.entity.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {

}
