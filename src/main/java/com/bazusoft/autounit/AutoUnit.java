package com.bazusoft.autounit;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by BSaladra on 31.12.2016.
 */
public class AutoUnit {
    private final Class classUnderTest;

    public AutoUnit(Class classUnderTest) {

        this.classUnderTest = classUnderTest;
    }

    public List<MockField> getMockFields() {

        List<Field> fields = FieldUtils.getAllFieldsList(classUnderTest);

        return fields.stream()
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .map(field -> new MockField(field.getType(), field.getName()))
                .collect(Collectors.toList());
    }

    public void generateTestClass(File outputFile) throws IOException {

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("class");
        fileWriter.close();

    }

    public String generateSourceCodeForTestClass() {
        return "";
    }
}
