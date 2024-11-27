package com.adventureAPI.AdventureAPI.models;

import java.util.List;

public class DestinationResponse {

    private String americaDestination;
    private String europaDestination;

    private List<DestinationInfo> destinationInfo;

    // Constructor
    public DestinationResponse(String americaDestination, String europaDestination, List<DestinationInfo> destinationInfo) {
        this.americaDestination = americaDestination;
        this.europaDestination = europaDestination;
        this.destinationInfo = destinationInfo;
    }

    // Getters and Setters

    public String getamericaDestination() {
        return americaDestination;
    }

    public void setamericaDestination(String americaDestination) {
        this.americaDestination = americaDestination;
    }

    public String geteuropaDestination() {
        return europaDestination;
    }

    public void seteuropaDestination(String europaDestination) {
        this.europaDestination = europaDestination;
    }

    public List<DestinationInfo> getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(List<DestinationInfo> destinationInfo) {
        this.destinationInfo = destinationInfo;
    }
}