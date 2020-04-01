package com.aoher.util;

import static com.aoher.util.Constants.NEGATIVE_SALARY_EXCEPTION;

public class BasicSalaryCalculator {

    private double basicSalary;

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary < 0) {
            throw new IllegalArgumentException(NEGATIVE_SALARY_EXCEPTION);
        }
        this.basicSalary = basicSalary;
    }

    public double getGrossSalary() {
        return this.basicSalary + getSocialInsurance() + getAdditionalBonus();
    }

    public double getSocialInsurance() {
        return this.basicSalary * 25 / 100;
    }

    public double getAdditionalBonus() {
        return this.basicSalary / 10;
    }
}
