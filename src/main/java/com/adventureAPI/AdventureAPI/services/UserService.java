package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> index() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(int id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public User delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return user;
    }

    public List<User> searchById(int id) {
        return userRepository.findById(id).stream().toList();
    }

    public List<User> searchByName(String name) {
        return userRepository.searchName(name);
    }

    public List<User> searchByEmail(String email) {
        return userRepository.searchEmail(email);
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User convertToResponse(User user) {
        return user;
    }

    //login
    public Map<String, String> login(User user) {
        if(user.getEmail() == null || user.getEmail().isEmpty() ||user.getName() == null || user.getName().isEmpty()){
            throw new RuntimeException("Email and name are required");
        };
        User foundUser = userRepository.findByEmailAndName(user.getEmail(), user.getName());
        if (foundUser != null) {

            Map<String, String> response = new HashMap<>();
            response.put("message", "Login success");
            response.put("user", String.valueOf(foundUser.getName()));
            return response;
        }else {
            throw new RuntimeException("User not found");
        }
    }
}
