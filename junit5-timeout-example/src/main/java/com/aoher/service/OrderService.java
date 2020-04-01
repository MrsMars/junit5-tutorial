package com.aoher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void doPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void printShippingLabel() {
        try {
            Thread.sleep(20000);// 20 seconds
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
