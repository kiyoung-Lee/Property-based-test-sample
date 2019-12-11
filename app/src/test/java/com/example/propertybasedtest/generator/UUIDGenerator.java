package com.example.propertybasedtest.generator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.UUID;

public class UUIDGenerator extends Generator<UUID> {

    public UUIDGenerator(){
        super(UUID.class);
    }

    @Override
    public UUID generate(SourceOfRandomness random, GenerationStatus status) {
        return UUID.randomUUID();
    }
}
