package com.granularenergy.allocation.models;

import java.time.LocalDateTime;

public class ConsumptionVolume {
    private String consumer;
    private LocalDateTime periodStart;
    private Duration duration;
    private double quantityKwh;

    public ConsumptionVolume(String consumer, LocalDateTime periodStart, Duration duration, double quantityKwh) {
        this.consumer = consumer;
        this.periodStart = periodStart;
        this.duration = duration;
        this.quantityKwh = quantityKwh;
    }

    public String consumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public LocalDateTime periodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDateTime periodStart) {
        this.periodStart = periodStart;
    }

    public Duration duration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public double quantityKwh() {
        return quantityKwh;
    }

    public void setQuantityKwh(double quantityKwh) {
        this.quantityKwh = quantityKwh;
    }
}
