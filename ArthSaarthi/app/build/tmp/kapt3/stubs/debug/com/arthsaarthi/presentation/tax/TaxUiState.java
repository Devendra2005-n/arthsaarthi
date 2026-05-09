package com.arthsaarthi.presentation.tax;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b>\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00e1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001bJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\fH\u00c6\u0003J\t\u00106\u001a\u00020\u000fH\u00c6\u0003J\t\u00107\u001a\u00020\u000fH\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u000fH\u00c6\u0003J\t\u0010:\u001a\u00020\u000fH\u00c6\u0003J\t\u0010;\u001a\u00020\u000fH\u00c6\u0003J\t\u0010<\u001a\u00020\u000fH\u00c6\u0003J\t\u0010=\u001a\u00020\u000fH\u00c6\u0003J\t\u0010>\u001a\u00020\u000fH\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u000fH\u00c6\u0003J\t\u0010A\u001a\u00020\u000fH\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\fH\u00c6\u0003J\u00e5\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010K\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010M\u001a\u00020NH\u00d6\u0001J\t\u0010O\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010&R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u0017\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0019\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010 \u00a8\u0006P"}, d2 = {"Lcom/arthsaarthi/presentation/tax/TaxUiState;", "", "grossIncome", "", "hraReceived", "rentPaid", "epfContrib", "other80C", "healthInsurance", "npsContrib", "homeLoanInterest", "isMetro", "", "showResults", "oldRegimeTax", "", "newRegimeTax", "recommended", "saving", "standardDeduction", "hraExemption", "total80C", "health80D", "nps80CCD", "homeLoan24b", "totalDeductions", "itrForm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJJLjava/lang/String;JJJJJJJJLjava/lang/String;)V", "getEpfContrib", "()Ljava/lang/String;", "getGrossIncome", "getHealth80D", "()J", "getHealthInsurance", "getHomeLoan24b", "getHomeLoanInterest", "getHraExemption", "getHraReceived", "()Z", "getItrForm", "getNewRegimeTax", "getNps80CCD", "getNpsContrib", "getOldRegimeTax", "getOther80C", "getRecommended", "getRentPaid", "getSaving", "getShowResults", "getStandardDeduction", "getTotal80C", "getTotalDeductions", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class TaxUiState {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String grossIncome = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String hraReceived = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String rentPaid = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String epfContrib = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String other80C = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String healthInsurance = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String npsContrib = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String homeLoanInterest = null;
    private final boolean isMetro = false;
    private final boolean showResults = false;
    private final long oldRegimeTax = 0L;
    private final long newRegimeTax = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String recommended = null;
    private final long saving = 0L;
    private final long standardDeduction = 0L;
    private final long hraExemption = 0L;
    private final long total80C = 0L;
    private final long health80D = 0L;
    private final long nps80CCD = 0L;
    private final long homeLoan24b = 0L;
    private final long totalDeductions = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String itrForm = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.arthsaarthi.presentation.tax.TaxUiState copy(@org.jetbrains.annotations.NotNull
    java.lang.String grossIncome, @org.jetbrains.annotations.NotNull
    java.lang.String hraReceived, @org.jetbrains.annotations.NotNull
    java.lang.String rentPaid, @org.jetbrains.annotations.NotNull
    java.lang.String epfContrib, @org.jetbrains.annotations.NotNull
    java.lang.String other80C, @org.jetbrains.annotations.NotNull
    java.lang.String healthInsurance, @org.jetbrains.annotations.NotNull
    java.lang.String npsContrib, @org.jetbrains.annotations.NotNull
    java.lang.String homeLoanInterest, boolean isMetro, boolean showResults, long oldRegimeTax, long newRegimeTax, @org.jetbrains.annotations.NotNull
    java.lang.String recommended, long saving, long standardDeduction, long hraExemption, long total80C, long health80D, long nps80CCD, long homeLoan24b, long totalDeductions, @org.jetbrains.annotations.NotNull
    java.lang.String itrForm) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TaxUiState() {
        super();
    }
    
    public TaxUiState(@org.jetbrains.annotations.NotNull
    java.lang.String grossIncome, @org.jetbrains.annotations.NotNull
    java.lang.String hraReceived, @org.jetbrains.annotations.NotNull
    java.lang.String rentPaid, @org.jetbrains.annotations.NotNull
    java.lang.String epfContrib, @org.jetbrains.annotations.NotNull
    java.lang.String other80C, @org.jetbrains.annotations.NotNull
    java.lang.String healthInsurance, @org.jetbrains.annotations.NotNull
    java.lang.String npsContrib, @org.jetbrains.annotations.NotNull
    java.lang.String homeLoanInterest, boolean isMetro, boolean showResults, long oldRegimeTax, long newRegimeTax, @org.jetbrains.annotations.NotNull
    java.lang.String recommended, long saving, long standardDeduction, long hraExemption, long total80C, long health80D, long nps80CCD, long homeLoan24b, long totalDeductions, @org.jetbrains.annotations.NotNull
    java.lang.String itrForm) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGrossIncome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHraReceived() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRentPaid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEpfContrib() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOther80C() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHealthInsurance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNpsContrib() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHomeLoanInterest() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isMetro() {
        return false;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getShowResults() {
        return false;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final long getOldRegimeTax() {
        return 0L;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long getNewRegimeTax() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecommended() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long getSaving() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    public final long getStandardDeduction() {
        return 0L;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final long getHraExemption() {
        return 0L;
    }
    
    public final long component17() {
        return 0L;
    }
    
    public final long getTotal80C() {
        return 0L;
    }
    
    public final long component18() {
        return 0L;
    }
    
    public final long getHealth80D() {
        return 0L;
    }
    
    public final long component19() {
        return 0L;
    }
    
    public final long getNps80CCD() {
        return 0L;
    }
    
    public final long component20() {
        return 0L;
    }
    
    public final long getHomeLoan24b() {
        return 0L;
    }
    
    public final long component21() {
        return 0L;
    }
    
    public final long getTotalDeductions() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getItrForm() {
        return null;
    }
}