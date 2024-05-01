package com.ecommerce.myproductservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Batch {
    @Id
    private long id;
    private String name;
    private Integer strength;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
