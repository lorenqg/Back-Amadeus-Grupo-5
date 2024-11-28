package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.contracts.request.ReportRequest;
import com.adventureAPI.AdventureAPI.contracts.responses.ReportResponse;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.repositories.ReportsRepository;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {
    private final ReportsRepository reportsRepository;
    private final UserService userService;
    private final UserQueryService userQueryService;
    private final UserRepository userRepository;

    public ReportsService(ReportsRepository reportsRepository, UserService userService, UserQueryService userQueryService, UserRepository userRepository) {
        this.reportsRepository = reportsRepository;
        this.userService = userService;
        this.userQueryService = userQueryService;
        this.userRepository = userRepository;
    }

    public List<ReportsEntity> index() {
        return reportsRepository.index();
    }

    public ReportsEntity getById(int id) {
        return reportsRepository.getById(id).orElse(null);
    }

    public ReportResponse saveAndFlush(ReportRequest reportRequest) {
        try {
            User user = userRepository.findById(reportRequest.getUserId().intValue())
                    .orElseThrow(() -> new Exception("User not found"));
            ReportsEntity report = new ReportsEntity();
            report.setReportTime(reportRequest.getReportTime());
            report.setNameReport(reportRequest.getNameReport());
            report.setUser(user);
            reportsRepository.saveAndFlush(report);

            reportRequest.getUserQueries().forEach(userQueryRequest -> {
                userQueryService.saveAndFlush(userQueryRequest, report);
            });

            ReportsEntity savedReport = reportsRepository.findById(report.getId())
                    .orElseThrow(() -> new Exception("Report not found after saving"));

            savedReport.setUserQueries(userQueryService.findByReportId(savedReport.getId()));

            return new ReportResponse(
                    savedReport.getId(),
                    savedReport.getReportTime(),
                    savedReport.getNameReport(),
                    userService.getById(savedReport.getUser().getId()),
                    userQueryService.findByReportId(savedReport.getId())
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
