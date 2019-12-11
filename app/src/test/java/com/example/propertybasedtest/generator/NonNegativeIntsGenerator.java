package com.example.propertybasedtest.generator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.Arrays;

public class NonNegativeIntsGenerator extends Generator<Integer> {
    private int maxInt = Integer.MAX_VALUE;
    private int minInt = 0;

    public NonNegativeIntsGenerator() {
        super(Arrays.asList(Integer.class, int.class));
    }

    public Integer generate(SourceOfRandomness random, GenerationStatus status) {
        return random.nextInt(minInt, maxInt);
    }

    public void configure(int minInt, int maxInt) {
        this.minInt = Math.abs(minInt);
        this.maxInt = maxInt;
    }

}
