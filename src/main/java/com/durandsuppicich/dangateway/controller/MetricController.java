package com.durandsuppicich.dangateway.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricController {

    private final MeterRegistry meterRegistry;
    private Counter customerCounter;
    private Counter constructionCounter;
    private Counter employeeCounter;
    private Counter orderCounter;
    private Counter productCounter;
    private Counter accountingCounter;
    private Counter truckCounter;
    private Counter packageCounter;
    private Counter deliveryCounter;

    public MetricController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initCounter();
    }

    private void initCounter() {
        customerCounter = meterRegistry.counter("customers.requests");
        constructionCounter = meterRegistry.counter("constructions.requests");
        employeeCounter = meterRegistry.counter("employees.requests");
        orderCounter = meterRegistry.counter("orders.requests");
        productCounter = meterRegistry.counter("products.requests");
        accountingCounter = meterRegistry.counter("accounting.requests");
        truckCounter = meterRegistry.counter("trucks.requests");
        packageCounter = meterRegistry.counter("packages.requests");
        deliveryCounter = meterRegistry.counter("deliveries.requests");
    }

    public void incrementCounter(String uri) {

        if (uri.contains("customers")) customerCounter.increment();
        else if (uri.contains("constructions")) constructionCounter.increment();
        else if (uri.contains("employees")) employeeCounter.increment();
        else if (uri.contains("orders")) orderCounter.increment();
        else if (uri.contains("products")) productCounter.increment();
        else if (uri.contains("accounting")) accountingCounter.increment();
        else if (uri.contains("trucks")) truckCounter.increment();
        else if (uri.contains("packages")) packageCounter.increment();
        else if (uri.contains("deliveries")) deliveryCounter.increment();

        System.out.println("Counter incremented");
    }
}
