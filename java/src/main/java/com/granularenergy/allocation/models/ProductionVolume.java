package com.granularenergy.allocation.models;

import java.time.LocalDateTime;

public record ProductionVolume(
    String producer,
    LocalDateTime periodStart,
    Duration duration,
    double quantityKwh
) {}
