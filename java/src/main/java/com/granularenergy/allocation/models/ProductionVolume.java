package com.granularenergy.allocation.models;

import java.time.LocalDateTime;

public class ProductionVolume {
    private String producer;
    private LocalDateTime periodStart;
    private Duration duration;
    private double quantityKwh;

    public ProductionVolume(String producer, LocalDateTime periodStart, Duration duration, double quantityKwh) {
        this.producer = producer;
        this.periodStart = periodStart;
        this.duration = duration;
        this.quantityKwh = quantityKwh;
    }

    public String producer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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
