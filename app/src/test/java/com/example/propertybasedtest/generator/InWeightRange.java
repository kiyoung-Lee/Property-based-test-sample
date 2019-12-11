package com.example.propertybasedtest.generator;

import com.pholser.junit.quickcheck.generator.GeneratorConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@GeneratorConfiguration
public @interface InWeightRange {
    int minWeight() default 0;

    int maxWeight() default Integer.MAX_VALUE;
}
