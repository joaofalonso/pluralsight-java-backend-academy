package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdopterRepo extends JpaRepository<Adopter, Long> {

    @Query(value="SELECT a from Adopter a LEFT JOIN Pet p on p.adopter.id = a.id WHERE p.id is null")
    public List<Adopter> findAllWithoutPet();

}
