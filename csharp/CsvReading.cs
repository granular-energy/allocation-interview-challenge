using System.Globalization;

namespace AllocationChallenge;

public static class CsvReading
{
    public static List<ConsumptionVolume> LoadConsumption(string filePath)
    {
        var volumes = new List<ConsumptionVolume>();

        foreach (var record in ReadCsvRecords(filePath))
        {
            var volume = new ConsumptionVolume(
                Consumer: record["consumer"],
                PeriodStart: ParseTimestamp(record["timestamp"]),
                Duration: Duration.Hour,
                QuantityKwh: decimal.Parse(record["quantity"], CultureInfo.InvariantCulture)
            );
            volumes.Add(volume);
        }

        return volumes;
    }

    public static List<ProductionVolume> LoadProduction(string filePath)
    {
        var volumes = new List<ProductionVolume>();

        foreach (var record in ReadCsvRecords(filePath))
        {
            var volume = new ProductionVolume(
                Producer: record["producer"],
                PeriodStart: ParseTimestamp(record["timestamp"]),
                Duration: Duration.Hour,
                QuantityKwh: decimal.Parse(record["quantity"], CultureInfo.InvariantCulture)
            );
            volumes.Add(volume);
        }

        return volumes;
    }

    public static List<AllocationCsvRow> LoadAllocations(string filePath)
    {
        var allocations = new List<AllocationCsvRow>();

        foreach (var record in ReadCsvRecords(filePath))
        {
            var allocation = new AllocationCsvRow(
                Producer: record["producer"],
                Consumer: record["consumer"],
                PeriodStart: ParseTimestamp(record["timestamp"]),
                Duration: Duration.Hour,
                QuantityKwh: decimal.Parse(record["quantity"], CultureInfo.InvariantCulture)
            );
            allocations.Add(allocation);
        }

        return allocations;
    }

    private static DateTime ParseTimestamp(string timestamp)
    {
        return DateTime.Parse(timestamp, CultureInfo.InvariantCulture, DateTimeStyles.AdjustToUniversal);
    }

    private static IEnumerable<Dictionary<string, string>> ReadCsvRecords(string filePath)
    {
        using var reader = new StreamReader(filePath, new System.Text.UTF8Encoding(encoderShouldEmitUTF8Identifier: true));

        var headerLine = reader.ReadLine();
        if (headerLine == null) yield break;

        // Remove BOM if present (StreamReader may not strip it in all cases)
        headerLine = headerLine.TrimStart('\uFEFF');

        var headers = headerLine.Split(',');

        while (reader.ReadLine() is { } line)
        {
            var values = line.Split(',');
            var record = new Dictionary<string, string>();

            for (int i = 0; i < headers.Length && i < values.Length; i++)
            {
                record[headers[i]] = values[i];
            }

            yield return record;
        }
    }
}
