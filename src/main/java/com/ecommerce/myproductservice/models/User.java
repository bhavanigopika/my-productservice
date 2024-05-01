package com.ecommerce.myproductservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    //71430b6e-760e-4b04-b363-7491c588fd57 -- 32 characters
    //760e0100 0110 0000 1110  4 digits directs to 16 digits here
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
