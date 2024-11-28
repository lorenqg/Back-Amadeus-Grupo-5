package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_query")
public class UserQueryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pDestino;
    private String pClimatica;
    private String pActividad;
    private String pAlojamiento;
    private String dViaje;
    private String edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private ReportsEntity report;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getpAlojamiento() {
        return pAlojamiento;
    }

    public void setpAlojamiento(String pAlojamiento) {
        this.pAlojamiento = pAlojamiento;
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

    public Object getReport() {
        return report;
    }
}