from datetime import datetime, timezone
from decimal import Decimal

from models import ConsumptionVolume, Duration


def test_consumption_volume_properties():
    volume = ConsumptionVolume(
        consumer="C1",
        period_start=datetime(2022, 1, 1, 0, 0, tzinfo=timezone.utc),
        duration=Duration.HOUR,
        quantity_kwh=Decimal("4671.549")
    )

    assert volume.consumer == "C1"
    assert volume.period_start == datetime(2022, 1, 1, 0, 0, tzinfo=timezone.utc)
    assert volume.duration == Duration.HOUR
    assert volume.quantity_kwh == Decimal("4671.549")
