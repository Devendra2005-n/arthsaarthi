package com.arthsaarthi.presentation.tax;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class TaxViewModel_Factory implements Factory<TaxViewModel> {
  @Override
  public TaxViewModel get() {
    return newInstance();
  }

  public static TaxViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TaxViewModel newInstance() {
    return new TaxViewModel();
  }

  private static final class InstanceHolder {
    private static final TaxViewModel_Factory INSTANCE = new TaxViewModel_Factory();
  }
}
