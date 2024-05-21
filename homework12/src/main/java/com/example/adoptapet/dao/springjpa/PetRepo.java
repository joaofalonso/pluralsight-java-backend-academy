package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

    List<Pet> findAllByIsAdoptedFalse();

}
