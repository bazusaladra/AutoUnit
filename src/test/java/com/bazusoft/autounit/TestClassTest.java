package com.bazusoft.autounit;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestClassTest {


    @Test
    public void isEvenTestNo1() {

        TestClass testClass = new TestClass();

        boolean result = testClass.isEven();

        assertTrue(result);

    }

}