package com.arthsaarthi.ml;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ2\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/arthsaarthi/ml/VoiceInputManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "recognizer", "Landroid/speech/SpeechRecognizer;", "destroy", "", "startListening", "languageCode", "", "onResult", "Lkotlin/Function1;", "onError", "Lkotlin/Function0;", "stop", "Companion", "app_debug"})
public final class VoiceInputManager {
    private final android.content.Context context = null;
    private android.speech.SpeechRecognizer recognizer;
    @org.jetbrains.annotations.NotNull
    public static final com.arthsaarthi.ml.VoiceInputManager.Companion Companion = null;
    
    public VoiceInputManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void startListening(@org.jetbrains.annotations.NotNull
    java.lang.String languageCode, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onResult, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
    
    public final void stop() {
    }
    
    public final void destroy() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/arthsaarthi/ml/VoiceInputManager$Companion;", "", "()V", "getLanguageCode", "", "langCode", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLanguageCode(@org.jetbrains.annotations.NotNull
        java.lang.String langCode) {
            return null;
        }
    }
}