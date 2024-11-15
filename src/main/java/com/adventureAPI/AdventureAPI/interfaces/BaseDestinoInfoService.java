package com.adventureAPI.AdventureAPI.interfaces;

import com.adventureAPI.AdventureAPI.models.DestinationInfo;

import java.util.List;

public interface BaseDestinoInfoService {

    //FindAll
    List<DestinationInfo> index();

    //Create
    DestinationInfo create(DestinationInfo destinoInfo);

    //SearchByName
    List<DestinationInfo> searchByName (String destino1, String destino2);

    //SearchById
    List<DestinationInfo> searchById (int id);

    //delete
    DestinationInfo delete(int id);


}
