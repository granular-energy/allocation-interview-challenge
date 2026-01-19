namespace AllocationChallenge.Tests;

public class ModelsTests
{
    [Fact]
    public void ConsumptionVolume_Properties_AreSetCorrectly()
    {
        var volume = new ConsumptionVolume(
            Consumer: "C1",
            PeriodStart: new DateTime(2022, 1, 1, 0, 0, 0, DateTimeKind.Utc),
            Duration: Duration.Hour,
            QuantityKwh: 4671.549m
        );

        Assert.Equal("C1", volume.Consumer);
        Assert.Equal(new DateTime(2022, 1, 1, 0, 0, 0, DateTimeKind.Utc), volume.PeriodStart);
        Assert.Equal(Duration.Hour, volume.Duration);
        Assert.Equal(4671.549m, volume.QuantityKwh);
    }
}
