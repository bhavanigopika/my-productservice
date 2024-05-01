package com.ecommerce.myproductservice.service;

import com.ecommerce.myproductservice.dtos.GetInstructorDto;
import com.ecommerce.myproductservice.models.Batch;
import com.ecommerce.myproductservice.models.Instructor;
import com.ecommerce.myproductservice.models.User;
import com.ecommerce.myproductservice.repository.IInstructorRepository;
import com.ecommerce.myproductservice.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final IInstructorRepository instructorRepository;

    public UserService(IUserRepository userRepository, IInstructorRepository instructorRepository) {
        this.userRepository= userRepository;
        this.instructorRepository = instructorRepository;
    }

    public User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        //by this, we can create the user
        userRepository.save(user);
        return user;

    }

    public Instructor createInstructor(String name, String email) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);

        double salary = 20000.0;
        instructor.setSalary(salary); //or //instructor.setSalary(20000.0);

        String skill = "Backend";
        instructor.setSkill(skill);//or //instructor.setSkill("Backend");

        //by this, we can create the instructor
        instructorRepository.save(instructor);
        return instructor;
    }

    /*public User getUserByName(String name) {
          //call the user Repository
        return  userRepository.findByName(name).get();
    }*/

    public List<User> getUserByName(String name) {
        //call the user Repository
        return  userRepository.findByName(name);
    }
    /*
    public List<Instructor> getInstructorByName(String name) {
        //return instructorRepository.findByName(name);
        //To get all the list of Batches
        List<Instructor> instructors = instructorRepository.findByName(name);
        //System.out.println(instructors.get(0).getBatch());
        //Let's go with each batch
        for(Batch batch:instructors.get(0).getBatch()){
            System.out.println(batch.getName());
        }
        return instructors;
    }
    */

    public List<GetInstructorDto> getInstructorByName(String name) {
        //To get all the list of Batches
        //return the list of instructors
        List<Instructor> instructors = instructorRepository.findByName(name);
        //Let's go with each Batch
        /*for(Batch batch:instructors.get(0).getBatch()){
            System.out.println(batch.getName());
        }*/
        //let's create object GetInstructorDto
        List<GetInstructorDto> instructorDtos = new ArrayList<>();

        //for every instructor in the list
        for(Instructor instructor:instructors){
            GetInstructorDto getInstructorDto = new GetInstructorDto();
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());
            /*
            //Instead of printing, get the batch and add it
            //first, set batch name as a list of batchname and batchid
            List<String> batchName = new ArrayList<>();
            List<Long> batchId = new ArrayList<>();
            //we have list of batches and get one particular instructor now
            for(Batch batch:instructor.getBatch()){
                batchId.add(batch.getId());
                batchName.add(batch.getName());
                //System.out.println(batch.getName());
            }
            getInstructorDto.setBatchName(batchName);
            getInstructorDto.setBatchId(batchId);//batch, we have id and  insturctor,we have UUID
            */
            instructorDtos.add(getInstructorDto);
        }
        return instructorDtos;
    }

    public GetInstructorDto getInstructorById(UUID uuid) {
        //Assume, you always get instructor...so change it as see below line instead of optional...
        Instructor instructor = instructorRepository.findById(uuid).get();
        GetInstructorDto getInstructorDto = new GetInstructorDto();
        getInstructorDto.setId(instructor.getId());
        getInstructorDto.setName(instructor.getName());
        getInstructorDto.setEmail(instructor.getEmail());
        return getInstructorDto;
    }

    //API end point is differ
    public List<GetInstructorDto> getInstructorByIds(List<UUID> uuid) {
        //return list of instructor, so need .get() at th below line
        List<Instructor> instructors = instructorRepository.findAllById(uuid);
        //Get the list of GetInstructorDto
        List<GetInstructorDto> instructorDtos = new ArrayList<>();
        //for every instructor in the list
        for (Instructor instructor : instructors) {
            GetInstructorDto getInstructorDto = new GetInstructorDto();
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());

            //The line 137 to 145, if you comment this, then you didn't set the batch information at getInstructorDto...
            //so in postman batchId and batchname as null.

            List<String> batchNames = new ArrayList<>();
            List<Long> batchIds = new ArrayList<>();
            for(Batch batch:instructor.getBatch()){
                batchIds.add(batch.getId());
                batchNames.add(batch.getName());
            }
            getInstructorDto.setBatchName(batchNames);
            getInstructorDto.setBatchId(batchIds);//batch, we have id and  instructor,we have UUID

            instructorDtos.add(getInstructorDto);
        }
        return instructorDtos;
    }

}
