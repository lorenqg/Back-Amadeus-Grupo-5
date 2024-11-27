package com.adventureAPI.AdventureAPI.models;

import java.util.List;

public class DestinationResponse {

    private String destinoA;
    private String destinoE;

    private List<DestinationInfo> destinationInfo;

    // Constructor
    public DestinationResponse(String destinoA, String destinoE, List<DestinationInfo> destinationInfo) {
        this.destinoA = destinoA;
        this.destinoE = destinoE;
        this.destinationInfo = destinationInfo;
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

    public List<DestinationInfo> getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(List<DestinationInfo> destinationInfo) {
        this.destinationInfo = destinationInfo;
    }
}