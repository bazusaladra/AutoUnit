package com.bazusoft.autounit.acceptance;

import com.bazusoft.autounit.AutoUnit;
import com.bazusoft.autounit.TestClass;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.mockito.internal.util.StringJoiner;
import org.mockito.internal.util.io.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by BSaladra on 31.12.2016.
 */
public class AutoUnitAcceptanceTest {


    @Test
    public void shouldGenerateTestClass() throws IOException {

        AutoUnit autoUnit = new AutoUnit(TestClass.class);
        File outputFile = new File(TestClass.class.getSimpleName() + "Test.java");
        autoUnit.generateTestClass(outputFile);

        String testClass = IOUtils.toString(new FileInputStream(outputFile));

        String expectedTestClass = IOUtils.toString(
                ClassLoader.getSystemClassLoader().getResourceAsStream("TestClassTest.java")
        );

        assertEquals(expectedTestClass, testClass);
    }
}
