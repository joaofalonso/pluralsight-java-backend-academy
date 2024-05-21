package com.example.adoptapet.service;

import com.example.adoptapet.dao.springjpa.PetRepo;
import com.example.adoptapet.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {


    @Autowired
    PetRepo petRepository;

    public PetService(PetRepo petRepository){};

    public List<Pet> getAll(){
        return this.petRepository.findAll();
    }

    public List<Pet> getAllNotAdopted(){
        return this.petRepository.findAllByIsAdoptedFalse();
    }
}
