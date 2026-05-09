package com.arthsaarthi.di;

import com.arthsaarthi.data.db.ArthSaarthiDatabase;
import com.arthsaarthi.data.db.ChitFundDao;
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
public final class DatabaseModule_ProvideChitFundDaoFactory implements Factory<ChitFundDao> {
  private final Provider<ArthSaarthiDatabase> dbProvider;

  public DatabaseModule_ProvideChitFundDaoFactory(Provider<ArthSaarthiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ChitFundDao get() {
    return provideChitFundDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideChitFundDaoFactory create(
      Provider<ArthSaarthiDatabase> dbProvider) {
    return new DatabaseModule_ProvideChitFundDaoFactory(dbProvider);
  }

  public static ChitFundDao provideChitFundDao(ArthSaarthiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideChitFundDao(db));
  }
}
