package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.contracts.request.ReportRequest;
import com.adventureAPI.AdventureAPI.contracts.responses.ReportResponse;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.services.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    private final ReportsService _reportsService;

    @Autowired
    public ReportsController(ReportsService _reportsService) {
        this._reportsService = _reportsService;
    }

    @PostMapping("/createReport")
    public ResponseEntity<ReportResponse> createReport(@RequestBody ReportRequest reportRequest) {
        ReportResponse reportResponse = _reportsService.saveAndFlush(reportRequest);
        if (reportResponse != null) {
            return ResponseEntity.ok(reportResponse);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getReportById/{id}")
    public ResponseEntity<?> getReportById(@PathVariable int id) {
        try {
            ReportResponse reportResponse = _reportsService.findByReportId(id);
            return ResponseEntity.ok(reportResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getReports")
    public ResponseEntity<?> getReports() {
        try {
            List<ReportResponse> reports = _reportsService.index();
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
