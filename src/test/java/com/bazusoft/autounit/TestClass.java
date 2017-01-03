package com.bazusoft.autounit;

import java.util.Random;

/**
 * Created by BSaladra on 31.12.2016.
 */
public class TestClass {

    private static Integer seed = 0;

    private Random random = new Random(seed);

    public boolean isEven() {
        return random.nextInt() % 2 == 0;
    }
}