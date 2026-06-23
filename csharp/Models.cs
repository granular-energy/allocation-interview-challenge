namespace AllocationChallenge;

public enum Duration
{
    Hour,
    Day,
    Month,
    Year
}

public class ProductionVolume
{
    public string Producer { get; set; }
    public DateTimeOffset PeriodStart { get; set; }
    public Duration Duration { get; set; }
    public decimal QuantityKwh { get; set; }

    public ProductionVolume(string Producer, DateTimeOffset PeriodStart, Duration Duration, decimal QuantityKwh)
    {
        this.Producer = Producer;
        this.PeriodStart = PeriodStart;
        this.Duration = Duration;
        this.QuantityKwh = QuantityKwh;
    }
}

public class ConsumptionVolume
{
    public string Consumer { get; set; }
    public DateTimeOffset PeriodStart { get; set; }
    public Duration Duration { get; set; }
    public decimal QuantityKwh { get; set; }

    public ConsumptionVolume(string Consumer, DateTimeOffset PeriodStart, Duration Duration, decimal QuantityKwh)
    {
        this.Consumer = Consumer;
        this.PeriodStart = PeriodStart;
        this.Duration = Duration;
        this.QuantityKwh = QuantityKwh;
    }
}
