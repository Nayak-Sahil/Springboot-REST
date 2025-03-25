package com.learning.springboot.api.repositories;

import com.learning.springboot.api.dto.ObjectivesDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ObjectiveRepository {
    List<ObjectivesDTO> database = new ArrayList<ObjectivesDTO>();

    public List<ObjectivesDTO> get() {
        return database;
    }

    public ObjectivesDTO get(String id) {
        return database.stream().filter(obj -> obj.getId().equals(id)).findFirst().orElse(null);
    }

    public ObjectivesDTO insert(ObjectivesDTO data) {
        database.add(data);
        return data;
    }

    public ObjectivesDTO delete(String id) {
        ObjectivesDTO objectiveToBeDeleted = database.stream().filter(obj -> obj.getId().equals(id)).findFirst().orElse(null);
        database = database.stream().filter(obj -> !obj.getId().equals(id)).collect(Collectors.toList());
        return objectiveToBeDeleted;
    }
}
