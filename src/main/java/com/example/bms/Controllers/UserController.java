package com.example.bms.Controllers;


import com.example.bms.DTO.UserDTO;
import com.example.bms.models.User;
import com.example.bms.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/user")

public class UserController {
    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user1")
    @ResponseBody
    public User createUser() {
        System.out.println("User being created");
        User user = new User("santosh", "santosh@office.com");
        userRepository.save(user);
        return user;
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody UserDTO data) {
        System.out.println("User being added");
        User user = new User(data.getName(), data.getEmail());
        userRepository.save(user);
        return user;
    }

}
