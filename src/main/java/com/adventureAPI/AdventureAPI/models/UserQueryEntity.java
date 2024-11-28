// UserQueryEntity.java
package com.adventureAPI.AdventureAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    @JsonIgnore
    private ReportsEntity report;

    public UserQueryEntity(int id, String pDestino, String pClimatica, String pActividad, String pAlojamiento, String dViaje, String edad, User user, ReportsEntity report) {
        this.id = id;
        this.pDestino = pDestino;
        this.pClimatica = pClimatica;
        this.pActividad = pActividad;
        this.pAlojamiento = pAlojamiento;
        this.dViaje = dViaje;
        this.edad = edad;
        this.user = user;
        this.report = report;
    }

    public UserQueryEntity() {

    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReportsEntity getReport() {
        return report;
    }

    public void setReport(ReportsEntity report) {
        this.report = report;
    }
}