package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.models.UserQueryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueryRepository extends CrudRepository<UserQueryEntity, Integer>{
    UserQueryEntity saveAndFlush(UserQueryEntity userQuery);

    @Query(
            value = "SELECT * FROM user_query WHERE id = ?1",
            nativeQuery = true
    )
    UserQueryEntity getById(int id);

    @Query(
            value = "SELECT * FROM user_query",
            nativeQuery = true
    )
    List<UserQueryEntity> index();

    @Query(
            value = "SELECT * FROM user_query WHERE report_id = ?1",
            nativeQuery = true
    )
    List<UserQueryEntity> findByReportId(int reportId);
}
