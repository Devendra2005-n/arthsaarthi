package com.arthsaarthi.presentation.expenses;

import com.arthsaarthi.data.db.TransactionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ExpenseListViewModel_Factory implements Factory<ExpenseListViewModel> {
  private final Provider<TransactionDao> transactionDaoProvider;

  public ExpenseListViewModel_Factory(Provider<TransactionDao> transactionDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
  }

  @Override
  public ExpenseListViewModel get() {
    return newInstance(transactionDaoProvider.get());
  }

  public static ExpenseListViewModel_Factory create(
      Provider<TransactionDao> transactionDaoProvider) {
    return new ExpenseListViewModel_Factory(transactionDaoProvider);
  }

  public static ExpenseListViewModel newInstance(TransactionDao transactionDao) {
    return new ExpenseListViewModel(transactionDao);
  }
}
