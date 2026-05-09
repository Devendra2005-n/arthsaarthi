# ArthSaarthi ProGuard Rules
-keep class in.arthsaarthi.data.db.** { *; }
-keep class in.arthsaarthi.domain.model.** { *; }
-keepattributes *Annotation*
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
