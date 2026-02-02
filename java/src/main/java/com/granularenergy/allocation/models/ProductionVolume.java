package com.granularenergy.allocation.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductionVolume(
    String producer,
    LocalDateTime periodStart,
    Duration duration,
    BigDecimal quantityKwh
) {}
