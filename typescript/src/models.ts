import { Temporal } from '@js-temporal/polyfill';
import Decimal from 'decimal.js';

export enum Duration {
  HOUR = 'HOUR',
  DAY = 'DAY',
  MONTH = 'MONTH',
  YEAR = 'YEAR',
}

export class ProductionVolume {
  constructor(
    public readonly producer: string,
    public readonly periodStart: Temporal.ZonedDateTime,
    public readonly duration: Duration,
    public readonly quantityKwh: Decimal
  ) {}
}

export class ConsumptionVolume {
  constructor(
    public readonly consumer: string,
    public readonly periodStart: Temporal.ZonedDateTime,
    public readonly duration: Duration,
    public readonly quantityKwh: Decimal
  ) {}
}

