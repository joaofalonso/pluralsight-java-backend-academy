package com.example.adoptapet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated
    private Animal animalType;
    private String breed;
    private Boolean isAdopted;
    private LocalDate adoptionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="adopter_id", nullable = true)
    @JsonIgnoreProperties("pets")
    private Adopter adopter;

    public Adopter getAdopter() {
        return adopter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Animal animalType) {
        this.animalType = animalType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getAdopted() {
        return isAdopted;
    }

    public void setAdopted(Boolean adopted) {
        isAdopted = adopted;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                ", breed='" + breed + '\'' +
                ", isAdopted=" + isAdopted +
                ", adoptionDate=" + adoptionDate +
                '}';
    }
}
