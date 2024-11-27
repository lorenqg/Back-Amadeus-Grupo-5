package com.adventureAPI.AdventureAPI.controllers;

import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.services.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    private final ReportsService _reportsService;

    @Autowired
    public ReportsController(ReportsService reportsService){
        this._reportsService = reportsService;
    }

    @PostMapping("/createReport")
    public ResponseEntity<?> createReport(@RequestBody ReportsEntity report) {
        try {
            return ResponseEntity.ok(_reportsService.saveAndFlush(report));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getReportById/{id}")
    public ResponseEntity<?> getReportById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(_reportsService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getReports")
    public ResponseEntity<?> getReports() {
        try {
            List<ReportsEntity> reports = _reportsService.index();
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
