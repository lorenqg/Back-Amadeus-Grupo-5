package com.adventureAPI.AdventureAPI.contracts.responses;

import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.models.UserQueryEntity;

import java.util.List;

public class ReportResponse {
    private int id;
    private String reportTime;
    private String nameReport;
    private User user;
    private List<UserQueryResponse> userQueries;

    public ReportResponse(String reportTime, String nameReport, User user, List<UserQueryResponse> userQueries) {
        this.reportTime = reportTime;
        this.nameReport = nameReport;
        this.user = user;
        this.userQueries = userQueries;
    }

    public ReportResponse() {

    }

    public ReportResponse(int id, String reportTime, String nameReport, User byId, List<UserQueryEntity> userQueries) {
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
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public List<UserQueryResponse> getUserQueries() {
        return userQueries;
    }

    public void setUserQueries(List<UserQueryResponse> userQueries) {
        this.userQueries = userQueries;
    }

    public static class Builder {
        private int id;
        private String reportTime;
        private String nameReport;
        private User user;
        private List<UserQueryResponse> userQueries;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder reportTime(String reportTime) {
            this.reportTime = reportTime;
            return this;
        }

        public Builder nameReport(String nameReport) {
            this.nameReport = this.nameReport;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder userQueries(List<UserQueryResponse> userQueries) {
            this.userQueries = userQueries;
            return this;
        }

        public ReportResponse build() {
            ReportResponse response = new ReportResponse();
            response.id = this.id;
            response.reportTime = this.reportTime;
            response.nameReport = this.nameReport;
            response.user = this.user;
            response.userQueries = this.userQueries;
            return response;
        }
    }
}
