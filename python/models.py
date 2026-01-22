from dataclasses import dataclass
from datetime import datetime
from decimal import Decimal
from enum import Enum


class Duration(Enum):    
    HOUR = "HOUR"
    DAY = "DAY"
    MONTH = "MONTH"
    YEAR = "YEAR"

@dataclass
class ProductionVolume:
    producer: str
    period_start: datetime
    duration: Duration
    quantity_kwh: Decimal

@dataclass
class ConsumptionVolume:
    consumer: str
    period_start: datetime
    duration: Duration
    quantity_kwh: Decimal
