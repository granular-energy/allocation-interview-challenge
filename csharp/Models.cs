namespace AllocationChallenge;

public enum Duration
{
    Hour,
    Day,
    Month,
    Year
}

public record ProductionVolume(
    string Producer,
    DateTime PeriodStart,
    Duration Duration,
    decimal QuantityKwh
);

public record ConsumptionVolume(
    string Consumer,
    DateTime PeriodStart,
    Duration Duration,
    decimal QuantityKwh
);

public record AllocationCsvRow(
    string Producer,
    string Consumer,
    DateTime PeriodStart,
    Duration Duration,
    decimal QuantityKwh
);
