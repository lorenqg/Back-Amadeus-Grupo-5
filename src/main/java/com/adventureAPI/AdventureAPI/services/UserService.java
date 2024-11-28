package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.interfaces.BaseUserService;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements BaseUserService{
    private UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }
    //FindAll
    @Override
    public List<User> index() {
        return _userRepository.index();
    }

    //    Create
    @Override
    public User create(User user) {
        return _userRepository.saveAndFlush(user);
    }

    //Update
    @Override
    public User update(int id, User user) {
        List<User> userList = _userRepository.searchId(id);
        if (userList.size() > 0) {
            User userUpdate = userList.get(0);
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            return _userRepository.saveAndFlush(userUpdate);
        }
        return null;
    }

    //Delete
    @Override
    public User delete(int id) {
        List<User> userList = _userRepository.searchId(id);
        if (userList.size() > 0) {
            User userDelete = userList.get(0);
            _userRepository.delete(userDelete);
            return userDelete;
        }
        return null;
    }

    @Override
    public List<User> searchById(int id) {
        return _userRepository.searchId(id);
    }

    @Override
    public List<User> searchByName(String name) {
        return _userRepository.searchName(name);
    }

    @Override
    public List<User> searchByEmail(String email) {
        return _userRepository.searchEmail(email);
    }

    //login
    @Override
    public Map<String, String> login(User user) {
        if(user.getEmail() == null || user.getEmail().isEmpty() ||user.getName() == null || user.getName().isEmpty()){
            throw new RuntimeException("Email and name are required");
        };
        User foundUser = _userRepository.findByEmailAndName(user.getEmail(), user.getName());
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
