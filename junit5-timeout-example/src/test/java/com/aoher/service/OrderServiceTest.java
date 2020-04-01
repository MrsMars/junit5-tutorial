package com.aoher.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    @Disabled
    public void doPaymentNotExceed15Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(15), orderService::doPayment);
    }

    @Test
    @Disabled
    public void doPaymentExceed5Seconds() {
        OrderService orderService = new OrderService();
        assertTimeout(ofSeconds(5), orderService::doPayment,
                "The doPayment method take more than 5 seconds");
    }

    @Test
    @Disabled
    public void printShippingLabelExceeded15SecondsWithPreemptiveTermination() {
        OrderService orderService = new OrderService();
        assertTimeoutPreemptively(ofSeconds(15), orderService::printShippingLabel,
                "The printShippingLabel method took more than 15 seconds and was aborted.");
    }
}