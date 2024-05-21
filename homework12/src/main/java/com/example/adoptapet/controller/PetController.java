package com.example.adoptapet.controller;

import com.example.adoptapet.model.Pet;
import com.example.adoptapet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/pet")
public class PetController {


    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<?> get(){
        List<Pet> result = this.petService.getAll();
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/toadopt")
    public ResponseEntity<?> getNotAdopted(){
        List<Pet> result = this.petService.getAllNotAdopted();
        return  ResponseEntity.ok(result);
    }
}
