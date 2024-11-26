package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.interfaces.BaseDestinoInfoService;
import com.adventureAPI.AdventureAPI.models.DestinationInfo;
import com.adventureAPI.AdventureAPI.models.DestinationRequest;
import com.adventureAPI.AdventureAPI.models.DestinationResponse;
import com.adventureAPI.AdventureAPI.models.enums.*;
import com.adventureAPI.AdventureAPI.repositories.DestinationInfoRepository;
import com.adventureAPI.AdventureAPI.repositories.DestinationOptionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        Destination destinationEnum = Destination.valueOf(pDestino.toUpperCase().replace("", "_"));
        Weather weatherEnum = Weather.valueOf(pClimatica.toUpperCase().replace("", "_"));
        Activity activityEnum = Activity.valueOf(pActividad.toUpperCase().replace("", "_"));
        Accommodation accommodationEnum = Accommodation.valueOf(pAlojamiento.toUpperCase().replace("", "_"));
        TravelDuration travelDurationEnum = TravelDuration.valueOf(dViaje.toUpperCase().replace("", "_"));
        Age ageEnum = Age.valueOf(edad.toUpperCase().replace("", "_"));

        return _destinationOptionsRepository.findByCombination(
                destinationEnum, weatherEnum, activityEnum, accommodationEnum, travelDurationEnum, ageEnum
                ).map(option -> new DestinationResponse(option.getdestinoA(), option.getdestinoE()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destination Not Found"));
    }

    // Método para enviar destino
//    public DestinationResponse enviarDestino(String pDestino, String pClimatica, String pActividad, String pAlojamiento, String dViaje, String edad) {
//
//        DestinationRequest destinationRequest = new DestinationRequest(pDestino, pClimatica, pActividad, pAlojamiento, dViaje, edad);
//
//        // Reseteamos destinos antes de procesar
//        String destinoA = "";
//        String destinoE = "";
//
//        // Lógica principal
//        switch (pDestino) {
//            // Si el destino es playa
//            case "Playa":
//                if ("Caluroso".equals(pClimatica)) {
//                    switch (dViaje) {
//                        case "1-2 semanas":
//                            if ("Menos de 30 años".equals(edad) && "Deportes y Aventuras".equals(pActividad) && "Hostal o Albergue".equals(pAlojamiento)) {
//                                destinoA = "Tulum";
//                                destinoE = "Ibiza";
//                            } else if ("Menos de 30 años".equals(edad) && "Relax y Bienestar".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
//                                destinoA = "Playa del Carmen";
//                                destinoE = "Santorini";
//                            } else if ("30-50 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
//                                destinoA = "Honolulu";
//                                destinoE = "Malta";
//                            }
//                            break;
//                        case "Menos de una semana":
//                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Airbnb".equals(pAlojamiento)) {
//                                destinoA = "Cartagena";
//                                destinoE = "Barcelona";
//                            }
//                            break;
//                    }
//                } else if ("Templado".equals(pClimatica)) {
//                    switch (dViaje) {
//                        case "1-2 semanas":
//                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hostal o Albergue".equals(pAlojamiento)) {
//                                destinoA = "San Juan";
//                                destinoE = "Niza";
//                            } else if ("30-50 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
//                                destinoA = "Río de Janeiro";
//                                destinoE = "Lisboa";
//                            }
//                            break;
//                        case "Más de dos semanas":
//                            if ("Más de 50 años".equals(edad) && "Relax y Bienestar".equals(pActividad) && "Airbnb".equals(pAlojamiento)) {
//                                destinoA = "Punta Cana";
//                                destinoE = "Algarve";
//                            }
//                            break;
//                    }
//                }
//                break;
//            // Si el destino es Montaña
//            case "Montaña":
//                if ("Frío".equals(pClimatica) && "1-2 semanas".equals(dViaje)) {
//                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(pAlojamiento)) {
//                        if ("Cultura y Museos".equals(pActividad)) {
//                            destinoA = "Ushuaia";
//                            destinoE = "Reykjavik";
//                        } else if ("Relax y Bienestar".equals(pActividad)) {
//                            destinoA = "Aspen";
//                            destinoE = "Innsbruck";
//                        }
//                    } else if ("Menos de 30 años".equals(edad) && "Hostal o Albergue".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
//                        destinoA = "Bariloche";
//                        destinoE = "Interlaken";
//                    } else if ("30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
//                        destinoA = "Banff";
//                        destinoE = "Zermatt";
//                    }
//                } else if ("Templado".equals(pClimatica) && "1-2 semanas".equals(dViaje)) {
//                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
//                        destinoA = "Cusco";
//                        destinoE = "Granada";
//                    } else if ("Menos de 30 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad) && "Más de dos semanas".equals(dViaje)) {
//                        destinoA = "Machu Picchu";
//                        destinoE = "Chamonix";
//                    }
//                }
//                break;
//            // Si el destino es Ciudad
//            case "Ciudad":
//                if ("Caluroso".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "Más de 50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
//                    destinoA = "Los Angeles";
//                    destinoE = "Roma";
//                } else if ("Frío".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
//                    destinoA = "Toronto";
//                    destinoE = "Berlín";
//                } else if ("Templado".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "Cultura y Museos".equals(pActividad)) {
//                    if ("30-50 años".equals(edad) && "Hostal o Albergue".equals(pAlojamiento)) {
//                        destinoA = "Ciudad de México";
//                        destinoE = "Madrid";
//                    } else if ("Más de 50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento)) {
//                        destinoA = "Nueva York";
//                        destinoE = "París";
//                    }
//                } else if ("Templado".equals(pClimatica) && "Menos de una semana".equals(dViaje)) {
//                    if ("Menos de 30 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Relax y Bienestar".equals(pActividad)) {
//                        destinoA = "Miami";
//                        destinoE = "Viena";
//                    } else if ("30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
//                        destinoA = "Chicago";
//                        destinoE = "Londres";
//                    }
//                }
//                break;
//        }
//
//        // Si no se ha asignado ningún destino, sugerimos alternativas predeterminadas
//        if (destinoA.isEmpty()) {
//            destinoA = "Bora Bora";
//            destinoE = "Dubái";
//        }
//
//        // Crear el objeto con los destinos seleccionados
//        DestinationResponse destinationResponse = new DestinationResponse(destinoA, destinoE);
//
//        // Guardar los destinos de el usuario en la base de datos
//        //destinoRepository.save(destinoRequest);
//
//        // Asignamos los destinos
//        return destinationResponse;
//    }

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
//        return null;
//    }
}
