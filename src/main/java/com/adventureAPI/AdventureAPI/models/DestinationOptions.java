package com.adventureAPI.AdventureAPI.models;

import com.adventureAPI.AdventureAPI.models.enums.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "destination_options")
public class DestinationOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Destination destination;

    @Enumerated(EnumType.STRING)
    private Weather weather;

    @Enumerated(EnumType.STRING)
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private Accommodation accommodation;

    @Enumerated(EnumType.STRING)
    private TravelDuration travelDuration;

    @Enumerated(EnumType.STRING)
    private Age age;

    private String nameAmericaDestination;
    private String nameEuropaDestination;

    @OneToMany(mappedBy = "destinationOptions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DestinationInfo> destinationInfo;

    public DestinationOptions() {
    }

    public DestinationOptions(Destination destination, Weather weather, Activity activity, Accommodation accommodation, TravelDuration travelDuration, Age age, String nameAmericaDestination, String nameEuropaDestination) {
        this.destination = destination;
        this.weather = weather;
        this.activity = activity;
        this.accommodation = accommodation;
        this.travelDuration = travelDuration;
        this.age = age;
        this.nameAmericaDestination = nameAmericaDestination;
        this.nameEuropaDestination = nameEuropaDestination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public TravelDuration getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(TravelDuration travelDuration) {
        this.travelDuration = travelDuration;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getNameAmericaDestination() {
        return nameAmericaDestination;
    }

    public void setNameAmericaDestination(String nameAmericaDestination) {
        this.nameAmericaDestination = nameAmericaDestination;
    }

    public String getNameEuropaDestination() {
        return nameEuropaDestination;
    }

    public void setNameEuropaDestination(String nameEuropaDestination) {
        this.nameEuropaDestination = nameEuropaDestination;
    }

    public List<DestinationInfo> getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(List<DestinationInfo> destinationInfo) {
        this.destinationInfo = destinationInfo;
    }
}
