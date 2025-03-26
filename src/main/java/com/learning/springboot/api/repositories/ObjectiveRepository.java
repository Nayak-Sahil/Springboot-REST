package com.learning.springboot.api.repositories;

import com.learning.springboot.api.entities.ObjectivesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This interface provides CRUD operations for the "ObjectivesEntity" class with a String type primary key.
public interface ObjectiveRepository extends JpaRepository<ObjectivesEntity, String> {
}
