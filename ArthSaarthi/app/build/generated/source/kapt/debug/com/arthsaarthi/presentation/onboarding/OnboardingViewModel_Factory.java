package com.arthsaarthi.presentation.onboarding;

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
public final class OnboardingViewModel_Factory implements Factory<OnboardingViewModel> {
  private final Provider<UserProfileDao> userProfileDaoProvider;

  public OnboardingViewModel_Factory(Provider<UserProfileDao> userProfileDaoProvider) {
    this.userProfileDaoProvider = userProfileDaoProvider;
  }

  @Override
  public OnboardingViewModel get() {
    return newInstance(userProfileDaoProvider.get());
  }

  public static OnboardingViewModel_Factory create(
      Provider<UserProfileDao> userProfileDaoProvider) {
    return new OnboardingViewModel_Factory(userProfileDaoProvider);
  }

  public static OnboardingViewModel newInstance(UserProfileDao userProfileDao) {
    return new OnboardingViewModel(userProfileDao);
  }
}
