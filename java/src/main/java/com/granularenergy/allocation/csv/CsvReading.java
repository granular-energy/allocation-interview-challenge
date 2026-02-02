package com.granularenergy.allocation.csv;

import com.granularenergy.allocation.models.ConsumptionVolume;
import com.granularenergy.allocation.models.Duration;
import com.granularenergy.allocation.models.ProductionVolume;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReading {

    private static final DateTimeFormatter TIMESTAMP_FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");

    public static LocalDateTime parseTimestamp(String timestampStr) {
        OffsetDateTime odt = OffsetDateTime.parse(timestampStr, TIMESTAMP_FORMATTER);
        return odt.toLocalDateTime();
    }

    public static List<ConsumptionVolume> loadConsumption(Path filePath) throws IOException, CsvValidationException {
        List<ConsumptionVolume> consumptionVolumes = new ArrayList<>();

        try (CSVReader reader = createCsvReader(filePath)) {
            String[] headers = reader.readNext();
            Map<String, Integer> headerMap = createHeaderMap(headers);

            String[] row;
            while ((row = reader.readNext()) != null) {
                ConsumptionVolume volume = new ConsumptionVolume(
                    row[headerMap.get("consumer")],
                    parseTimestamp(row[headerMap.get("timestamp")]),
                    Duration.HOUR,
                    new BigDecimal(row[headerMap.get("quantity")])
                );
                consumptionVolumes.add(volume);
            }
        }

        return consumptionVolumes;
    }

    public static List<ProductionVolume> loadProduction(Path filePath) throws IOException, CsvValidationException {
        List<ProductionVolume> productionVolumes = new ArrayList<>();

        try (CSVReader reader = createCsvReader(filePath)) {
            String[] headers = reader.readNext();
            Map<String, Integer> headerMap = createHeaderMap(headers);

            String[] row;
            while ((row = reader.readNext()) != null) {
                ProductionVolume volume = new ProductionVolume(
                    row[headerMap.get("producer")],
                    parseTimestamp(row[headerMap.get("timestamp")]),
                    Duration.HOUR,
                    new BigDecimal(row[headerMap.get("quantity")])
                );
                productionVolumes.add(volume);
            }
        }

        return productionVolumes;
    }

    public static void loadAllocations(Path filePath) throws IOException, CsvValidationException {
        try (CSVReader reader = createCsvReader(filePath)) {
            String[] headers = reader.readNext();
            Map<String, Integer> headerMap = createHeaderMap(headers);

            String[] row;
            while ((row = reader.readNext()) != null) {
                String producer = row[headerMap.get("producer")];
                String consumer = row[headerMap.get("consumer")];
                LocalDateTime periodStart = parseTimestamp(row[headerMap.get("timestamp")]);
                Duration duration = Duration.HOUR;
                BigDecimal quantityKwh = new BigDecimal(row[headerMap.get("quantity")]);

                // TODO: return allocations
            }
        }
    }

    public static Path getRepoRoot() {
        return getRepoRoot(Path.of("").toAbsolutePath());
    }

    public static Path getRepoRoot(Path currentDir) {
        if (currentDir.resolve(".git").toFile().isDirectory()) {
            return currentDir;
        }
        Path parentDir = currentDir.getParent();
        if (parentDir == null || parentDir.equals(currentDir)) {
            throw new RuntimeException("Repository root not found");
        }
        return getRepoRoot(parentDir);
    }

    private static CSVReader createCsvReader(Path filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath.toFile());
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        return new CSVReader(isr);
    }

    private static Map<String, Integer> createHeaderMap(String[] headers) {
        Map<String, Integer> headerMap = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            // Strip BOM if present on first header
            String header = headers[i];
            if (i == 0 && header.startsWith("\uFEFF")) {
                header = header.substring(1);
            }
            headerMap.put(header, i);
        }
        return headerMap;
    }
}
