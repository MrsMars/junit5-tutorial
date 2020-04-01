package com.aoher.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicSalaryCalculatorTest {

    private BasicSalaryCalculator salaryCalculator;

    @BeforeEach
    void setUp() {
        salaryCalculator = new BasicSalaryCalculator();
    }

    @Test
    void calculateWithValidSalaryTest() {
        double basicSalary = 4000;
        salaryCalculator.setBasicSalary(basicSalary);

        double expectedBasicSalary = basicSalary * 0.25;
        assertEquals(expectedBasicSalary, salaryCalculator.getSocialInsurance());

        double expectedAddSalary = basicSalary * 0.1;
        assertEquals(expectedAddSalary, salaryCalculator.getAdditionalBonus());

        double expectedGross = basicSalary + expectedBasicSalary + expectedAddSalary;
        assertEquals(expectedGross, salaryCalculator.getGrossSalary());
    }

    @Test
    void calculateWithInValidSalaryTest() {
        double basicSalary = -100;
        assertThrows(IllegalArgumentException.class, () -> salaryCalculator.setBasicSalary(basicSalary));
    }

    @Test
    void testGetBasicSalary() {
        double basicSalary = 4000;
        salaryCalculator.setBasicSalary(basicSalary);

        assertEquals(basicSalary, salaryCalculator.getBasicSalary());
    }

    @AfterEach
    void tearDown() {
        salaryCalculator = null;
    }
}