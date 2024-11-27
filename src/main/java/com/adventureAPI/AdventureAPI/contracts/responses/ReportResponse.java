package com.adventureAPI.AdventureAPI.contracts.responses;

import com.adventureAPI.AdventureAPI.contracts.request.UserQueryRequest;

import java.util.List;

public class ReportResponse {

    private String reportTime;
    private String nameReport;
    private Long userId;

        private List<UserQueryRequest> userQueries;

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
