package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Animal;
import com.example.adoptapet.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PetRepoTest {

    @Autowired
    PetRepo petRepository;

    @Test
    public void testFindAll(){
        List<Pet> all = petRepository.findAll();
        all.forEach(System.out::println);
        Assertions.assertTrue(all.size() > 0);
    }
    @Test
    public void testInsertSuccess(){
        Pet pet = new Pet();

        pet.setAnimalType(Animal.BIRD);
        pet.setName("Lugia");
        pet.setAdopted(false);
        pet.setBreed("Legendary Pokemon");
        Pet save = petRepository.save(pet);
        Assertions.assertNotNull(save);
    }

    @Test
    public void testUpdatePetSuccess(){
        Pet pet = petRepository.findById(1L).orElseThrow();
        pet.setAdoptionDate(LocalDate.now());
        pet.setAdopted(true);
        petRepository.save(pet);
    }
    @Test
    public void testFindById(){
        Pet pet = petRepository.findById(1L).orElseThrow();

        Assertions.assertEquals("Articuno", pet.getName());
        Assertions.assertEquals(Animal.BIRD, pet.getAnimalType());
        Assertions.assertNotNull(pet.getAdopter());
    }

    @Test
    public void testFindAllNotAdopted(){
        List<Pet> result = petRepository.findAllByIsAdoptedFalse();
        List<Pet> adopted = result.stream().filter(Pet::getAdopted).toList();
        Assertions.assertEquals(0, adopted.size());
    }
}
