package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.adopter.Adopter;
import com.example.adoptapet.model.adopter.AdopterBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class AdopterRepoTest {

    @Autowired
    private AdopterRepo adopterRepo;

    @Autowired
    private PetRepo petRepo;
    String adopterName = "Professor";
    String adopterLastName = "Oak";
    String adopterEmail = "professor.oak@kanto.com";
    LocalDate dateOfBirth;
    @Test
    public void testInsertSuccess(){


        Adopter adopter = new AdopterBuilder()
                .initiate(adopterName)
                .setLastName(adopterLastName)
                .setEmail("professor.oak@kanto.com")
                .setDateOfBirth(dateOfBirth)
                .build();

        Adopter createdAdopter = adopterRepo.save(adopter);

        assertNotNull(createdAdopter);
        assertEquals(adopterName, createdAdopter.getFirstName());
        assertEquals(adopterLastName, createdAdopter.getLastName());
        assertEquals(adopterEmail, createdAdopter.getEmail());
        assertEquals(dateOfBirth, createdAdopter.getDateOfBirth());

    }
    @Test
    public void testFindById(){
        Adopter adopter = adopterRepo.findById(1L).orElseThrow();
        assertEquals(adopterName, adopter.getFirstName());
        assertEquals(adopterLastName, adopter.getLastName());
        assertEquals(adopterEmail, adopter.getEmail());
        assertEquals(dateOfBirth, adopter.getDateOfBirth());
    }

    @Test
    public void testGetAllSuccess(){
        List<Adopter> result = adopterRepo.findAll();
        Assertions.assertNotNull(result);
    }



    @Test
    public void testInsertErrorNoEmail(){
        Adopter adopter = new AdopterBuilder()
                .initiate("Ash")
                .setLastName("")
                .build();

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            this.adopterRepo.save(adopter);
        });
    }

    @Test
    public void testFindAllAdoptersWithoutPet(){
        List<Adopter> result = adopterRepo.findAllWithoutPet();
        List<Adopter> adoptersWithPets = result.stream().filter(a -> !a.getPets().isEmpty()).toList();
        assertEquals(0, adoptersWithPets.size());
    }
}
