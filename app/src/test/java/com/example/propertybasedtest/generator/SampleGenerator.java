package com.example.propertybasedtest.generator;

import com.example.propertybasedtest.Sample;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.UUID;

public class SampleGenerator extends Generator<Sample> {

    private int maxInt = Integer.MAX_VALUE;
    private int minInt = 0;

    public SampleGenerator(){
        super(Sample.class);
    }

    @Override
    public Sample generate(SourceOfRandomness random, GenerationStatus status) {
        UUID uuid = gen().make(UUIDGenerator.class).generate(random, status);
        NonNegativeIntsGenerator nonNegativeIntsGenerator = gen().make(NonNegativeIntsGenerator.class);
        nonNegativeIntsGenerator.configure(minInt, maxInt);
        int weight = nonNegativeIntsGenerator.generate(random, status);
        String name = gen().make(MyStringGenerator.class).generate(random, status);
        try {
            return new Sample(uuid, weight, name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void configure(InRange range) {
       this.minInt = range.minInt();
       this.maxInt = range.maxInt();
    }
}
