package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.interfaces.BaseDestinoInfoService;
import com.adventureAPI.AdventureAPI.models.DestinationInfo;
import com.adventureAPI.AdventureAPI.models.DestinationOptions;
import com.adventureAPI.AdventureAPI.models.DestinationResponse;
import com.adventureAPI.AdventureAPI.models.enums.*;
import com.adventureAPI.AdventureAPI.repositories.DestinationInfoRepository;
import com.adventureAPI.AdventureAPI.repositories.DestinationOptionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class DestinationService implements BaseDestinoInfoService {

    private final DestinationInfoRepository _destinoInfoRespository;
    private final DestinationOptionsRepository _destinationOptionsRepository;

    public DestinationService(DestinationInfoRepository destinoInfoRespository, DestinationOptionsRepository destinationOptionsRepository) {
        this._destinoInfoRespository = destinoInfoRespository;
        this._destinationOptionsRepository = destinationOptionsRepository;
    }

    public DestinationResponse sendCombination(String pDestino, String pClimatica, String pActividad, String pAlojamiento, String dViaje, String edad) {

        Destination destinationEnum = Destination.valueOf(pDestino.toUpperCase().replace(" ", "_").replace("Ñ", "N"));
        Weather weatherEnum = Weather.valueOf(pClimatica.toUpperCase().replace(" ", "_").replace("Í", "I"));
        Activity activityEnum = Activity.valueOf(pActividad.toUpperCase().replace(" ", "_"));
        Accommodation accommodationEnum = Accommodation.valueOf(pAlojamiento.toUpperCase().replace(" ", "_"));
        TravelDuration travelDurationEnum = TravelDuration.valueOf(dViaje.toUpperCase().replace(" ", "_").replace("-", "_").replace(" ", "_").replace("Á", "A"));
        Age ageEnum = Age.valueOf(edad.toUpperCase().replace(" ", "_").replace("-", "_").replace("Á", "A").replace(" ", "_").replace(" ", "_").replace("Ñ","N"));


        return _destinationOptionsRepository.findByCombination(
                        destinationEnum, weatherEnum, activityEnum, accommodationEnum, travelDurationEnum, ageEnum
                ).map(option -> {
                    List<DestinationInfo> destinationInfos = _destinoInfoRespository.searchByName(option.getNameAmericaDestination(), option.getNameEuropaDestination());
                    return new DestinationResponse(option.getNameAmericaDestination(), option.getNameEuropaDestination(), destinationInfos);
                })
                .orElseGet(() -> {
                    List<DestinationInfo> defaultDestinationInfos = _destinoInfoRespository.searchByName("Bora Bora", "Dubái");
                    return new DestinationResponse("Bora Bora", "Dubái", defaultDestinationInfos);
                });

    }

    @Transactional
    public void loadCombinations() {
        // Actualizar la restricción CHECK en la tabla destination_options
        String dropConstraint = "ALTER TABLE destination_options DROP CONSTRAINT destination_options_travel_duration_check;";
        String addConstraint = "ALTER TABLE destination_options ADD CONSTRAINT destination_options_travel_duration_check CHECK (travel_duration IN ('MENOS_DE_UNA_SEMANA', '_1_2_SEMANAS', 'MAS_DE_DOS_SEMANAS'));";

        String dropAgeConstraint = "ALTER TABLE destination_options DROP CONSTRAINT destination_options_age_check;";
        String addAgeConstraint = "ALTER TABLE destination_options ADD CONSTRAINT destination_options_age_check CHECK (age IN ('MENOS_DE_30_ANOS', '_30_50_ANOS', 'MAS_DE_50_ANOS'));";

        // Ejecutar las sentencias SQL
        _destinationOptionsRepository.dropTravelDurationCheckConstraint();
        _destinationOptionsRepository.addTravelDurationCheckConstraint();
        _destinationOptionsRepository.dropAgeCheckConstraint();
        _destinationOptionsRepository.addAgeCheckConstraint();

        // Define the combinations
        DestinationOptions[] combinations = {
                new DestinationOptions(Destination.PLAYA, Weather.CALUROSO, Activity.RELAX_Y_BIENESTAR, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age.MENOS_DE_30_ANOS, "Playa del Carmen", "Santorini"),
                new DestinationOptions(Destination.PLAYA, Weather.CALUROSO, Activity.CULTURA_Y_MUSEOS, Accommodation.AIRBNB, TravelDuration.MENOS_DE_UNA_SEMANA, Age.MENOS_DE_30_ANOS, "Cartagena", "Barcelona"),
                new DestinationOptions(Destination.PLAYA, Weather.TEMPLADO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age._30_50_ANOS, "Rio de Janeiro", "Lisboa"),
                new DestinationOptions(Destination.MONTANA, Weather.FRIO, Activity.DEPORTES_Y_AVENTURAS, Accommodation.HOSTAL_O_ALBERGUE, TravelDuration._1_2_SEMANAS, Age.MENOS_DE_30_ANOS, "Bariloche", "Interlaken"),
                new DestinationOptions(Destination.MONTANA, Weather.TEMPLADO, Activity.CULTURA_Y_MUSEOS, Accommodation.AIRBNB, TravelDuration._1_2_SEMANAS, Age.MAS_DE_50_ANOS, "Cusco", "Granada"),
                new DestinationOptions(Destination.MONTANA, Weather.FRIO, Activity.DEPORTES_Y_AVENTURAS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age._30_50_ANOS, "Banff", "Zermatt"),
                new DestinationOptions(Destination.CIUDAD, Weather.TEMPLADO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age.MAS_DE_50_ANOS, "Nueva York", "París" ),
                new DestinationOptions(Destination.CIUDAD, Weather.TEMPLADO, Activity.RELAX_Y_BIENESTAR, Accommodation.AIRBNB, TravelDuration.MENOS_DE_UNA_SEMANA, Age.MENOS_DE_30_ANOS, "Miami", "Viena"),
                new DestinationOptions(Destination.CIUDAD, Weather.FRIO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age._30_50_ANOS, "Toronto", "Berlín"),
                new DestinationOptions(Destination.PLAYA, Weather.CALUROSO, Activity.DEPORTES_Y_AVENTURAS, Accommodation.HOSTAL_O_ALBERGUE, TravelDuration._1_2_SEMANAS, Age.MENOS_DE_30_ANOS, "Tulum", "Ibiza"),
                new DestinationOptions(Destination.MONTANA, Weather.FRIO, Activity.CULTURA_Y_MUSEOS, Accommodation.AIRBNB, TravelDuration._1_2_SEMANAS, Age.MAS_DE_50_ANOS, "Ushuaia", "Reykjavik"),
                new DestinationOptions(Destination.PLAYA, Weather.TEMPLADO, Activity.RELAX_Y_BIENESTAR, Accommodation.AIRBNB, TravelDuration.MAS_DE_DOS_SEMANAS, Age.MAS_DE_50_ANOS, "Punta Cana", "Algarve"),
                new DestinationOptions(Destination.CIUDAD, Weather.TEMPLADO, Activity.DEPORTES_Y_AVENTURAS, Accommodation.HOTEL_DE_LUJO, TravelDuration.MENOS_DE_UNA_SEMANA, Age._30_50_ANOS, "Chicago", "Londres"),
                new DestinationOptions(Destination.PLAYA, Weather.TEMPLADO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOSTAL_O_ALBERGUE, TravelDuration._1_2_SEMANAS, Age.MENOS_DE_30_ANOS, "San Juan", "Niza"),
                new DestinationOptions(Destination.MONTANA, Weather.TEMPLADO, Activity.DEPORTES_Y_AVENTURAS, Accommodation.AIRBNB, TravelDuration.MAS_DE_DOS_SEMANAS, Age.MENOS_DE_30_ANOS, "Machu Picchu", "Chamonix"),
                new DestinationOptions(Destination.CIUDAD, Weather.CALUROSO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age.MAS_DE_50_ANOS, "Los Ángeles", "Roma"),
                new DestinationOptions(Destination.PLAYA, Weather.CALUROSO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOTEL_DE_LUJO, TravelDuration._1_2_SEMANAS, Age._30_50_ANOS, "Honolulu", "Malta"),
                new DestinationOptions(Destination.MONTANA, Weather.FRIO, Activity.RELAX_Y_BIENESTAR, Accommodation.AIRBNB, TravelDuration._1_2_SEMANAS, Age.MAS_DE_50_ANOS, "Aspen", "Innsbruck"),
                new DestinationOptions(Destination.CIUDAD, Weather.TEMPLADO, Activity.CULTURA_Y_MUSEOS, Accommodation.HOSTAL_O_ALBERGUE, TravelDuration._1_2_SEMANAS, Age._30_50_ANOS, "Ciudad de México", "Madrid"),
                // Add more combinations as needed
        };

        // Save the combinations to the database
        _destinationOptionsRepository.saveAll(Arrays.asList(combinations));
    }

    // FindAll
    @Override
    public List<DestinationInfo> index() {
        return _destinoInfoRespository.index();
    }

    @Override
    public DestinationInfo create(DestinationInfo destinoInfo) {
        return _destinoInfoRespository.saveAndFlush(destinoInfo);
    }

    @Override
    public List<DestinationInfo> searchByName(String destino1, String destino2) {
        return _destinoInfoRespository.searchByName(destino1, destino2);
    }

    @Override
    public List<DestinationInfo> searchById(int id) {
        return _destinoInfoRespository.searchById(id);
    }

//    //Delete
//    @Override
//    public DestinationInfo delete(int id) {
//        List<DestinationInfo> destinoInfoList = _destinoInfoRespository.searchById(id);
//        if (destinoInfoList.size() > 0) {
//            DestinationInfo destinoInfoDelete = destinoInfoList.get(0);
//            _destinoInfoRespository.delete(destinoInfoDelete);
//            return destinoInfoDelete;
//        }
//        return null;
//    }
}
