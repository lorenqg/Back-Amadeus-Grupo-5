// UserEntity.java
package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class UserEntity {
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportsEntity> reports;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserQueryEntity> userQuery;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DestinationInfo> destinoInfo;

    public UserEntity() {
    }

    public UserEntity(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserEntity(int id, String name, String email, List<ReportsEntity> reports, List<UserQueryEntity> userQuery, List<DestinationInfo> destinoInfo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.reports = reports;
        this.userQuery = userQuery;
        this.destinoInfo = destinoInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email ;
    }

    public List<ReportsEntity> getReports() {
        return reports;
    }

    public void setReports(List<ReportsEntity> reports) {
        this.reports = reports;
    }

    public List<UserQueryEntity> getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(List<UserQueryEntity> userQuery) {
        this.userQuery = userQuery;
    }

    public List<DestinationInfo> getDestinoInfo() {
        return destinoInfo;
    }

    public void setDestinoInfo(List<DestinationInfo> destinoInfo) {
        this.destinoInfo = destinoInfo;
    }
}