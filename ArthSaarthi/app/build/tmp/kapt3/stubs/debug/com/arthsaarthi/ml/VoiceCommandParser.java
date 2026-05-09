package com.arthsaarthi.ml;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006J%\u0010\u000f\u001a\u00020\u000b*\u00020\u00062\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0011\"\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/arthsaarthi/ml/VoiceCommandParser;", "", "()V", "extractAmount", "", "text", "", "(Ljava/lang/String;)Ljava/lang/Long;", "extractCategory", "extractPaymentMode", "isIncomeTransaction", "", "parse", "Lcom/arthsaarthi/ml/ParsedVoiceCommand;", "language", "containsAny", "words", "", "(Ljava/lang/String;[Ljava/lang/String;)Z", "app_debug"})
public final class VoiceCommandParser {
    @org.jetbrains.annotations.NotNull
    public static final com.arthsaarthi.ml.VoiceCommandParser INSTANCE = null;
    
    private VoiceCommandParser() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.arthsaarthi.ml.ParsedVoiceCommand parse(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    java.lang.String language) {
        return null;
    }
    
    private final java.lang.Long extractAmount(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractCategory(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractPaymentMode(java.lang.String text) {
        return null;
    }
    
    private final boolean isIncomeTransaction(java.lang.String text) {
        return false;
    }
    
    private final boolean containsAny(java.lang.String $this$containsAny, java.lang.String... words) {
        return false;
    }
}