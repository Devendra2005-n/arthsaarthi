package com.arthsaarthi.presentation.home;

import com.arthsaarthi.data.db.InvestmentDao;
import com.arthsaarthi.data.db.LoanDao;
import com.arthsaarthi.data.db.TransactionDao;
import com.arthsaarthi.data.db.UserProfileDao;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<UserProfileDao> userProfileDaoProvider;

  private final Provider<InvestmentDao> investmentDaoProvider;

  private final Provider<LoanDao> loanDaoProvider;

  public HomeViewModel_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<UserProfileDao> userProfileDaoProvider,
      Provider<InvestmentDao> investmentDaoProvider, Provider<LoanDao> loanDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.userProfileDaoProvider = userProfileDaoProvider;
    this.investmentDaoProvider = investmentDaoProvider;
    this.loanDaoProvider = loanDaoProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(transactionDaoProvider.get(), userProfileDaoProvider.get(), investmentDaoProvider.get(), loanDaoProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<TransactionDao> transactionDaoProvider,
      Provider<UserProfileDao> userProfileDaoProvider,
      Provider<InvestmentDao> investmentDaoProvider, Provider<LoanDao> loanDaoProvider) {
    return new HomeViewModel_Factory(transactionDaoProvider, userProfileDaoProvider, investmentDaoProvider, loanDaoProvider);
  }

  public static HomeViewModel newInstance(TransactionDao transactionDao,
      UserProfileDao userProfileDao, InvestmentDao investmentDao, LoanDao loanDao) {
    return new HomeViewModel(transactionDao, userProfileDao, investmentDao, loanDao);
  }
}
