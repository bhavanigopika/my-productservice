package com.ecommerce.myproductservice.controller;

import com.ecommerce.myproductservice.dtos.CreateUserDto;
import com.ecommerce.myproductservice.dtos.GetInstructorDto;
import com.ecommerce.myproductservice.models.Instructor;
import com.ecommerce.myproductservice.models.User;
import com.ecommerce.myproductservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userServ;

    public UserController(UserService userServ) {
        this.userServ = userServ;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto){
        return userServ.createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    @PostMapping("/instructor")
    public Instructor createInstructor (@RequestBody CreateUserDto  createUserDto){
        return userServ.createInstructor(createUserDto.getName(), createUserDto.getEmail());
    }
    /* @GetMapping("/{name}")
    public User getUserByName(@PathVariable(name = "name") String name){
        return userServ.getUserByName(name);
    }*/
    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable(name = "name") String name){
        return userServ.getUserByName(name);
    }

    /*@GetMapping("/instructor/{name}")
    public List<Instructor> getInstructorByName(@PathVariable (name = "name") String name){
        return userServ.getInstructorByName(name);
    }*/

    @GetMapping("/instructor/{name}")
    public List<GetInstructorDto> getInstructorByName(@PathVariable(name = "name") String name){
        return userServ.getInstructorByName(name);
    }

    //Considered, name and uuid are strings. So, give any one @Getmapping here either above or below...
    /*@GetMapping("/instructor/{uuid}")
    public GetInstructorDto getInstructorByUUID(@PathVariable(name = "uuid") UUID uuid){
        return userServ.getInstructorById(uuid);
    }*/

    //API end point is differ
    @GetMapping("/instructor")
    public List<GetInstructorDto> getInstructorByUUID(@RequestBody List<UUID> uuid){
        return userServ.getInstructorByIds(uuid);
    }
}
