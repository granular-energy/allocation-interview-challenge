package com.allocation.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsumptionVolume(
    String consumer,
    LocalDateTime periodStart,
    Duration duration,
    BigDecimal quantityKwh
) {}
