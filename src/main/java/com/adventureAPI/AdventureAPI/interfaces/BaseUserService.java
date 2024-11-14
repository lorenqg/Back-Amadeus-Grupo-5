package com.adventureAPI.AdventureAPI.interfaces;

import com.adventureAPI.AdventureAPI.Models.User;

import java.util.List;

public interface BaseUserService {

    //FindAll
    List<User> index();

    List<User> searchById(int id);
    List<User> searchByName(String name);
    List<User> searchByEmail(String email);

    //Create
    User create(User user);

    //UpdateAndFlush
    User update(int id, User user );

    //delete
    User delete(int id);

}
