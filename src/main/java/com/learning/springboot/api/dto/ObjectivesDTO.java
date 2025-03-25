package com.learning.springboot.api.dto;

public class ObjectivesDTO {
    private long id;
    private String objective;

    public ObjectivesDTO(long id, String objective) {
        this.id = id;
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
