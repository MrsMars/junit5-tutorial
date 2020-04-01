package com.aoher.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class TranslationEngineJUnit4ParameterizedTest {

    private TranslatorEngine translatorEngine;

    private String actualValue;
    private String expectedValue;

    public TranslationEngineJUnit4ParameterizedTest(String actualValue, String expectedValue) {
        this.actualValue = actualValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static List<String[]> getParameters() {
        String[][] objects = new String[][] {
                { "Hello", "Bonjour" },
                { "Yes", "Oui" },
                { "No", "Non" }
        };
        return Arrays.asList(objects);
    }

    @Before
    public void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
    public void translate() {
        assertEquals(expectedValue, translatorEngine.translate(actualValue));
    }
}