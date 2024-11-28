package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.contracts.request.UserQueryRequest;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.models.User;
import com.adventureAPI.AdventureAPI.models.UserQueryEntity;
import com.adventureAPI.AdventureAPI.repositories.UserQueryRepository;
import com.adventureAPI.AdventureAPI.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryService {

    private final UserQueryRepository _userQueryRepository;
    private final UserRepository _userRepository;

    public UserQueryService(UserQueryRepository userQueryRepository, UserRepository userRepository) {
        this._userQueryRepository = userQueryRepository;
        this._userRepository = userRepository;
    }

    @Transactional
    public UserQueryEntity saveAndFlush(UserQueryRequest userQuery, ReportsEntity report) throws Exception {
        User user = _userRepository.findById(report.getUser().getId())
                .orElseThrow(() -> new Exception("User not found"));

        UserQueryEntity entity = new UserQueryEntity();
        entity.setpDestino(userQuery.getpDestino());
        entity.setpClimatica(userQuery.getpClimatica());
        entity.setpActividad(userQuery.getpActividad());
        entity.setpAlojamiento(userQuery.getpAlojamiento());
        entity.setdViaje(userQuery.getdViaje());
        entity.setEdad(userQuery.getEdad());
        entity.setReport(report); // Ensure the report is set
        entity.setUser(user); // Ensure the user is set
        return _userQueryRepository.saveAndFlush(entity);
    }

    public UserQueryEntity getById(int id) {
        return _userQueryRepository.getById(id);
    }

    public List<UserQueryEntity> index() {
        return _userQueryRepository.index();
    }

    public List<UserQueryEntity> findByReportId(int id) {
        try {
            return _userQueryRepository.findById(id)
                    .map(UserQueryEntity::getReport)
                    .orElse(null) != null ? _userQueryRepository.findByReportId(id) : null;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user queries by report id", e);
        }
    }
}