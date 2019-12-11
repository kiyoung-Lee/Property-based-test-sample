package com.example.propertybasedtest;

import java.util.UUID;

public class Product {

    private UUID uuid;
    private int weight;
    private String name;

    public Product(UUID uuid, int weight, String name) throws IllegalAccessException {
        this.uuid = uuid;
        this.name = name;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }
}
