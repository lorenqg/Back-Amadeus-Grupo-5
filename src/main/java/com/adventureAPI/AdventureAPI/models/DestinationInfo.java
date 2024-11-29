package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "destination_info")
public class DestinationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreDestino;
    private String pais;
    private String idioma;
    private String lugarImperdible;
    private String comidaTipica;
    private String img;
    private String continente;

    @ManyToOne
    @JoinColumn(name = "destination_options")
    private DestinationOptions destinationOptions;

    @ManyToOne
    @JoinColumn(name = "destination_entity_id")
    private DestinationEntity destinationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLugarImperdible() {
        return lugarImperdible;
    }

    public void setLugarImperdible(String lugarImperdible) {
        this.lugarImperdible = lugarImperdible;
    }

    public String getComidaTipica() {
        return comidaTipica;
    }

    public void setComidaTipica(String comidaTipica) {
        this.comidaTipica = comidaTipica;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}