package com.learning.springboot.api.services;

import com.learning.springboot.api.dto.ObjectivesDTO;
import com.learning.springboot.api.entities.ObjectivesEntity;
import com.learning.springboot.api.repositories.ObjectiveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjectiveService {

    private final ObjectiveRepository repository;
    private final ModelMapper mapper;

    public ObjectiveService(ObjectiveRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ObjectivesDTO> getAllObjectives() {
        List<ObjectivesEntity> objectivesEntities = repository.findAll();
        return objectivesEntities.stream().map(objectivesEntity ->  mapper.map(objectivesEntity, ObjectivesDTO.class)).collect(Collectors.toList());
    }

    public ObjectivesDTO insertObjective(ObjectivesDTO data) {
        ObjectivesEntity insertedObjective = repository.save(mapper.map(data, ObjectivesEntity.class));
        return mapper.map(insertedObjective, ObjectivesDTO.class);
    }

    public void deleteObjective(String id) {
        repository.deleteById(id);
    }

    public ObjectivesDTO getObjective(String id) {
        Optional<ObjectivesEntity> foundObjective = repository.findById(id);
        if (foundObjective.isPresent()) {
            return mapper.map(foundObjective.get(), ObjectivesDTO.class);
        }
        return null;
    }
}
