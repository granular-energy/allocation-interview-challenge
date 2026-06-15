package com.granularenergy.allocation.models;

import java.time.LocalDateTime;

public record ConsumptionVolume(
    String consumer,
    LocalDateTime periodStart,
    Duration duration,
    double quantityKwh
) {}
