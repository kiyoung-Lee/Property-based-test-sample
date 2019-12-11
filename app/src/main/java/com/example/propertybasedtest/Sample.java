package com.example.propertybasedtest;

import java.util.UUID;

public class Sample {

    private UUID uuid;
    private int weight;
    private String name;

    public static final double MAX_DELIVERY_COSTS = 4.99;
    public static final double MIN_DELIVERY_COSTS = 1.99;

    public Sample(UUID uuid, int weight, String name) throws IllegalAccessException {
        this.uuid = uuid;
        this.name = name;

        if(weight > 0) {
            this.weight = weight;
        }else {
            throw new IllegalAccessException();
        }
    }

    public double getDeliveryCost(){
        if(weight > 20){
            return MAX_DELIVERY_COSTS;
        }

        return MIN_DELIVERY_COSTS;
    }
}
