// DestinationEntity.java
package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "destination_response")
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String americaDestination;
    private String europaDestination;

    @OneToMany(mappedBy = "destinationEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DestinationInfo> destinationInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructor
    public DestinationEntity() {}

    public DestinationEntity(String americaDestination, String europaDestination, List<DestinationInfo> destinationInfo) {
        this.americaDestination = americaDestination;
        this.europaDestination = europaDestination;
        this.destinationInfo = destinationInfo;
    }

    public String getAmericaDestination() {
        return americaDestination;
    }

    public void setAmericaDestination(String americaDestination) {
        this.americaDestination = americaDestination;
    }

    public String getEuropaDestination() {
        return europaDestination;
    }

    public void setEuropaDestination(String europaDestination) {
        this.europaDestination = europaDestination;
    }

    public List<DestinationInfo> getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(List<DestinationInfo> destinationInfo) {
        this.destinationInfo = destinationInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}