package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.interfaces.BaseUserService;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;

import java.util.List;

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

    //Metodo con la logica de switch en java
}
