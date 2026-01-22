using AllocationChallenge;

var dataDir = Path.Combine(AppContext.BaseDirectory, "data");

var consumptionFile = Path.Combine(dataDir, "consumption.csv");
var productionFile = Path.Combine(dataDir, "production.csv");
var allocationsFile = Path.Combine(dataDir, "allocations.csv");

Console.WriteLine($"Loading consumption data from {consumptionFile}...");
var consumptionVolumes = CsvReading.LoadConsumption(consumptionFile);
Console.WriteLine($"Loaded {consumptionVolumes.Count} consumption records");

Console.WriteLine($"\nLoading production data from {productionFile}...");
var productionVolumes = CsvReading.LoadProduction(productionFile);
Console.WriteLine($"Loaded {productionVolumes.Count} production records");

Console.WriteLine($"\nLoading allocations data from {allocationsFile}...");
var allocations = CsvReading.LoadAllocations(allocationsFile);
Console.WriteLine($"Loaded {allocations.Count} allocation records");

// Show sample data
if (consumptionVolumes.Count > 0)
    Console.WriteLine($"\nSample consumption record: {consumptionVolumes[0]}");
if (productionVolumes.Count > 0)
    Console.WriteLine($"Sample production record: {productionVolumes[0]}");
// if (allocations.Count > 0)
//     Console.WriteLine($"Sample allocation record: {allocations[0]}");
