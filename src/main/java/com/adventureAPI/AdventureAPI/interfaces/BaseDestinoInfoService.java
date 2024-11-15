package com.adventureAPI.AdventureAPI.interfaces;

import com.adventureAPI.AdventureAPI.models.DestinoInfo;

import java.util.List;

public interface BaseDestinoInfoService {

    //FindAll
    List<DestinoInfo> index();

    //Create
    DestinoInfo create(DestinoInfo destinoInfo);

    //SearchByName
    List<DestinoInfo> searchByName (String destino1, String destino2);

    //SearchById
    List<DestinoInfo> searchById (int id);

}
