package com.example.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto3.reto3.model.Audience;
import com.example.reto3.reto3.repository.crud.AudienceCrudRepository;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCrudRepository audienceCrudRepository;


    public List<Audience> getAll(){

        return (List<Audience>) audienceCrudRepository.findAll();
    }

    public Optional<Audience> getAudience(int id){

        return audienceCrudRepository.findById(id);

    }

    public Audience save(Audience audi){

        return audienceCrudRepository.save(audi);
    }

    public void delete(Audience audi){
        audienceCrudRepository.delete(audi);
    }
}  

