package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.adopter.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdopterRepo extends JpaRepository<Adopter, Long> {

    @Query(value="SELECT a from Adopter a LEFT JOIN fetch a.pets")
    public List<Adopter> findAllWithoutPet();

}
