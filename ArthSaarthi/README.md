# ArthSaarthi (अर्थसारथी) 🇮🇳

### India's Offline Personal Finance Advisor App

> Built for 1.4 billion Indians — works without internet, speaks 3+ languages,
> understands SIP, EPF, chit funds, agricultural income, and government schemes
> that no other finance app handles.

---

## ⬇️ Download

**[Download Latest APK →](https://github.com/YOURUSERNAME/arthsaarthi/releases)**

Install on any Android phone (Android 8.0+). Works fully offline.

---

## ✨ Features

| Feature | Status |
|---|---|
| 📊 Expense tracking with SMS auto-detection | ✅ Done |
| 💰 SIP, FD, PPF, Gold, EPF tracker | ✅ Done |
| 🧾 Tax optimizer (Old vs New Regime 2025-26) | ✅ Done |
| 🎯 Financial Goals with SIP suggestions | ✅ Done |
| 🏛️ Govt scheme eligibility checker (8+ schemes) | ✅ Done |
| 🗣️ Hindi & Marathi language support | ✅ Done |
| 📴 Works 100% offline | ✅ Done |
| 🔒 Zero data collection — all data on device | ✅ Done |
| 🌾 Agricultural income module | 🔄 Coming |
| 💳 Chit Fund tracker | 🔄 Coming |
| 🧾 Payslip ML parser | 🔄 Coming |

---

## 🛠️ Tech Stack

```
Android App     → Kotlin + Jetpack Compose + Material Design 3
Database        → Room DB (SQLite) — fully offline, AES encrypted
Architecture    → Clean Architecture (MVVM + Use Cases)
DI              → Hilt (Dagger)
ML              → On-device SMS categorization
Languages       → English, Hindi, Marathi (12 planned)
Backend         → Go (Railway.app free tier)
Data            → AMFI NAV (free), Gold rates, Tax rules JSON
CI/CD           → GitHub Actions (auto-build APK on push)
```

---

## 💰 Total Build Cost

**₹0 (Zero Rupees)**

| Tool | Cost |
|---|---|
| GitHub | Free |
| Firebase | Free |
| Railway.app backend | Free |
| AMFI NAV data | Free |
| Google Colab ML training | Free |
| GitHub Releases distribution | Free |
| **Total** | **₹0** |

---

## 🚀 How to Build from Source

### Prerequisites
- Android Studio (Hedgehog or newer)
- JDK 17
- Android SDK API 26+

### Steps

```bash
# Clone the repo
git clone https://github.com/YOURUSERNAME/arthsaarthi.git
cd arthsaarthi/android

# Build debug APK
./gradlew assembleDebug

# APK location
# android/app/build/outputs/apk/debug/app-debug.apk
```

### Or just push to GitHub
Every push to `main` automatically builds the APK and creates a GitHub Release via GitHub Actions.

---

## 📁 Project Structure

```
arthsaarthi/
├── android/                    ← Android app (Kotlin + Compose)
│   └── app/src/main/java/in/arthsaarthi/
│       ├── data/db/            ← Room entities + DAOs
│       ├── presentation/       ← Screens + ViewModels
│       ├── ml/                 ← SMS parser + categorization
│       └── utils/              ← Indian finance helpers
├── backend/                    ← Go backend (Railway free tier)
├── scripts/                    ← Python data fetchers
│   ├── fetch_amfi.py           ← Daily MF NAV from AMFI
│   └── fetch_gold.py           ← Daily gold rates
├── data/                       ← Static JSON data
│   ├── tax_rules.json          ← FY2025-26 tax slabs
│   ├── msp_rates.json          ← Crop MSP rates
│   └── amfi_navs.json          ← Latest MF NAVs
└── .github/workflows/
    ├── build.yml               ← Auto-build APK
    └── fetch_data.yml          ← Daily data refresh
```

---

## 🇮🇳 Why ArthSaarthi?

Every existing finance app fails India in some way:

- **Groww/Zerodha** — Investment only, no budgeting, no regional language
- **ET Money/Walnut** — Basic tracking, no tax advice, no offline, no agricultural income
- **Fi Money/Jupiter** — Bank-linked only, excludes cash economy, no Tier 3/rural users
- **Global Apps (Mint, YNAB)** — Built for USA. Useless for EPF, HRA, 80C, chit funds

**ArthSaarthi fills all these gaps** — offline, in Indian languages, with ML trained on Indian data.

---

## 🔒 Privacy

- All financial data stored **only on your device**
- No data sold to banks, insurers, or advertisers — **ever**
- No login required for core features
- SMS reading is **optional** and **never leaves your phone**

---

## 📄 License

MIT License — free to use, modify, and distribute.

---

*Built with ❤️ for Bharat*
