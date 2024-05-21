package com.example.adoptapet.dao.springjpa;

import com.example.adoptapet.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepo extends JpaRepository<Adopter, Long> {
}
