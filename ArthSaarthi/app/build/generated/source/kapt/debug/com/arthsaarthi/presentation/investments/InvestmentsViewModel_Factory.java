package com.arthsaarthi.presentation.investments;

import com.arthsaarthi.data.db.InvestmentDao;
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
public final class InvestmentsViewModel_Factory implements Factory<InvestmentsViewModel> {
  private final Provider<InvestmentDao> investmentDaoProvider;

  public InvestmentsViewModel_Factory(Provider<InvestmentDao> investmentDaoProvider) {
    this.investmentDaoProvider = investmentDaoProvider;
  }

  @Override
  public InvestmentsViewModel get() {
    return newInstance(investmentDaoProvider.get());
  }

  public static InvestmentsViewModel_Factory create(Provider<InvestmentDao> investmentDaoProvider) {
    return new InvestmentsViewModel_Factory(investmentDaoProvider);
  }

  public static InvestmentsViewModel newInstance(InvestmentDao investmentDao) {
    return new InvestmentsViewModel(investmentDao);
  }
}
