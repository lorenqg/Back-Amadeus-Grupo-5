package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.models.DestinationInfo;
import com.adventureAPI.AdventureAPI.models.DestinationRequest;
import com.adventureAPI.AdventureAPI.models.DestinationResponse;
import com.adventureAPI.AdventureAPI.repositories.DestinationInfoRepository;
import com.adventureAPI.AdventureAPI.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private final DestinationService destinationService;

    @Autowired
    private DestinationInfoRepository _destinoInfoRespository;


    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<DestinationInfo>> index() {
        List<DestinationInfo> destinoInfos = new DestinationService(_destinoInfoRespository).index();
        return new ResponseEntity<>(destinoInfos, HttpStatus.OK);
    }

    @PostMapping("/enviarDestino")
    public DestinationResponse enviarDestino(@RequestBody DestinationRequest destinationRequest) {

        return destinationService.enviarDestino(
                destinationRequest.getpDestino(),
                destinationRequest.getpClimatica(),
                destinationRequest.getpActividad(),
                destinationRequest.getpAlojamiento(),
                destinationRequest.getdViaje(),
                destinationRequest.getEdad()
        );
    }

    @PostMapping("/guardarDestino")
    public ResponseEntity<DestinationInfo> create(@RequestBody DestinationInfo destinoInfo) {
        DestinationInfo destinoCreated = new DestinationService(_destinoInfoRespository).create(destinoInfo);
        return new ResponseEntity<>(destinoCreated, HttpStatus.OK);
    }

    @GetMapping("/searchByName/{destino1}/{destino2}")
    public ResponseEntity<List<DestinationInfo>> searchByName(@PathVariable String destino1, @PathVariable String destino2) {
        List<DestinationInfo> destinosInfor = new DestinationService(_destinoInfoRespository).searchByName(destino1, destino2);
        if (destinosInfor.size() == 0) {
            return new ResponseEntity<>(destinosInfor, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinosInfor, HttpStatus.OK);
    }

    //Search by id
    @GetMapping("/searchById/{id}")
    public ResponseEntity<List<DestinationInfo>> searchById(@PathVariable int id) {
        List<DestinationInfo> destinoInfos = new DestinationService(_destinoInfoRespository).searchById(id);
        return new ResponseEntity<>(destinoInfos, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DestinationInfo> delete(@PathVariable int id) {
        DestinationInfo destinoInfoDeleted = new DestinationService(_destinoInfoRespository).delete(id);
        return new ResponseEntity<>(destinoInfoDeleted, HttpStatus.OK);
    }

}
