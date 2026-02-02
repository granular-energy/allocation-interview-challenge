package com.granularenergy.allocation;

import com.granularenergy.allocation.csv.CsvReading;
import com.granularenergy.allocation.models.ConsumptionVolume;
import com.granularenergy.allocation.models.ProductionVolume;

import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Path dataDir = CsvReading.getRepoRoot().resolve("data");

            Path consumptionFile = dataDir.resolve("consumption.csv");
            Path productionFile = dataDir.resolve("production.csv");
            Path allocationsFile = dataDir.resolve("allocations.csv");

            System.out.println("Loading consumption data from " + consumptionFile + "...");
            List<ConsumptionVolume> consumptionVolumes = CsvReading.loadConsumption(consumptionFile);
            System.out.println("Loaded " + consumptionVolumes.size() + " consumption records");

            System.out.println("\nLoading production data from " + productionFile + "...");
            List<ProductionVolume> productionVolumes = CsvReading.loadProduction(productionFile);
            System.out.println("Loaded " + productionVolumes.size() + " production records");

            // System.out.println("\nLoading allocations data from " + allocationsFile + "...");
            // List<Allocation> allocations = CsvReading.loadAllocations(allocationsFile);
            // System.out.println("Loaded " + allocations.size() + " allocation records");

            // Show sample data
            if (!consumptionVolumes.isEmpty()) {
                System.out.println("\nSample consumption record: " + consumptionVolumes.get(0));
            }
            if (!productionVolumes.isEmpty()) {
                System.out.println("Sample production record: " + productionVolumes.get(0));
            }
            // if (!allocations.isEmpty()) {
            //     System.out.println("Sample allocation record: " + allocations.get(0));
            // }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
