package com.adventureAPI.AdventureAPI.services;

import com.adventureAPI.AdventureAPI.contracts.request.UserQueryRequest;
import com.adventureAPI.AdventureAPI.models.ReportsEntity;
import com.adventureAPI.AdventureAPI.models.UserQueryEntity;
import com.adventureAPI.AdventureAPI.repositories.UserQueryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryService {

    private final UserQueryRepository _userQueryRepository;

    public UserQueryService(UserQueryRepository userQueryRepository){
        this._userQueryRepository = userQueryRepository;
    }

    @Transactional
    public UserQueryEntity saveAndFlush(UserQueryRequest userQuery, ReportsEntity report) {
        return _userQueryRepository.saveAndFlush(userQuery, report);
    }

    public UserQueryEntity getById(int id) {
        return _userQueryRepository.getById(id);
    }

    public List<UserQueryEntity> index() {
        return _userQueryRepository.index();
    }
}
