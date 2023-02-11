package com.example.demospringbootapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demospringbootapp.service.DogService;
import com.example.demospringbootapp.model.Dog;


@RestController
@RequestMapping(path="/dog")
public class DogController {

    private final DogService dogService;
    
    public DogController(final DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping(path="/greet")
    public String greet(){
        return dogService.greet();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDog(@RequestBody Dog dog){
        dogService.addDog(dog);
    }

    @GetMapping
    public Iterable<Dog> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public Dog getDogById(@PathVariable("id") Long id){
        return dogService.getDogById(id);
    }

    @PutMapping("/{id}")
    public void updateDog(@PathVariable("id") Long id, String name, String race){
        dogService.updateDog(id, name, race);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable("id") Long id){
        dogService.deleteDog(id);
    }

}
