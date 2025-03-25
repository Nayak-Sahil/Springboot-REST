package com.learning.springboot.api.services;

import com.learning.springboot.api.dto.ObjectivesDTO;
import com.learning.springboot.api.repositories.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectiveService {

    @Autowired
    ObjectiveRepository repository;

    public List<ObjectivesDTO> getAllObjectives() {
        return repository.get();
    }

    public ObjectivesDTO insertObjective(ObjectivesDTO data) {
        return repository.insert(data);
    }

    public ObjectivesDTO deleteObjective(String id) {
        return repository.delete(id);
    }

    public ObjectivesDTO getObjective(String id) {
        return repository.get(id);
    }
}
