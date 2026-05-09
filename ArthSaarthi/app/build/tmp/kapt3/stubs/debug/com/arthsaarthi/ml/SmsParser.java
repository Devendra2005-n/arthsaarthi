package com.arthsaarthi.ml;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.util.Log;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tJ%\u0010\u0011\u001a\u00020\u0012*\u00020\t2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0014\"\u00020\tH\u0002\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/arthsaarthi/ml/SmsParser;", "", "()V", "AMOUNT_PATTERN", "Lkotlin/text/Regex;", "IS_CREDIT", "IS_DEBIT", "UPI_MERCHANTS", "", "", "Lkotlin/Pair;", "extractMerchantFallback", "body", "guessCategory", "parse", "Lcom/arthsaarthi/ml/ParsedSms;", "smsBody", "containsAny", "", "words", "", "(Ljava/lang/String;[Ljava/lang/String;)Z", "app_debug"})
public final class SmsParser {
    @org.jetbrains.annotations.NotNull
    public static final com.arthsaarthi.ml.SmsParser INSTANCE = null;
    private static final kotlin.text.Regex AMOUNT_PATTERN = null;
    private static final kotlin.text.Regex IS_DEBIT = null;
    private static final kotlin.text.Regex IS_CREDIT = null;
    private static final java.util.Map<java.lang.String, kotlin.Pair<java.lang.String, java.lang.String>> UPI_MERCHANTS = null;
    
    private SmsParser() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.arthsaarthi.ml.ParsedSms parse(@org.jetbrains.annotations.NotNull
    java.lang.String smsBody) {
        return null;
    }
    
    private final java.lang.String extractMerchantFallback(java.lang.String body) {
        return null;
    }
    
    private final java.lang.String guessCategory(java.lang.String body) {
        return null;
    }
    
    private final boolean containsAny(java.lang.String $this$containsAny, java.lang.String... words) {
        return false;
    }
}