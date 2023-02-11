package com.example.demospringbootapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demospringbootapp.model.Dog;

public interface DogRepository extends CrudRepository<Dog,Long>{
    
}
