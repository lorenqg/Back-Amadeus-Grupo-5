package com.adventureAPI.AdventureAPI.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reports")
public class ReportsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reportTime;
    private String nameReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

        @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserQueryEntity> userQueries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getNameReport() {
        return nameReport;
    }

    public void setNameReport(String nameReport) {
        this.nameReport = nameReport;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<UserQueryEntity> getUserQueries() {
        return userQueries;
    }

    public void setUserQueries(List<UserQueryEntity> userQueries) {
        this.userQueries = userQueries;
    }

}
