package com.granularenergy.allocation;

import org.junit.jupiter.api.Test;

import com.granularenergy.allocation.models.ConsumptionVolume;
import com.granularenergy.allocation.models.Duration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelsTest {

    @Test
    void testConsumptionVolumeProperties() {
        ConsumptionVolume volume = new ConsumptionVolume(
            "C1",
            LocalDateTime.of(2022, 1, 1, 0, 0).atOffset(ZoneOffset.UTC).toLocalDateTime(),
            Duration.HOUR,
            new BigDecimal("4671.549")
        );

        assertEquals("C1", volume.consumer());
        assertEquals(LocalDateTime.of(2022, 1, 1, 0, 0), volume.periodStart());
        assertEquals(Duration.HOUR, volume.duration());
        assertEquals(new BigDecimal("4671.549"), volume.quantityKwh());
    }
}
