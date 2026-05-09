"""
Fetches gold rates for Indian cities
Free data from Yahoo Finance API
"""
import requests
import json
from datetime import date

def fetch_gold_rates():
    try:
        # Gold price in USD per troy oz from Yahoo Finance (free)
        url = "https://query1.finance.yahoo.com/v8/finance/chart/GC=F"
        headers = {"User-Agent": "Mozilla/5.0"}
        resp = requests.get(url, headers=headers, timeout=15)
        data = resp.json()
        
        gold_usd_per_oz = data['chart']['result'][0]['meta']['regularMarketPrice']
        
        # USD to INR (approximate - update regularly)
        usd_inr = 83.5
        
        # 1 troy oz = 31.1035 grams
        gold_inr_per_gram_24k = (gold_usd_per_oz * usd_inr) / 31.1035
        gold_inr_per_gram_22k = gold_inr_per_gram_24k * (22/24)
        gold_inr_per_gram_18k = gold_inr_per_gram_24k * (18/24)
        
        output = {
            "last_updated": str(date.today()),
            "gold_usd_per_oz": gold_usd_per_oz,
            "usd_inr_rate": usd_inr,
            "rates": {
                "gold_24k_per_gram_inr": round(gold_inr_per_gram_24k, 2),
                "gold_22k_per_gram_inr": round(gold_inr_per_gram_22k, 2),
                "gold_18k_per_gram_inr": round(gold_inr_per_gram_18k, 2),
                "gold_24k_per_gram_paise": int(gold_inr_per_gram_24k * 100),
                "gold_22k_per_gram_paise": int(gold_inr_per_gram_22k * 100),
            },
            "note": "Rates indicative. Check local jeweller for exact rates."
        }
        
        with open('data/gold_rates.json', 'w') as f:
            json.dump(output, f, indent=2)
        
        print(f"✅ Gold 24K: ₹{gold_inr_per_gram_24k:.0f}/gram")
        print(f"✅ Gold 22K: ₹{gold_inr_per_gram_22k:.0f}/gram")
        print(f"✅ Saved to data/gold_rates.json")
        
    except Exception as e:
        print(f"❌ Error fetching gold rates: {e}")
        # Fallback rates if fetch fails
        fallback = {
            "last_updated": str(date.today()),
            "rates": {
                "gold_24k_per_gram_inr": 7200,
                "gold_22k_per_gram_inr": 6600,
                "gold_18k_per_gram_inr": 5400,
                "gold_24k_per_gram_paise": 720000,
                "gold_22k_per_gram_paise": 660000,
            },
            "note": "Fallback rates - fetch failed"
        }
        with open('data/gold_rates.json', 'w') as f:
            json.dump(fallback, f, indent=2)

if __name__ == "__main__":
    fetch_gold_rates()
