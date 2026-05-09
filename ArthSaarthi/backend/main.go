package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"os"
	"strconv"
)

func main() {
	port := os.Getenv("PORT")
	if port == "" {
		port = "8080"
	}

	http.HandleFunc("/health", healthHandler)
	http.HandleFunc("/api/tax/calculate", taxHandler)
	http.HandleFunc("/api/schemes", schemesHandler)

	log.Printf("ArthSaarthi backend starting on port %s", port)
	log.Fatal(http.ListenAndServe(":"+port, nil))
}

func enableCORS(w http.ResponseWriter) {
	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Header().Set("Content-Type", "application/json")
}

func healthHandler(w http.ResponseWriter, r *http.Request) {
	enableCORS(w)
	json.NewEncoder(w).Encode(map[string]string{"status": "ok", "app": "ArthSaarthi"})
}

// TaxRequest from Android app
type TaxRequest struct {
	GrossIncomeRs    int64   `json:"gross_income_rs"`
	HraReceivedRs    int64   `json:"hra_received_rs"`
	RentPaidRs       int64   `json:"rent_paid_rs"`
	EpfContribRs     int64   `json:"epf_contrib_rs"`
	Other80CRs       int64   `json:"other_80c_rs"`
	HealthInsureRs   int64   `json:"health_insurance_rs"`
	NpsContribRs     int64   `json:"nps_contrib_rs"`
	HomeLoanInterest int64   `json:"home_loan_interest_rs"`
	IsMetro          bool    `json:"is_metro"`
}

type TaxResponse struct {
	OldRegimeTaxRs  int64  `json:"old_regime_tax_rs"`
	NewRegimeTaxRs  int64  `json:"new_regime_tax_rs"`
	Recommended     string `json:"recommended"`
	SavingRs        int64  `json:"saving_rs"`
	Total80CRs      int64  `json:"total_80c_rs"`
	HraExemptionRs  int64  `json:"hra_exemption_rs"`
	TotalDeductions int64  `json:"total_deductions_rs"`
	ItrForm         string `json:"itr_form"`
}

func taxHandler(w http.ResponseWriter, r *http.Request) {
	enableCORS(w)
	if r.Method == "OPTIONS" {
		w.WriteHeader(http.StatusOK)
		return
	}

	var req TaxRequest
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, "Invalid request", http.StatusBadRequest)
		return
	}

	resp := calculateTax(req)
	json.NewEncoder(w).Encode(resp)
}

func calculateTax(req TaxRequest) TaxResponse {
	gross := req.GrossIncomeRs
	basicRs := gross * 40 / 100

	// HRA exemption
	hraExem := int64(0)
	if req.RentPaidRs > 0 && req.HraReceivedRs > 0 {
		opt1 := req.HraReceivedRs
		opt2 := req.RentPaidRs - (basicRs * 10 / 100)
		opt3 := basicRs * 50 / 100
		if !req.IsMetro {
			opt3 = basicRs * 40 / 100
		}
		hraExem = min3(opt1, opt2, opt3)
		if hraExem < 0 {
			hraExem = 0
		}
	}

	// 80C
	total80C := req.EpfContribRs + req.Other80CRs
	if total80C > 150000 {
		total80C = 150000
	}

	// 80D
	health80D := req.HealthInsureRs
	if health80D > 25000 {
		health80D = 25000
	}

	// NPS 80CCD(1B)
	nps80CCD := req.NpsContribRs
	if nps80CCD > 50000 {
		nps80CCD = 50000
	}

	// Home loan 24(b)
	homeLoan := req.HomeLoanInterest
	if homeLoan > 200000 {
		homeLoan = 200000
	}

	// Old regime
	taxableOld := gross - 50000 - hraExem - total80C - health80D - nps80CCD - homeLoan
	if taxableOld < 0 {
		taxableOld = 0
	}
	oldTax := calcOldTax(taxableOld)
	if taxableOld <= 500000 {
		oldTax = 0
	}
	oldTaxWithCess := oldTax * 104 / 100

	// New regime
	taxableNew := gross - 75000
	if taxableNew < 0 {
		taxableNew = 0
	}
	newTax := calcNewTax(taxableNew)
	if taxableNew <= 1200000 {
		newTax = 0
	}
	newTaxWithCess := newTax * 104 / 100

	recommended := "New Regime"
	saving := oldTaxWithCess - newTaxWithCess
	if oldTaxWithCess < newTaxWithCess {
		recommended = "Old Regime"
		saving = newTaxWithCess - oldTaxWithCess
	}

	itrForm := "ITR-1 (Sahaj)"
	if gross > 5000000 {
		itrForm = "ITR-2"
	}

	totalDeductions := 50000 + hraExem + total80C + health80D + nps80CCD + homeLoan

	return TaxResponse{
		OldRegimeTaxRs:  oldTaxWithCess,
		NewRegimeTaxRs:  newTaxWithCess,
		Recommended:     recommended,
		SavingRs:        saving,
		Total80CRs:      total80C,
		HraExemptionRs:  hraExem,
		TotalDeductions: totalDeductions,
		ItrForm:         itrForm,
	}
}

func calcOldTax(income int64) int64 {
	switch {
	case income <= 250000:
		return 0
	case income <= 500000:
		return (income - 250000) * 5 / 100
	case income <= 1000000:
		return 12500 + (income-500000)*20/100
	default:
		return 112500 + (income-1000000)*30/100
	}
}

func calcNewTax(income int64) int64 {
	switch {
	case income <= 400000:
		return 0
	case income <= 800000:
		return (income - 400000) * 5 / 100
	case income <= 1200000:
		return 20000 + (income-800000)*10/100
	case income <= 1600000:
		return 60000 + (income-1200000)*15/100
	case income <= 2000000:
		return 120000 + (income-1600000)*20/100
	case income <= 2400000:
		return 200000 + (income-2000000)*25/100
	default:
		return 300000 + (income-2400000)*30/100
	}
}

func min3(a, b, c int64) int64 {
	if a < b && a < c {
		return a
	}
	if b < c {
		return b
	}
	return c
}

type Scheme struct {
	ID          string   `json:"id"`
	Name        string   `json:"name"`
	NameHindi   string   `json:"name_hindi"`
	Benefit     string   `json:"benefit"`
	Documents   []string `json:"documents"`
	ApplyAt     string   `json:"apply_at"`
}

func schemesHandler(w http.ResponseWriter, r *http.Request) {
	enableCORS(w)
	incomeStr := r.URL.Query().Get("annual_income")
	occupation := r.URL.Query().Get("occupation")

	income, _ := strconv.ParseInt(incomeStr, 10, 64)

	allSchemes := []Scheme{
		{ID: "pm_kisan", Name: "PM-KISAN", NameHindi: "पीएम किसान",
			Benefit:   "₹6,000/year in 3 installments of ₹2,000",
			Documents: []string{"Aadhaar Card", "Bank Passbook", "Land Records (7/12 Utara)"},
			ApplyAt:   "pmkisan.gov.in"},
		{ID: "pm_jjby", Name: "PM Jeevan Jyoti Bima", NameHindi: "पीएम जीवन ज्योति बीमा",
			Benefit:   "₹2 Lakh life insurance at ₹436/year",
			Documents: []string{"Aadhaar", "Bank account linked to Aadhaar"},
			ApplyAt:   "jansuraksha.gov.in"},
		{ID: "pm_sby", Name: "PM Suraksha Bima", NameHindi: "पीएम सुरक्षा बीमा",
			Benefit:   "₹2 Lakh accident cover at just ₹20/year",
			Documents: []string{"Aadhaar", "Bank account"},
			ApplyAt:   "jansuraksha.gov.in"},
		{ID: "apy", Name: "Atal Pension Yojana", NameHindi: "अटल पेंशन योजना",
			Benefit:   "Guaranteed pension ₹1,000–₹5,000/month after age 60",
			Documents: []string{"Aadhaar", "Bank account", "Mobile number"},
			ApplyAt:   "npscra.nsdl.co.in"},
		{ID: "sukanya", Name: "Sukanya Samriddhi Yojana", NameHindi: "सुकन्या समृद्धि योजना",
			Benefit:   "8.2% interest p.a. for girl child education/marriage",
			Documents: []string{"Girl child birth certificate", "Guardian Aadhaar", "PAN"},
			ApplyAt:   "indiapost.gov.in"},
		{ID: "mudra", Name: "PM Mudra Loan", NameHindi: "पीएम मुद्रा लोन",
			Benefit:   "Business loan up to ₹10 Lakhs without collateral",
			Documents: []string{"Aadhaar", "PAN", "Business proof", "Bank statement 6 months"},
			ApplyAt:   "mudra.org.in"},
		{ID: "pmay", Name: "PM Awas Yojana", NameHindi: "पीएम आवास योजना",
			Benefit:   "Subsidy up to ₹2.67 Lakh on home loan",
			Documents: []string{"Aadhaar", "Income certificate", "No pucca house declaration"},
			ApplyAt:   "pmaymis.gov.in"},
		{ID: "ayushman", Name: "Ayushman Bharat", NameHindi: "आयुष्मान भारत",
			Benefit:   "₹5 Lakh health insurance per family per year",
			Documents: []string{"Aadhaar", "Ration card"},
			ApplyAt:   "pmjay.gov.in"},
	}

	// Filter by eligibility
	var eligible []Scheme
	for _, scheme := range allSchemes {
		switch scheme.ID {
		case "pm_kisan":
			if occupation == "FARMER" {
				eligible = append(eligible, scheme)
			}
		case "mudra":
			if occupation == "SELF_EMPLOYED" && income < 5000000 {
				eligible = append(eligible, scheme)
			}
		case "ayushman":
			if income < 500000 {
				eligible = append(eligible, scheme)
			}
		case "pmay":
			if income < 1800000 {
				eligible = append(eligible, scheme)
			}
		default:
			// Universal schemes
			eligible = append(eligible, scheme)
		}
	}

	fmt.Printf("Returning %d eligible schemes for income=%d occupation=%s\n", len(eligible), income, occupation)
	json.NewEncoder(w).Encode(eligible)
}
