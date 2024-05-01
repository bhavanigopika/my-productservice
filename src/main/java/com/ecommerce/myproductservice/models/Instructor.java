package com.ecommerce.myproductservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
@Entity
@Getter
@Setter
public class Instructor extends User {
    private double salary;
    private String skill;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor", cascade = CascadeType.REMOVE) //use mappedby for fetchmode = select
    //@OneToMany(fetch = FetchType.EAGER)//don't use mappedBy in fetchmode = join, fetchmode = subselect
    @Fetch(FetchMode.SELECT)
    private List<Batch> batch;
}
