package com.arthsaarthi.presentation.settings;

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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<UserProfileDao> userProfileDaoProvider;

  public SettingsViewModel_Factory(Provider<UserProfileDao> userProfileDaoProvider) {
    this.userProfileDaoProvider = userProfileDaoProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(userProfileDaoProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<UserProfileDao> userProfileDaoProvider) {
    return new SettingsViewModel_Factory(userProfileDaoProvider);
  }

  public static SettingsViewModel newInstance(UserProfileDao userProfileDao) {
    return new SettingsViewModel(userProfileDao);
  }
}
