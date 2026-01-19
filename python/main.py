#!/usr/bin/env python3
from pathlib import Path

from csv_reading import load_allocations, load_consumption, load_production


def main():
    data_dir = Path(__file__).parent / 'data'

    consumption_file = data_dir / 'consumption.csv'
    production_file = data_dir / 'production.csv'
    allocations_file = data_dir / 'allocations.csv'

    print(f"Loading consumption data from {consumption_file}...")
    consumption_volumes = load_consumption(consumption_file)
    print(f"Loaded {len(consumption_volumes)} consumption records")

    print(f"\nLoading production data from {production_file}...")
    production_volumes = load_production(production_file)
    print(f"Loaded {len(production_volumes)} production records")

    print(f"\nLoading allocations data from {allocations_file}...")
    allocations = load_allocations(allocations_file)
    print(f"Loaded {len(allocations)} allocation records")

    # Show sample data
    if consumption_volumes:
        print(f"\nSample consumption record: {consumption_volumes[0]}")
    if production_volumes:
        print(f"Sample production record: {production_volumes[0]}")
    if allocations:
        print(f"Sample allocation record: {allocations[0]}")


if __name__ == '__main__':
    main()
