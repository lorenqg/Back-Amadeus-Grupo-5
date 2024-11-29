package com.adventureAPI.AdventureAPI.repositories;

import com.adventureAPI.AdventureAPI.models.DestinationOptions;
import com.adventureAPI.AdventureAPI.models.enums.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationOptionsRepository extends CrudRepository<DestinationOptions, Integer> {

    @Query("SELECT d FROM DestinationOptions d WHERE d.destination = :destination AND d.weather = :weather AND d.activity = :activity AND d.accommodation = :accommodation AND d.travelDuration = :travelDuration AND d.age = :age")
    Optional<DestinationOptions> findByCombination(
            @Param("destination") Destination destination,
            @Param("weather") Weather weather,
            @Param("activity") Activity activity,
            @Param("accommodation") Accommodation accommodation,
            @Param("travelDuration") TravelDuration travelDuration,
            @Param("age") Age age
    );

    @Modifying
    @Query(value = "ALTER TABLE destination_options DROP CONSTRAINT destination_options_travel_duration_check", nativeQuery = true)
    void dropTravelDurationCheckConstraint();

    @Modifying
    @Query(value = "ALTER TABLE destination_options ADD CONSTRAINT destination_options_travel_duration_check CHECK (travel_duration IN ('MENOS_DE_UNA_SEMANA', '_1_2_SEMANAS', 'MAS_DE_DOS_SEMANAS'))", nativeQuery = true)
    void addTravelDurationCheckConstraint();

    @Modifying
    @Query(value = "ALTER TABLE destination_options DROP CONSTRAINT destination_options_age_check", nativeQuery = true)
    void dropAgeCheckConstraint();

    @Modifying
    @Query(value = "ALTER TABLE destination_options ADD CONSTRAINT destination_options_age_check CHECK (age IN ('MENOS_DE_30_ANOS', '_30_50_ANOS', 'MAS_DE_50_ANOS'))", nativeQuery = true)
    void addAgeCheckConstraint();

}