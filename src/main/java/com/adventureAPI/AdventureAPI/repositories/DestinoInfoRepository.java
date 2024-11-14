package com.adventureAPI.AdventureAPI.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinoInfoRepository extends CrudRepository<DestinoInfo, Integer> {

    //FindAll
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info"
    )
    List<DestinoInfo> index();

    //Create
    DestinoInfo saveAndFlush(DestinoInfo destinoInfo);

    //FindByName
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE nombre_destino LIKE %:destino1% OR nombre_destino LIKE %:destino2%"
    )
    List<DestinoInfo> searchByName(String destino1, String destino2);

    //FindById
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM destino_info WHERE id = :id"
    )
    List<DestinoInfo> searchById(int id);


}
