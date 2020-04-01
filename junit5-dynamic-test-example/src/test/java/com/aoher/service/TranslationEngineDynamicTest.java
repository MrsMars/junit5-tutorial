package com.aoher.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TranslationEngineDynamicTest {

    private static final String TEST_NAME_FORMAT = "Test tranlate %s";

    private static List<String> inPhrases;
    private static List<String> outPhrases;

    private TranslatorEngine translatorEngine;

    @BeforeAll
    static void setUpClass() {
        inPhrases = new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        outPhrases = new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));
    }

    @BeforeEach
    void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    public void translateDynamicTestsRaw() {
        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        IntStream.range(0, inPhrases.size()).forEach(i -> {
            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

            String testName = String.format(TEST_NAME_FORMAT, phr);
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testName, exec);
            dynamicTests.add(dynamicTest);
        });
    }

    @Disabled
    public Collection<DynamicTest> translateDynamicTests() {
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        IntStream.range(0, inPhrases.size()).forEach(i -> {
            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            Executable exec = () -> assertEquals(outPhr, translatorEngine.translate(phr));

            String testName = String.format(TEST_NAME_FORMAT, phr);
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testName, exec);
            dynamicTests.add(dynamicTest);
        });

        return dynamicTests;
    }

    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {
        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest(
                String.format(TEST_NAME_FORMAT, phrs),
                () -> {
                    int idx = inPhrases.indexOf(phrs);
                    assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
                })
        );
    }

    @Disabled
    public Iterator<DynamicTest> translateDynamicTestsFromIterator() {
        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest(
                String.format(TEST_NAME_FORMAT, phrs),
                () -> {
                    int idx = inPhrases.indexOf(phrs);
                    assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
                })
        ).iterator();
    }

    public Iterable<DynamicTest> translateDynamicTestsFromIterate() {
        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest(
                String.format(TEST_NAME_FORMAT, phrs),
                () -> {
                    int idx = inPhrases.indexOf(phrs);
                    assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
                })
        ).collect(Collectors.toList());
    }
}