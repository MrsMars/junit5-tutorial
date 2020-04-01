package com.aoher.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
class TranslationEngineAnnotationParameterizedTest {

    private TranslatorEngine translatorEngine;

    @BeforeEach
    void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @DisplayName("Translate")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({ "Hello, Bonjour", "Yes, Oui", "No, Non"})
    void translate(String actualValue, String expectedValue) {
        assertEquals(expectedValue, translatorEngine.translate(actualValue));
    }
}