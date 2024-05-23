package com.example.adoptapet.service;

import com.example.adoptapet.dao.springjpa.AdopterRepo;
import com.example.adoptapet.model.adopter.Adopter;
import com.example.adoptapet.model.adopter.AdopterBuilder;
import com.example.adoptapet.model.adopter.CreateAdopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdopterService {

    @Autowired
    private AdopterRepo adopterRepo;

    public AdopterService(AdopterRepo adopterRepo){

    }

    public Adopter createAdopter(CreateAdopter createAdopter){
        AdopterBuilder builder = new AdopterBuilder();

        Adopter buildedAdopter = builder.initiate(createAdopter.firstName())
                .setEmail(createAdopter.email())
                .setLastName(createAdopter.lastName())
                .setDateOfBirth(createAdopter.dob())
                .build();

        return this.adopterRepo.save(buildedAdopter);
    }

}
