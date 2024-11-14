package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    //FindAll
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users")
    List<User> index();

    //Find by id
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users WHERE id = :id")
    List<User> searchId(int id);

    //Find by name
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users WHERE name ILIKE CONCAT('%', :name, '%')"

    )
    List<User> searchName(String name);

    //Find by email
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users WHERE LOWER(email) LIKE %:email%"
    )
    List<User> searchEmail(String email);

    //Create
    User saveAndFlush(User user);

    //TODO
    //Corregir el metodo find by name para que traiga las coincidencias con mayusculas y minusculas
    //R=LOWER(name)


}