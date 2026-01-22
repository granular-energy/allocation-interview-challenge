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
    DateTimeOffset PeriodStart,
    Duration Duration,
    decimal QuantityKwh
);

public record ConsumptionVolume(
    string Consumer,
    DateTimeOffset PeriodStart,
    Duration Duration,
    decimal QuantityKwh
);
