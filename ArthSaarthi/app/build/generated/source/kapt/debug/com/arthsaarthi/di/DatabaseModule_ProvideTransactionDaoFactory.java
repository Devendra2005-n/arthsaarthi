package com.arthsaarthi.di;

import com.arthsaarthi.data.db.ArthSaarthiDatabase;
import com.arthsaarthi.data.db.TransactionDao;
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
public final class DatabaseModule_ProvideTransactionDaoFactory implements Factory<TransactionDao> {
  private final Provider<ArthSaarthiDatabase> dbProvider;

  public DatabaseModule_ProvideTransactionDaoFactory(Provider<ArthSaarthiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TransactionDao get() {
    return provideTransactionDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideTransactionDaoFactory create(
      Provider<ArthSaarthiDatabase> dbProvider) {
    return new DatabaseModule_ProvideTransactionDaoFactory(dbProvider);
  }

  public static TransactionDao provideTransactionDao(ArthSaarthiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTransactionDao(db));
  }
}
