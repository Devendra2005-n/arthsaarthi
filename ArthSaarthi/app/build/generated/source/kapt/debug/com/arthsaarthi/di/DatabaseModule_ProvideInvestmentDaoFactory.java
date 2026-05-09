package com.arthsaarthi.di;

import com.arthsaarthi.data.db.ArthSaarthiDatabase;
import com.arthsaarthi.data.db.InvestmentDao;
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
public final class DatabaseModule_ProvideInvestmentDaoFactory implements Factory<InvestmentDao> {
  private final Provider<ArthSaarthiDatabase> dbProvider;

  public DatabaseModule_ProvideInvestmentDaoFactory(Provider<ArthSaarthiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public InvestmentDao get() {
    return provideInvestmentDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideInvestmentDaoFactory create(
      Provider<ArthSaarthiDatabase> dbProvider) {
    return new DatabaseModule_ProvideInvestmentDaoFactory(dbProvider);
  }

  public static InvestmentDao provideInvestmentDao(ArthSaarthiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideInvestmentDao(db));
  }
}
