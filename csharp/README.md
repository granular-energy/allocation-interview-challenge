# Allocation Challenge - C#

A CLI tool for loading and processing energy allocation data from CSV files.

## Setup

Restore dependencies:

```bash
dotnet restore
```

## Usage

Run the application to load consumption, production, and allocation data:

```bash
dotnet run
```

This will read from the CSV files in the `data/` directory and display record counts and sample data.

## Project Structure

- `Program.cs` - CLI entry point
- `Models.cs` - Record types for ConsumptionVolume, ProductionVolume, AllocationCsvRow
- `CsvReading.cs` - Functions to load CSV files into model objects
- `data/` - CSV data files (consumption.csv, production.csv, allocations.csv)
- `Tests/` - Unit tests

## Running Tests

```bash
dotnet test
```
