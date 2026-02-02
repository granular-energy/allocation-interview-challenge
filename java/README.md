# Allocation Challenge - Java

A CLI tool for loading and processing energy allocation data from CSV files.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Setup

Build the project:

```bash
mvn clean compile
```

## Usage

Run the main class to load consumption, production, and allocation data:

```bash
mvn exec:java -Dexec.mainClass="com.allocation.Main"
```

Or build and run the JAR:

```bash
mvn package
java -jar target/allocation-challenge-1.0-SNAPSHOT.jar
```

This will read from the CSV files in the `data/` directory and display record counts and sample data.

## Project Structure

- `src/main/java/com/allocation/Main.java` - CLI entry point
- `src/main/java/com/allocation/models/` - Record classes for ConsumptionVolume, ProductionVolume, Duration
- `src/main/java/com/allocation/csv/CsvReading.java` - Functions to load CSV files into model objects
- `data/` - CSV data files (consumption.csv, production.csv, allocations.csv)
- `src/test/java/` - Unit tests

## Running Tests

```bash
mvn test
```
