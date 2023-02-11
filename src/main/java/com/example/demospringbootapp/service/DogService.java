package com.example.demospringbootapp.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demospringbootapp.repository.DogRepository;

import jakarta.transaction.Transactional;

import com.example.demospringbootapp.model.Dog;

@Service
public class DogService {
   
    
    private final DogRepository dogRepository;

    public DogService(final DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public String greet(){
        return "Greetings!";
    }

    public void addDog(Dog dog){
        dogRepository.save(dog);
    }

    public Iterable<Dog> getAllDogs(){
        return dogRepository.findAll();
    }

    public Dog getDogById(Long Id){
        Optional<Dog> optionalDog = dogRepository.findById(Id);
        if(!optionalDog.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalDog.get();
    }

    @Transactional
    public void updateDog(Long idLong, String name, String race){
        Dog dogToUpdate = dogRepository.findById(idLong)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(name!=null && name.length()>0 && !Objects.equals(dogToUpdate.getName(), name)){
            dogToUpdate.setName(name);
        }

        if(race!=null && race.length()>0 && !Objects.equals(dogToUpdate.getRace(), race)){
            dogToUpdate.setRace(race);
        }
        
    }

    public void deleteDog(Long idLong){
        Optional<Dog> optionalDog = dogRepository.findById(idLong);
        if(!optionalDog.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        dogRepository.deleteById(idLong);
    }

}
