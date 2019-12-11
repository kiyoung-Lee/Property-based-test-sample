package com.example.propertybasedtest.generator;

import com.example.propertybasedtest.Product;
import com.example.propertybasedtest.ProductPack;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductPackGenerator extends Generator<ProductPack> {

    private int minWeight = 1;
    private int maxWeight = Integer.MAX_VALUE;

    public ProductPackGenerator() {
        super(ProductPack.class);
    }

    @Override
    public ProductPack generate(SourceOfRandomness random, GenerationStatus status) {
        UUID uuid = gen().make(UUIDGenerator.class).generate(random, status);
        List<Product> productList = generateProducts(random, status);
        return new ProductPack(uuid, productList);
    }

    private List<Product> generateProducts(SourceOfRandomness random, GenerationStatus status){
        ProductGenerator productGenerator = gen().make(ProductGenerator.class);
        List<Product> productList = new ArrayList<>();
        int randomTotalWeight = random.nextInt(minWeight, maxWeight);

        while (randomTotalWeight > 0){
            int maxWeight = random.nextInt(1, randomTotalWeight);
            productGenerator.configureMaxWeight(maxWeight);
            productList.add(productGenerator.generate(random, status));
            randomTotalWeight = randomTotalWeight - maxWeight;
        }

        return productList;
    }

    public void configure(InWeightRange range){
        this.minWeight = range.minWeight();
        this.maxWeight = range.maxWeight();
    }
}
