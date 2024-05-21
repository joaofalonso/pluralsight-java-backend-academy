package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Adopter;
import com.example.adoptapet.model.Pet;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class AdopterRepoTest {

    @Autowired
    private AdopterRepo adopterRepo;

    @Autowired
    private PetRepo petRepo;

    @BeforeEach
    public void setupForTests(){
        Adopter adopter = new Adopter();

        adopter.setFirstName("Professor");
        adopter.setLastName("Oak");
        adopter.setDateOfBirth(LocalDate.now());
        adopter.setEmail("professor.oak@kanto.com");

        adopterRepo.save(adopter);
    }
    @Test
    public void testGetAllSuccess(){
        List<Adopter> result = adopterRepo.findAll();
        Assertions.assertNotNull(result);
    }

    @Test
    public void testFindById(){
        Adopter adopter = adopterRepo.findById(1L).orElseThrow();

        Assertions.assertEquals("Professor", adopter.getFirstName());
        Assertions.assertEquals("Oak", adopter.getLastName());

    }
    
    @Test
    public void testInsertSuccess(){
        Adopter adopter = new Adopter();

        adopter.setFirstName("Ash");
        adopter.setLastName("");
        adopter.setEmail("ash@kanto.com");
        Adopter save = adopterRepo.save(adopter);

        Assertions.assertTrue(save.getId() > 0);

    }

    @Test
    public void testInsertErrorNoFirstName(){
        Adopter adopter = new Adopter();
        adopter.setLastName("Rocket");
        adopter.setEmail("dummy@rocket.com");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            this.adopterRepo.save(adopter);
        });
    }

    @Test
    public void testInsertErrorNoEmail(){
        Adopter adopter = new Adopter();
        adopter.setFirstName("Dummy");
        adopter.setLastName("Rocket");

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            this.adopterRepo.save(adopter);
        });
    }

//    @Test
//    public void testPetAdopterRelationship(){
//        Adopter adopter = adopterRepo.findById(1L).orElseThrow();
//        Pet pet = petRepo.findById(1L).orElseThrow();
//
//        pet.setAdopter(adopter);
//        petRepo.save(pet);
//        Assertions.assertTrue(true);
//
//    }

    @Test
    public void testFindAllAdoptersWithoutPet(){
        List<Adopter> result = adopterRepo.findAllWithoutPet();
        List<Adopter> adoptersWithPets = result.stream().filter(a -> !a.getPets().isEmpty()).toList();
        Assertions.assertEquals(0, adoptersWithPets.size());
    }
}
