package com.ecommerce.myproductservice.repository;

import com.ecommerce.myproductservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    // public interface JpaRepository<T, ID> --> T is type, here, type is user, id is

    /*Optional<User> findById(Long aLong); //(Long id)

    Optional<User> findByName(String name);

    List<User> findAllByNameEndingWith(String suffix);
        //you are all giving suffix will automatically get the result for that


    //<S extends User> S save(S entity);
    //or
    User save(User entity);*/

    /***/

    //Optional<User> findByName(String name);

    List<User> findByName(String name);
}
