"""
Fetch AMFI Mutual Fund NAV data daily — FREE, no API key needed
AMFI URL: https://www.amfiindia.com/spages/NAVAll.txt
"""
import requests
import os
from datetime import date

try:
    from supabase import create_client
    supabase = create_client(os.environ['SUPABASE_URL'], os.environ['SUPABASE_KEY'])
except Exception as e:
    print(f"Supabase connection failed: {e}")
    exit(1)

print("Fetching AMFI NAV data...")
response = requests.get('https://www.amfiindia.com/spages/NAVAll.txt', timeout=30)
lines = response.text.strip().split('\n')

records = []
for line in lines:
    parts = line.split(';')
    if len(parts) >= 6:
        try:
            nav_value = float(parts[4].strip())
            nav_paise = int(nav_value * 100)
            if nav_paise > 0:
                records.append({
                    'scheme_code': parts[0].strip(),
                    'scheme_name': parts[3].strip()[:200],
                    'nav_paise': nav_paise,
                    'date': str(date.today())
                })
        except (ValueError, IndexError):
            continue

print(f"Parsed {len(records)} NAV records")

# Batch insert to Supabase
batch_size = 500
for i in range(0, len(records), batch_size):
    batch = records[i:i+batch_size]
    try:
        supabase.table('mutual_fund_navs').upsert(batch).execute()
        print(f"Inserted batch {i//batch_size + 1}")
    except Exception as e:
        print(f"Batch {i//batch_size + 1} failed: {e}")

print("AMFI NAV fetch complete!")
