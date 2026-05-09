package com.arthsaarthi.data.db;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\'J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/arthsaarthi/data/db/UserProfileDao;", "", "getProfile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/arthsaarthi/data/db/UserProfile;", "getProfileOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "profile", "(Lcom/arthsaarthi/data/db/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOnboardingDone", "", "update", "app_debug"})
public abstract interface UserProfileDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.UserProfile profile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.UserProfile profile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM user_profiles WHERE id = \'default_user\' LIMIT 1")
    public abstract kotlinx.coroutines.flow.Flow<com.arthsaarthi.data.db.UserProfile> getProfile();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM user_profiles WHERE id = \'default_user\' LIMIT 1")
    public abstract java.lang.Object getProfileOnce(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.arthsaarthi.data.db.UserProfile> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT isOnboardingDone FROM user_profiles WHERE id = \'default_user\' LIMIT 1")
    public abstract java.lang.Object isOnboardingDone(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
}