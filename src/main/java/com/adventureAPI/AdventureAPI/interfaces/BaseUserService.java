package com.adventureAPI.AdventureAPI.interfaces;

import com.adventureAPI.AdventureAPI.models.User;

import java.util.List;
import java.util.Map;

public interface BaseUserService {

    //FindAll
    List<User> index();

    List<User> searchById(int id);
    List<User> searchByName(String name);
    List<User> searchByEmail(String email);

    //Create
    User create(User user);

    //Login
    Map<String, String> login(User user);

    //UpdateAndFlush
    User update(int id, User user );

    //delete
    User delete(int id);

}
