package com.learning.springboot.api.database;

public class Production implements Database {
    @Override
    public String checkConnection() {
        return "Database connection established";
    }
}
