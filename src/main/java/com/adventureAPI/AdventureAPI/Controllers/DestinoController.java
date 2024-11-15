package com.adventureAPI.AdventureAPI.Controllers;

import com.adventureAPI.AdventureAPI.models.DestinoInfo;
import com.adventureAPI.AdventureAPI.models.DestinoRequest;
import com.adventureAPI.AdventureAPI.models.DestinoResponse;
import com.adventureAPI.AdventureAPI.repositories.DestinoInfoRepository;
import com.adventureAPI.AdventureAPI.Services.DestinoService;
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
    private DestinoInfoRepository destinoInfoRespository;


    @Autowired
    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
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
        DestinoInfo destinoCreated = new DestinoService(destinoInfoRespository).create(destinoInfo);
        return new ResponseEntity<>(destinoCreated, HttpStatus.OK);
    }

    @GetMapping("/searchName/{destino1}/{destino2}")
    public ResponseEntity<List<DestinoInfo>> searchByName(@RequestParam String destino1, @RequestParam String destino2) {
        List<DestinoInfo> destinosInfor = new DestinoService(destinoInfoRespository).searchByName(destino1, destino2);
        if (destinosInfor.size() == 0) {
            return new ResponseEntity<>(destinosInfor, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinosInfor, HttpStatus.OK);
    }






}
