package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.repositories.ReportsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    private final ReportsRepository _reportsRepository;

    public ReportsService(ReportsRepository reportsRepository){
        this._reportsRepository = reportsRepository;
    }

    public List<ReportsEntity> index() {
        return _reportsRepository.index();
    }

    public ReportsEntity getById(int id) {
        return _reportsRepository.getById(id).orElse(null);
    }

    public ReportsEntity saveAndFlush(ReportsEntity report) {
        return _reportsRepository.saveAndFlush(report);
    }

}
