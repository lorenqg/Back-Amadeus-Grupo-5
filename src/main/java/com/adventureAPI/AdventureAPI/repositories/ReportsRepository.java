package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportsRepository extends CrudRepository<ReportsEntity, Integer> {

    @Query(
            value = "SELECT * FROM reports ",
            nativeQuery = true
    )
    List<ReportsEntity> index();

    @Query(
            value = "SELECT * FROM reports WHERE id = ?1",
            nativeQuery = true
    )
    Optional<ReportsEntity> getById(int id);

    ReportsEntity saveAndFlush(ReportsEntity report);

}
