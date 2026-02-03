# Allocation Interview Challenge - TypeScript

TypeScript implementation for loading and processing energy allocation data.

## Prerequisites

- Node.js (v18 or later recommended)
- npm

## Setup

```bash
npm install
```

## Scripts

| Command         | Description                      |
| --------------- | -------------------------------- |
| `npm run build` | Compile TypeScript to JavaScript |
| `npm start`     | Run the compiled application     |
| `npm run dev`   | Run with ts-node (development)   |
| `npm test`      | Run Jest tests                   |

## Project Structure

```
typescript/
├── src/
│   ├── models.ts       # Data models (Duration, ProductionVolume, ConsumptionVolume, AllocationVolume)
│   ├── csvReading.ts   # CSV loading utilities
│   └── main.ts         # CLI entry point
├── tests/
│   └── models.test.ts  # Unit tests
├── package.json
├── tsconfig.json
└── jest.config.js
```

## Data Models

- **Duration** - Enum: `HOUR`, `DAY`, `MONTH`, `YEAR`
- **ProductionVolume** - Energy production record with producer, period start, duration, and quantity (kWh)
- **ConsumptionVolume** - Energy consumption record with consumer, period start, duration, and quantity (kWh)

## A note on Temporal

We are using Temporal rather than the native JS `Date` type. We are using `ZonedDateTime` in the models
with a London timezone, since that is what the data in the CSV is representing.

## Dependencies

- `@js-temporal/polyfill` - Temporal API for date/time handling (using `Europe/London` timezone)
- `decimal.js` - Precise decimal arithmetic
- `csv-parse` - CSV file parsing
