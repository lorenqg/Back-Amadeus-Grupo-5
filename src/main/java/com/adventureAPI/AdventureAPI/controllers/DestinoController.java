package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.models.DestinoInfo;
import com.adventureAPI.AdventureAPI.models.DestinoRequest;
import com.adventureAPI.AdventureAPI.models.DestinoResponse;
import com.adventureAPI.AdventureAPI.repositories.DestinoInfoRepository;
import com.adventureAPI.AdventureAPI.services.DestinoService;
import com.adventureAPI.AdventureAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DestinoController {

    @Autowired
    private final DestinoService destinoService;

    @Autowired
    private DestinoInfoRepository _destinoInfoRespository;


    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<DestinoInfo>> index() {
        List<DestinoInfo> destinoInfos = new DestinoService(_destinoInfoRespository).index();
        return new ResponseEntity<>(destinoInfos, HttpStatus.OK);
    }

    @PostMapping("/enviarDestino")
    public DestinoResponse enviarDestino(@RequestBody DestinoRequest destinoRequest) {

        return destinoService.enviarDestino(
                destinoRequest.getpDestino(),
                destinoRequest.getpClimatica(),
                destinoRequest.getpActividad(),
                destinoRequest.getpAlojamiento(),
                destinoRequest.getdViaje(),
                destinoRequest.getEdad()
        );
    }

    @PostMapping("/guardarDestino")
    public ResponseEntity<DestinoInfo> create(@RequestBody DestinoInfo destinoInfo) {
        DestinoInfo destinoCreated = new DestinoService(_destinoInfoRespository).create(destinoInfo);
        return new ResponseEntity<>(destinoCreated, HttpStatus.OK);
    }

    @GetMapping("/searchByName/{destino1}/{destino2}")
    public ResponseEntity<List<DestinoInfo>> searchByName(@PathVariable String destino1, @PathVariable String destino2) {
        List<DestinoInfo> destinosInfor = new DestinoService(_destinoInfoRespository).searchByName(destino1, destino2);
        if (destinosInfor.size() == 0) {
            return new ResponseEntity<>(destinosInfor, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinosInfor, HttpStatus.OK);
    }

    //Search by id
    @GetMapping("/searchById/{id}")
    public ResponseEntity<List<DestinoInfo>> searchById(@PathVariable int id) {
        List<DestinoInfo> destinoInfos = new DestinoService(_destinoInfoRespository).searchById(id);
        return new ResponseEntity<>(destinoInfos, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DestinoInfo> delete(@PathVariable int id) {
        DestinoInfo destinoInfoDeleted = new DestinoService(_destinoInfoRespository).delete(id);
        return new ResponseEntity<>(destinoInfoDeleted, HttpStatus.OK);
    }

}
