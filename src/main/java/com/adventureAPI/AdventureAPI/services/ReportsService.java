package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.contracts.request.ReportRequest;
import com.adventureAPI.AdventureAPI.contracts.responses.ReportResponse;
import com.adventureAPI.AdventureAPI.contracts.responses.UserQueryResponse;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.models.UserEntity;
import com.adventureAPI.AdventureAPI.models.UserQueryEntity;
import com.adventureAPI.AdventureAPI.repositories.ReportsRepository;
import com.adventureAPI.AdventureAPI.repositories.UserQueryRepository;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportsService {
    private final ReportsRepository reportsRepository;
    private final UserQueryRepository userQueryRepository;
    private final UserRepository userRepository;

    public ReportsService(ReportsRepository reportsRepository, UserQueryRepository userQueryRepository, UserRepository userRepository) {
        this.reportsRepository = reportsRepository;
        this.userQueryRepository = userQueryRepository;
        this.userRepository = userRepository;
    }

    public List<ReportResponse> index() {
        List<ReportsEntity> reports = reportsRepository.index();
        return reports.stream().map(report -> {
            List<UserQueryEntity> userQueryEntities = userQueryRepository.findByReportId(report.getId());

            List<UserQueryResponse> userQueryResponses = userQueryEntities.stream()
                    .map(userQuery -> new UserQueryResponse(
                            userQuery.getId(),
                            userQuery.getpDestino(),
                            userQuery.getpClimatica(),
                            userQuery.getpActividad(),
                            userQuery.getpAlojamiento(),
                            userQuery.getdViaje(),
                            userQuery.getEdad()
                    ))
                    .collect(Collectors.toList());

            // Convert UserEntity to User
            User user = new User();
            user.setId(report.getUser().getId());
            user.setName(report.getUser().getName());
            user.setEmail(report.getUser().getEmail());

            return new ReportResponse(
                    report.getId(),
                    report.getReportTime(),
                    report.getNameReport(),
                    user,
                    userQueryResponses
            );
        }).collect(Collectors.toList());
    }

    public ReportResponse findByReportId(int id) {
        try {
            ReportsEntity report = reportsRepository.findById(id)
                    .orElseThrow(() -> new Exception("Report not found"));

            List<UserQueryEntity> userQueryEntities = userQueryRepository.findByReportId(id);

            List<UserQueryResponse> userQueryResponses = userQueryEntities.stream()
                    .map(userQuery -> new UserQueryResponse(
                            userQuery.getId(),
                            userQuery.getpDestino(),
                            userQuery.getpClimatica(),
                            userQuery.getpActividad(),
                            userQuery.getpAlojamiento(),
                            userQuery.getdViaje(),
                            userQuery.getEdad()
                    ))
                    .collect(Collectors.toList());

            // Convert UserEntity to User
            User user = new User();
            user.setId(report.getUser().getId());
            user.setName(report.getUser().getName());
            user.setEmail(report.getUser().getEmail());

            return new ReportResponse(
                    report.getId(),
                    report.getReportTime(),
                    report.getNameReport(),
                    user,
                    userQueryResponses
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ReportResponse saveAndFlush(ReportRequest reportRequest) {
        try {
            User userEntity = userRepository.findById(reportRequest.getUserId().intValue())
                    .orElseThrow(() -> new Exception("User not found"));
            ReportsEntity report = new ReportsEntity();
            report.setReportTime(reportRequest.getReportTime());
            report.setNameReport(reportRequest.getNameReport());
            report.setUser(userEntity);
            reportsRepository.saveAndFlush(report);

            // Save user queries
            List<UserQueryEntity> userQueryEntities = reportRequest.getUserQueries().stream().map(userQueryRequest -> {
                UserQueryEntity userQueryEntity = new UserQueryEntity();
                userQueryEntity.setpDestino(userQueryRequest.getpDestino());
                userQueryEntity.setpClimatica(userQueryRequest.getpClimatica());
                userQueryEntity.setpActividad(userQueryRequest.getpActividad());
                userQueryEntity.setpAlojamiento(userQueryRequest.getpAlojamiento());
                userQueryEntity.setdViaje(userQueryRequest.getdViaje());
                userQueryEntity.setEdad(userQueryRequest.getEdad());
                userQueryEntity.setReport(report);
                userQueryEntity.setUser(userEntity);
                return userQueryEntity;
            }).collect(Collectors.toList());

            userQueryRepository.saveAll(userQueryEntities);

            ReportsEntity savedReport = reportsRepository.findById(report.getId())
                    .orElseThrow(() -> new Exception("Report not found after saving"));

            List<UserQueryResponse> userQueryResponses = userQueryEntities.stream()
                    .map(userQuery -> new UserQueryResponse(
                            userQuery.getId(),
                            userQuery.getpDestino(),
                            userQuery.getpClimatica(),
                            userQuery.getpActividad(),
                            userQuery.getpAlojamiento(),
                            userQuery.getdViaje(),
                            userQuery.getEdad()
                    ))
                    .collect(Collectors.toList());

            // Convert UserEntity to User
            User user = new User();
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            user.setEmail(userEntity.getEmail());

            return new ReportResponse(
                    savedReport.getId(),
                    savedReport.getReportTime(),
                    savedReport.getNameReport(),
                    user,
                    userQueryResponses
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
