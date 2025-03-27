package com.learning.springboot.api.services;

import com.learning.springboot.api.dto.KeyResultsDTO;
import com.learning.springboot.api.entities.KeyResultsEntity;
import com.learning.springboot.api.entities.ObjectivesEntity;
import com.learning.springboot.api.repositories.KeyResultsRepository;
import com.learning.springboot.api.repositories.ObjectiveRepository;
import org.modelmapper.ModelMapper;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeyResultService {

    private final KeyResultsRepository repository;
    private final ObjectiveRepository objectiveRepository;
    private final ModelMapper mapper;

    public KeyResultService(KeyResultsRepository repository, ModelMapper mapper, ObjectiveRepository objectiveRepository, LocalContainerEntityManagerFactoryBean entityManagerFactory2, EntityManagerFactoryInfo entityManagerFactoryInfo) {
        this.repository = repository;
        this.mapper = mapper;
        this.objectiveRepository = objectiveRepository;
    }
    
    public List<KeyResultsDTO> getAllKeyResults() {
        List<KeyResultsEntity> keyResultsEntities = repository.findAll();
        return keyResultsEntities.stream().map(KeyResultsEntity ->  mapper.map(KeyResultsEntity, KeyResultsDTO.class)).collect(Collectors.toList());
    }

    public KeyResultsDTO insertKeyResult(KeyResultsDTO keyResultsDTO) {
        KeyResultsEntity keyResultsEntity = new KeyResultsEntity();
        keyResultsEntity.setTitle(keyResultsDTO.getTitle());
        keyResultsEntity.setInitialValue(keyResultsDTO.getInitialValue());
        keyResultsEntity.setCurrentValue(keyResultsDTO.getCurrentValue());
        keyResultsEntity.setTargetValue(keyResultsDTO.getTargetValue());
        keyResultsEntity.setMetric(keyResultsDTO.getMetric());

        ObjectivesEntity objective = objectiveRepository.findById(keyResultsDTO.getObjectiveId())
                .orElseThrow(() -> new RuntimeException("Objective not found with ID: " + keyResultsDTO.getObjectiveId()));

        // To define in which objective, you want to insert key-result
        keyResultsEntity.setObjectivesEntity(objective);

        repository.save(keyResultsEntity);

        return mapper.map(keyResultsEntity, KeyResultsDTO.class);
    }

    public void deleteKeyResult(String id) {
        repository.deleteById(id);
    }

    public KeyResultsDTO getKeyResultById(String id) {
        Optional<KeyResultsEntity> foundObjective = repository.findById(id);
        if (foundObjective.isPresent()) {
            return mapper.map(foundObjective.get(), KeyResultsDTO.class);
        }
        return null;
    }

}
