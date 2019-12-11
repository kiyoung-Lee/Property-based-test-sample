package com.example.propertybasedtest.generator;

import com.example.propertybasedtest.Product;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.UUID;

public class ProductGenerator extends Generator<Product> {

    private int maxWeight = Integer.MAX_VALUE;
    private int minWeight = 1;

    public ProductGenerator(){
        super(Product.class);
    }

    @Override
    public Product generate(SourceOfRandomness random, GenerationStatus status) {
        UUID uuid = gen().make(UUIDGenerator.class).generate(random, status);

        NonNegativeIntsGenerator nonNegativeIntsGenerator = gen().make(NonNegativeIntsGenerator.class);
        nonNegativeIntsGenerator.configure(minWeight, maxWeight);
        int weight = nonNegativeIntsGenerator.generate(random, status);

        String name = gen().make(MyStringGenerator.class).generate(random, status);

        try {
            return new Product(uuid, weight, name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void configureMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
    }
}
