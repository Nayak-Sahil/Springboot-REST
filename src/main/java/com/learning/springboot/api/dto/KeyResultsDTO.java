package com.learning.springboot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyResultsDTO {
    private String title;
    private int initialValue;
    private int currentValue;
    private int targetValue;
    private String metric;
    private String objectiveId;
}
