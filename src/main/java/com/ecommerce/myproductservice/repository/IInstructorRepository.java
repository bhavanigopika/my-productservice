package com.ecommerce.myproductservice.repository;

import com.ecommerce.myproductservice.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IInstructorRepository extends JpaRepository<Instructor, UUID> {
    List<Instructor> findByName(String name);
    //Optional<Instructor> findById(UUID uuid); //ofcourse this is a common usage, no need to mention separately
    //List<Instructor> findAllById(List<UUID> uuid); //ofcourse this is a common usage
}
