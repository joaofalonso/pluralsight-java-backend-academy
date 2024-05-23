package com.example.adoptapet.controller;

import com.example.adoptapet.model.adopter.Adopter;
import com.example.adoptapet.model.adopter.CreateAdopter;
import com.example.adoptapet.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @PostMapping
    public ResponseEntity<?> createAdopter(CreateAdopter createAdopter){
        Adopter adopter = this.adopterService.createAdopter(createAdopter);

        return ResponseEntity.ok(adopter);
    }
}
