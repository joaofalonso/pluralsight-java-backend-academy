package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Adopter;
import com.example.adoptapet.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AdopterRepoTest {

    @Autowired
    private AdopterRepo adopterRepo;

    @Autowired
    private PetRepo petRepo;

    @Test
    public void testGetAllSuccess(){
        List<Adopter> result = adopterRepo.findAll();
        result.forEach(System.out::println);
        Assertions.assertTrue( result.size()>0);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testFindById(){
        Adopter adopter = adopterRepo.findById(1L).orElseThrow();
        System.out.println(adopter);

        Assertions.assertEquals("Professor", adopter.getFirstName());
        Assertions.assertEquals("Oak", adopter.getLastName());
        Assertions.assertEquals(1, adopter.getPets().size());
    }
    
    @Test
    public void testInsertSuccess(){
        Adopter adopter = new Adopter();
        List<Adopter> result = adopterRepo.findAll();

        adopter.setFirstName("Professor");
        adopter.setLastName("Oak");
        adopterRepo.save(adopter);
    }

    @Test
    public void testPetAdopterRelationship(){
        Adopter adopter = adopterRepo.findById(1L).orElseThrow();
        Pet pet = petRepo.findById(1L).orElseThrow();



        pet.setAdopter(adopter);
        petRepo.save(pet);
        Assertions.assertTrue(true);

    }
}
