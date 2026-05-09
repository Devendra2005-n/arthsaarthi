"""
Fetches all Mutual Fund NAVs from AMFI India
Free, no API key needed
Runs daily via GitHub Actions
"""
import requests
import json
from datetime import date

def fetch_amfi_navs():
    url = "https://www.amfiindia.com/spages/NAVAll.txt"
    print(f"Fetching NAV data from AMFI...")
    
    try:
        response = requests.get(url, timeout=30)
        response.encoding = 'utf-8'
        lines = response.text.split('\n')
        
        nav_records = []
        for line in lines:
            parts = line.strip().split(';')
            if len(parts) >= 6:
                try:
                    scheme_code = parts[0].strip()
                    scheme_name = parts[3].strip()
                    nav_str = parts[4].strip()
                    nav_date = parts[5].strip()
                    
                    if scheme_code and nav_str and nav_str != 'N.A.':
                        nav_float = float(nav_str)
                        nav_records.append({
                            "scheme_code": scheme_code,
                            "scheme_name": scheme_name,
                            "nav": nav_float,
                            "nav_paise": int(nav_float * 100),
                            "date": nav_date
                        })
                except (ValueError, IndexError):
                    continue
        
        # Save top 1000 popular funds to data file
        popular_funds = [r for r in nav_records if any(
            keyword in r['scheme_name'].upper() 
            for keyword in ['HDFC', 'SBI', 'ICICI', 'AXIS', 'KOTAK', 'MIRAE', 'PARAG', 'NIPPON', 'UTI', 'DSP']
        )][:1000]
        
        output = {
            "last_updated": str(date.today()),
            "total_funds": len(nav_records),
            "funds": popular_funds
        }
        
        with open('data/amfi_navs.json', 'w', encoding='utf-8') as f:
            json.dump(output, f, ensure_ascii=False, indent=2)
        
        print(f"✅ Saved {len(popular_funds)} fund NAVs to data/amfi_navs.json")
        
    except Exception as e:
        print(f"❌ Error: {e}")

if __name__ == "__main__":
    fetch_amfi_navs()
