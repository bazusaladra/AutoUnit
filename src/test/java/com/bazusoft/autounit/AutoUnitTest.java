package com.bazusoft.autounit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by BSaladra on 31.12.2016.
 */
public class AutoUnitTest {


    @Test
    public void shouldListFieldsOfGivenObject() {

        AutoUnit autoUnit = new AutoUnit(TestClass.class);
        List<MockField> mockFields = autoUnit.getMockFields();

        List<MockField> expectedFields = Arrays.asList(
                new MockField(Random.class, "random")
        );

        assertEquals(expectedFields, mockFields);
    }

    @Test
    public void shouldGenerateSourceCodeForTestClass() {

        AutoUnit autoUnit = new AutoUnit(TestClass.class);
        String sourceCode = autoUnit.generateSourceCodeForTestClass();

        assertEquals("", sourceCode);

    }
}
