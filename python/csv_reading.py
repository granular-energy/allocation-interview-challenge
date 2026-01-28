import csv
from datetime import datetime
from decimal import Decimal
from pathlib import Path

from models import ConsumptionVolume, Duration, ProductionVolume


def parse_timestamp(timestamp_str: str) -> datetime:
    return datetime.fromisoformat(timestamp_str)


def load_consumption(file_path: Path) -> list[ConsumptionVolume]:
    consumption_volumes = []
    with open(file_path, newline='', encoding='utf-8-sig') as f:
        reader = csv.DictReader(f)
        for row in reader:
            volume = ConsumptionVolume(
                consumer=row['consumer'],
                period_start=parse_timestamp(row['timestamp']),
                duration=Duration.HOUR,
                quantity_kwh=Decimal(row['quantity'])
            )
            consumption_volumes.append(volume)
    return consumption_volumes


def load_production(file_path: Path) -> list[ProductionVolume]:
    production_volumes = []
    with open(file_path, newline='', encoding='utf-8-sig') as f:
        reader = csv.DictReader(f)
        for row in reader:
            volume = ProductionVolume(
                producer=row['producer'],
                period_start=parse_timestamp(row['timestamp']),
                duration=Duration.HOUR,
                quantity_kwh=Decimal(row['quantity'])
            )
            production_volumes.append(volume)
    return production_volumes


def load_allocations(file_path: Path) -> None:
    
    with open(file_path, newline='', encoding='utf-8-sig') as f:
        reader = csv.DictReader(f)
        for row in reader:            
            
            producer = row['producer']
            consumer = row['consumer']
            period_start = parse_timestamp(row['timestamp'])
            duration = Duration.HOUR
            quantity_kwh = Decimal(row['quantity'])

            # TODO: return allocations


def get_repo_root(current_dir: Path | None = None) -> Path:
    if current_dir is None:
        current_dir = Path(__file__).parent
    if (current_dir / '.git').is_dir():
        return current_dir
    parent_dir = current_dir.parent
    if parent_dir == current_dir:
        raise Exception("Repository root not found")
    return get_repo_root(parent_dir)
