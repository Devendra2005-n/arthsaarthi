package com.arthsaarthi.di;

import com.arthsaarthi.data.db.ArthSaarthiDatabase;
import com.arthsaarthi.data.db.LoanDao;
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
public final class DatabaseModule_ProvideLoanDaoFactory implements Factory<LoanDao> {
  private final Provider<ArthSaarthiDatabase> dbProvider;

  public DatabaseModule_ProvideLoanDaoFactory(Provider<ArthSaarthiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public LoanDao get() {
    return provideLoanDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideLoanDaoFactory create(
      Provider<ArthSaarthiDatabase> dbProvider) {
    return new DatabaseModule_ProvideLoanDaoFactory(dbProvider);
  }

  public static LoanDao provideLoanDao(ArthSaarthiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideLoanDao(db));
  }
}
