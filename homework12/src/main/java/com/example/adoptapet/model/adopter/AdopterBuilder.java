package com.example.adoptapet.model.adopter;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Objects;

public class AdopterBuilder {

    private String firstName;
    private String email;
    private String lastName;
    private LocalDate dateOfBirth;
    public AdopterBuilder initiate(String firstName){
        if(Objects.isNull(firstName))
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
        return this;
    }

    public AdopterBuilder setEmail(String email){
        if(!email.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        this.email = email;
        return this;
    }

    public AdopterBuilder setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public AdopterBuilder setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Adopter build(){
        Adopter adopter = new Adopter();
        adopter.setFirstName(this.firstName);
        adopter.setEmail(this.email);
        adopter.setLastName(this.lastName);
        adopter.setDateOfBirth(this.dateOfBirth);
        return adopter;
    }
}
