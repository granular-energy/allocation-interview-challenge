import { Temporal } from '@js-temporal/polyfill';
import Decimal from 'decimal.js';
import { ConsumptionVolume, Duration } from '../src/models';

describe('ConsumptionVolume', () => {
  test('consumption volume properties', () => {
    const periodStart = Temporal.Instant.from('2022-01-01T00:00:00Z').toZonedDateTimeISO('Europe/London');
    const volume = new ConsumptionVolume(
      'C1',
      periodStart,
      Duration.HOUR,
      new Decimal('4671.549')
    );

    expect(volume.consumer).toBe('C1');
    expect(volume.periodStart.equals(periodStart)).toBe(true);
    expect(volume.duration).toBe(Duration.HOUR);
    expect(volume.quantityKwh.equals(new Decimal('4671.549'))).toBe(true);
  });
});
