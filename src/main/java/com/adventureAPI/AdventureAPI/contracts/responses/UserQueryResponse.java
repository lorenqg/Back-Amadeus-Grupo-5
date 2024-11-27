package com.adventureAPI.AdventureAPI.contracts.responses;

public class UserQueryResponse {

    private String pDestino;
    private String pClimatica;
    private String pActividad;
    private String dViaje;
    private String edad;

    public UserQueryResponse(String pDestino, String pClimatica, String pActividad, String dViaje, String edad) {
        this.pDestino = pDestino;
        this.pClimatica = pClimatica;
        this.pActividad = pActividad;
        this.dViaje = dViaje;
        this.edad = edad;
    }

    public String getpDestino() {
        return pDestino;
    }

    public void setpDestino(String pDestino) {
        this.pDestino = pDestino;
    }

    public String getpClimatica() {
        return pClimatica;
    }

    public void setpClimatica(String pClimatica) {
        this.pClimatica = pClimatica;
    }

    public String getpActividad() {
        return pActividad;
    }

    public void setpActividad(String pActividad) {
        this.pActividad = pActividad;
    }

    public String getdViaje() {
        return dViaje;
    }

    public void setdViaje(String dViaje) {
        this.dViaje = dViaje;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
