package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.models.DestinationInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationInfoRepository extends CrudRepository<DestinationInfo, Integer> {

    //FindAll
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destination_info"
    )
    List<DestinationInfo> index();

    //Create
    DestinationInfo saveAndFlush(DestinationInfo destinoInfo);

    //FindByName
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destination_info WHERE nombre_destino LIKE %:destino1% OR nombre_destino LIKE %:destino2%"
    )
    List<DestinationInfo> searchByName(String destino1, String destino2);

    //FindById
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destination_info WHERE id = :id"
    )
    List<DestinationInfo> searchById(int id);


}
