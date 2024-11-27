package com.adventureAPI.AdventureAPI.contracts.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.mapping.List;

public class ReportRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String reportTime;
    private String nameReport;
    private Long userId;

    private List<UserQueryRequest> userQueries;

    public ReportRequest(String reportTime, String nameReport, Long userId, List<UserQueryRequest> userQueries) {
        this.reportTime = reportTime;
        this.nameReport = nameReport;
        this.userId = userId;
        this.userQueries = userQueries;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UserQueryRequest> getUserQueries() {
        return userQueries;
    }

    public void setUserQueries(List<UserQueryRequest> userQueries) {
        this.userQueries = userQueries;
    }
}
