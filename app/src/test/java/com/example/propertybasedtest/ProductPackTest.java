package com.example.propertybasedtest;

import com.example.propertybasedtest.generator.InWeightRange;
import com.example.propertybasedtest.generator.ProductPackGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static com.example.propertybasedtest.Sample.MAX_DELIVERY_COSTS;
import static com.example.propertybasedtest.Sample.MIN_DELIVERY_COSTS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(JUnitQuickcheck.class)
public class ProductPackTest {

    @Property
    public void test1(@From(ProductPackGenerator.class) @InWeightRange(minWeight = 21) ProductPack productPack){
        assertThat(productPack.deliveryCost(),
                equalTo(MAX_DELIVERY_COSTS));
    }

    @Property
    public void test2(@From(ProductPackGenerator.class) @InWeightRange(maxWeight = 20) ProductPack productPack){
        assertThat(productPack.deliveryCost(),
                equalTo(MIN_DELIVERY_COSTS));
    }

}