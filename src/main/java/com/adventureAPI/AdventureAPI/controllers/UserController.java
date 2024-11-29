package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.services.UserService;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository _userRepository;

    //Metodos
    @GetMapping("/index")
    public ResponseEntity<List<User>> index() {
        List<User> users = new UserService(_userRepository).index();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User userCreated = new UserService(_userRepository).create(user);
        return new ResponseEntity<>(userCreated, HttpStatus.OK);
    }

    //Put
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        User userUpdated = new UserService(_userRepository).update(id, user);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        User userDeleted = new UserService(_userRepository).delete(id);
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }

    //Search by id
    @GetMapping("/searchId/{id}")
    public ResponseEntity<List<User>> searchId(@PathVariable int id) {
        List<User> users = new UserService(_userRepository).searchById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Search by name
    @GetMapping("/searchName/{name}")
    public ResponseEntity<List<User>> searchName(@PathVariable String name) {
        List<User> users = new UserService(_userRepository).searchByName(name);
        if (users.size() == 0) {
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Search by email
    @GetMapping("/searchEmail/{email}")
    public ResponseEntity<List<User>> searchEmail(@PathVariable String email) {
        List<User> users = new UserService(_userRepository).searchByEmail(email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Map<String, String> response = new UserService(_userRepository).login(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
