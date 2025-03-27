package com.learning.springboot.api.entities;

import com.learning.springboot.api.dto.ObjectivesDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "KeyResults")
public class KeyResultsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private int initialValue;
    private int currentValue;
    private int targetValue;
    private String metric;

    @ManyToOne
    @JoinColumn(name = "objectiveId")
    private ObjectivesEntity objectivesEntity;
}
