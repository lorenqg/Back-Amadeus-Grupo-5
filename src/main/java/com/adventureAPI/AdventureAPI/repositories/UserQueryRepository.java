package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.contracts.request.UserQueryRequest;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.models.UserQueryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserQueryRepository extends CrudRepository<UserQueryEntity, Integer> {

    @Query(
            value = "SELECT * FROM user_query WHERE id = ?1",
            nativeQuery = true
    )
    UserQueryEntity getById(int id);

    @Query(
            value = "SELECT * FROM user_query ",
            nativeQuery = true
    )
    List<UserQueryEntity> index();

    UserQueryEntity saveAndFlush(UserQueryRequest userQuery, ReportsEntity report);

}
