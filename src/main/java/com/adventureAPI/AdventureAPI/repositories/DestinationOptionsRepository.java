package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.models.DestinationOptions;
import com.adventureAPI.AdventureAPI.models.enums.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationOptionsRepository extends CrudRepository<DestinationOptions, Integer> {

    Optional<DestinationOptions> findByCombination(
            Destination pDestino, Weather pClimatica, Activity pActividad, Accommodation pAlojamiento, TravelDuration dViaje, Age edad
    );

}
