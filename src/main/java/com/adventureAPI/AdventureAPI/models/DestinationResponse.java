package com.adventureAPI.AdventureAPI.models;

public class DestinationResponse {

    private String destinoA;
    private String destinoE;

    // Constructor
    public DestinationResponse(String destinoA, String destinoE) {
        this.destinoA = destinoA;
        this.destinoE = destinoE;
    }

    // Getters and Setters

    public String getDestinoA() {
        return destinoA;
    }

    public void setDestinoA(String destinoA) {
        this.destinoA = destinoA;
    }

    public String getDestinoE() {
        return destinoE;
    }

    public void setDestinoE(String destinoE) {
        this.destinoE = destinoE;
    }
}