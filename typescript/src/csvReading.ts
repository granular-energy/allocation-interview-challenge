import * as fs from 'fs';
import * as path from 'path';
import { Temporal } from '@js-temporal/polyfill';
import { parse } from 'csv-parse/sync';
import Decimal from 'decimal.js';
import {
  ConsumptionVolume,
  ProductionVolume,
  Duration,
} from './models';

const TIMEZONE = 'Europe/London';

export function parseTimestamp(timestampStr: string): Temporal.ZonedDateTime {
  const instant = Temporal.Instant.from(timestampStr);
  return instant.toZonedDateTimeISO(TIMEZONE);
}

function stripBom(content: string): string {
  if (content.charCodeAt(0) === 0xfeff) {
    return content.slice(1);
  }
  return content;
}

function readCsvFile(filePath: string): Record<string, string>[] {
  const content = stripBom(fs.readFileSync(filePath, 'utf-8'));
  return parse(content, {
    columns: true,
    skip_empty_lines: true,
  });
}

export function loadConsumption(filePath: string): ConsumptionVolume[] {
  const rows = readCsvFile(filePath);
  return rows.map(
    (row) =>
      new ConsumptionVolume(
        row['consumer'],
        parseTimestamp(row['timestamp']),
        Duration.HOUR,
        new Decimal(row['quantity'])
      )
  );
}

export function loadProduction(filePath: string): ProductionVolume[] {
  const rows = readCsvFile(filePath);
  return rows.map(
    (row) =>
      new ProductionVolume(
        row['producer'],
        parseTimestamp(row['timestamp']),
        Duration.HOUR,
        new Decimal(row['quantity'])
      )
  );
}

export function loadAllocations(filePath: string): void {
  const rows = readCsvFile(filePath);
  for (const row of rows) {
    const producer = row['producer'];
    const consumer = row['consumer'];
    const periodStart = parseTimestamp(row['timestamp']);
    const duration = Duration.HOUR;
    const quantityKwh = new Decimal(row['quantity']);

    // TODO: return allocations
  }
}

export function getRepoRoot(currentDir?: string): string {
  if (!currentDir) {
    currentDir = __dirname;
  }

  const gitDir = path.join(currentDir, '.git');
  if (fs.existsSync(gitDir) && fs.statSync(gitDir).isDirectory()) {
    return currentDir;
  }

  const parentDir = path.dirname(currentDir);
  if (parentDir === currentDir) {
    throw new Error('Repository root not found');
  }

  return getRepoRoot(parentDir);
}
