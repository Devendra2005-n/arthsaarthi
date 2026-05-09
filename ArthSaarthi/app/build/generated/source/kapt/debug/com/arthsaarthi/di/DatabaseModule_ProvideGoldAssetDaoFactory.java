package com.arthsaarthi.di;

import com.arthsaarthi.data.db.ArthSaarthiDatabase;
import com.arthsaarthi.data.db.GoldAssetDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DatabaseModule_ProvideGoldAssetDaoFactory implements Factory<GoldAssetDao> {
  private final Provider<ArthSaarthiDatabase> dbProvider;

  public DatabaseModule_ProvideGoldAssetDaoFactory(Provider<ArthSaarthiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public GoldAssetDao get() {
    return provideGoldAssetDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideGoldAssetDaoFactory create(
      Provider<ArthSaarthiDatabase> dbProvider) {
    return new DatabaseModule_ProvideGoldAssetDaoFactory(dbProvider);
  }

  public static GoldAssetDao provideGoldAssetDao(ArthSaarthiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideGoldAssetDao(db));
  }
}
