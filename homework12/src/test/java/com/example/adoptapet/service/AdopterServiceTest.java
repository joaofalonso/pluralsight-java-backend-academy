package com.example.adoptapet.service;

import com.example.adoptapet.model.adopter.Adopter;
import com.example.adoptapet.model.adopter.CreateAdopter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AdopterServiceTest {


    @Autowired
    private AdopterService adopterService;

    @Test
    public void testCreateWithRecordSuccess(){
        CreateAdopter createAdopter = new CreateAdopter("Record Adopter",
                "Test Class",
                "adopter@record.com",
                LocalDate.now());
        Adopter adopter = this.adopterService.createAdopter(createAdopter);
        Assertions.assertNotNull(adopter);

    }

    @Test
    public void testFindAll(){
        List<Adopter> result = this.adopterService.findAll();

        Assertions.assertFalse(result.isEmpty());
    }


}
