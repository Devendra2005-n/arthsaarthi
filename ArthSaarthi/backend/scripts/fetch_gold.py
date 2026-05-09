"""
Fetch Gold rates — scrape IBJA daily rates
IBJA (India Bullion and Jewellers Association)
"""
import requests
import os
from datetime import date
import re

try:
    from supabase import create_client
    supabase = create_client(os.environ['SUPABASE_URL'], os.environ['SUPABASE_KEY'])
except Exception as e:
    print(f"Supabase connection failed: {e}")
    exit(1)

print("Fetching Gold rates...")

# IBJA rates — try their website
try:
    headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36'}
    response = requests.get('https://ibja.co/', headers=headers, timeout=15)
    text = response.text

    # Extract 24K and 22K prices from page
    gold_24k = None
    gold_22k = None

    pattern_24k = re.search(r'24\s*K[^\d]*(\d+[,\d]*)', text)
    pattern_22k = re.search(r'22\s*K[^\d]*(\d+[,\d]*)', text)

    if pattern_24k:
        gold_24k = int(pattern_24k.group(1).replace(',', ''))
    if pattern_22k:
        gold_22k = int(pattern_22k.group(1).replace(',', ''))

except Exception as e:
    print(f"IBJA fetch failed: {e}")
    # Use approximate fallback values (update manually each month)
    gold_24k = 7400  # approximate ₹/gram
    gold_22k = 6780

if gold_24k and gold_22k:
    record = {
        'date': str(date.today()),
        'gold_24k_per_gram_paise': gold_24k * 100,
        'gold_22k_per_gram_paise': gold_22k * 100,
        'silver_per_gram_paise': 9000,  # approximate
        'city': 'Mumbai'
    }
    try:
        supabase.table('gold_rates').upsert(record).execute()
        print(f"Gold rates updated: 24K=₹{gold_24k}/g, 22K=₹{gold_22k}/g")
    except Exception as e:
        print(f"Supabase insert failed: {e}")

print("Gold rate fetch complete!")
