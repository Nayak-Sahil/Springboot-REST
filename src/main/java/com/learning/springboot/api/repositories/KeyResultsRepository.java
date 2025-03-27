package com.learning.springboot.api.repositories;

import com.learning.springboot.api.entities.KeyResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyResultsRepository extends JpaRepository<KeyResultsEntity, String> {
}
