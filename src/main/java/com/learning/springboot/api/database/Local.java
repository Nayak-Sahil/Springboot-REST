package com.learning.springboot.api.database;

public class Local implements Database {
    @Override
    public String checkConnection() {
        return "Database connection established";
    }
}

