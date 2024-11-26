package com.adventureAPI.AdventureAPI.models;

import com.adventureAPI.AdventureAPI.models.enums.*;
import jakarta.persistence.*;

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

    private String destinoA;
    private String destinoE;


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

    public String getdestinoA() {
        return destinoA;
    }

    public void setdestinoA(String destinoA) {
        this.destinoA = destinoA;
    }

    public String getdestinoE() {
        return destinoE;
    }

    public void setdestinoE(String destinoE) {
        this.destinoE = destinoE;
    }
}
