package com.example.propertybasedtest;

import java.util.List;
import java.util.UUID;

public class ProductPack {

    private static final double MAX_DELIVERY_COSTS = 4.99;
    private static final double MIN_DELIVERY_COSTS = 1.99;

    private UUID uuid;
    private List<Product> productList;

    public ProductPack(UUID uuid, List<Product> productList) {
        this.uuid = uuid;
        this.productList = productList;
    }

    public double deliveryCost(){
        if(weight() > 20){
            return MAX_DELIVERY_COSTS;
        }else {
            return MIN_DELIVERY_COSTS;
        }
    }

    private int weight(){
        int sum = 0;
        for(Product product : productList){
            sum += (int)product.getWeight();
        }

        return sum;
    }
}
