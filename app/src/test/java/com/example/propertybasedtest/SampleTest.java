package com.example.propertybasedtest;

import com.example.propertybasedtest.generator.SampleGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.UUID;

import static com.example.propertybasedtest.Sample.MAX_DELIVERY_COSTS;
import static com.example.propertybasedtest.Sample.MIN_DELIVERY_COSTS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnitQuickcheck.class)
public class SampleTest {


    @Property
    public void test1(UUID uuid, String name, @InRange(minInt = 21)int weight) throws IllegalAccessException {
        Sample sample = new Sample(uuid, weight, name);
        assertThat(sample.getDeliveryCost(), equalTo(MAX_DELIVERY_COSTS));
    }

    @Property
    public void test2(UUID uuid, String name, @InRange(minInt = 1, maxInt = 20)int weight) throws IllegalAccessException {
        Sample sample = new Sample(uuid, weight, name);
        assertThat(sample.getDeliveryCost(), equalTo(MIN_DELIVERY_COSTS));
    }

    @Property
    public void concatenationLength(String s1, String s2) {
        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }

    @Property
    public void generateTest(@InRange(minInt = 21) @From(SampleGenerator.class) Sample sample){
        assertThat(sample.getDeliveryCost(), equalTo(MAX_DELIVERY_COSTS));
    }
}