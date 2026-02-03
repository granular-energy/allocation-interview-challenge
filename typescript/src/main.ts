import * as path from 'path';
import {
  getRepoRoot,
  loadConsumption,
  loadProduction,
  loadAllocations,
} from './csvReading';

function main(): void {
  const dataDir = path.join(getRepoRoot(), 'data');

  const consumptionFile = path.join(dataDir, 'consumption.csv');
  const productionFile = path.join(dataDir, 'production.csv');
  const allocationsFile = path.join(dataDir, 'allocations.csv');

  console.log(`Loading consumption data from ${consumptionFile}...`);
  const consumptionVolumes = loadConsumption(consumptionFile);
  console.log(`Loaded ${consumptionVolumes.length} consumption records`);

  console.log(`\nLoading production data from ${productionFile}...`);
  const productionVolumes = loadProduction(productionFile);
  console.log(`Loaded ${productionVolumes.length} production records`);

  // console.log(`\nLoading allocations data from ${allocationsFile}...`);
  // const allocations = loadAllocations(allocationsFile);
  // console.log(`Loaded ${allocations.length} allocation records`);

  // Show sample data
  if (consumptionVolumes.length > 0) {
    const sample = consumptionVolumes[0];
    console.log(
      `\nSample consumption record: ConsumptionVolume(consumer='${sample.consumer}', period_start=${sample.periodStart.toString()}, duration=${sample.duration}, quantity_kwh=${sample.quantityKwh})`
    );
  }
  if (productionVolumes.length > 0) {
    const sample = productionVolumes[0];
    console.log(
      `Sample production record: ProductionVolume(producer='${sample.producer}', period_start=${sample.periodStart.toString()}, duration=${sample.duration}, quantity_kwh=${sample.quantityKwh})`
    );
  }
  // if (allocations.length > 0) {
  //   const sample = allocations[0];
  //   console.log(`Sample allocation record: AllocationVolume(producer='${sample.producer}', consumer='${sample.consumer}', period_start=${sample.periodStart.toISOString()}, duration=${sample.duration}, quantity_kwh=${sample.quantityKwh})`);
  // }
}

main();
