package com.aoher.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TranslationEngineJUnit5ParameterizedTest {

    private TranslatorEngine translatorEngine;

    @Parameterized.Parameters
    static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of("Hello", "Bonjour"),
                Arguments.of("Yes", "Oui"),
                Arguments.of("No", "Non"));
    }

    @BeforeEach
    void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    void translate(String actualValue, String expectedValue) {
        assertEquals(expectedValue, translatorEngine.translate(actualValue));
    }
}