// User.java
package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReportsEntity> reports;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserQueryEntity> userQuery;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DestinationInfo> destinoInfo;

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