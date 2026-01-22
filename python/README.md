# Allocation Challenge - Python

A CLI tool for loading and processing energy allocation data from CSV files.

## Setup

Install dependencies:

```bash
pip install -r requirements.txt
```

Optionally, create a virtual environment first to isolate dependencies:

```bash
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
```

## Usage

Run the main script to load consumption, production, and allocation data:

```bash
python main.py
```

This will read from the CSV files in the `data/` directory and display record counts and sample data.

## Project Structure

- `main.py` - CLI entry point
- `models.py` - Data classes for ConsumptionVolume, ProductionVolume
- `csv_reading.py` - Functions to load CSV files into model objects
- `data/` - CSV data files (consumption.csv, production.csv, allocations.csv)
- `tests/` - Unit tests

## Running Tests

```bash
python -m pytest tests/ -v
```
