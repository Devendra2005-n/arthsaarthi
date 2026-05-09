package com.arthsaarthi.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ArthSaarthiDatabase_Impl extends ArthSaarthiDatabase {
  private volatile TransactionDao _transactionDao;

  private volatile UserProfileDao _userProfileDao;

  private volatile InvestmentDao _investmentDao;

  private volatile GoalDao _goalDao;

  private volatile LoanDao _loanDao;

  private volatile ChitFundDao _chitFundDao;

  private volatile GoldAssetDao _goldAssetDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_profiles` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `incomeType` TEXT NOT NULL, `monthlyIncomePaise` INTEGER NOT NULL, `cityTier` TEXT NOT NULL, `state` TEXT NOT NULL, `preferredLanguage` TEXT NOT NULL, `isOnboardingDone` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `transactions` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `amountPaise` INTEGER NOT NULL, `type` TEXT NOT NULL, `category` TEXT NOT NULL, `paymentMode` TEXT NOT NULL, `merchantName` TEXT NOT NULL, `note` TEXT NOT NULL, `dateMillis` INTEGER NOT NULL, `source` TEXT NOT NULL, `isVerified` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `investments` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT NOT NULL, `investedAmountPaise` INTEGER NOT NULL, `currentValuePaise` INTEGER NOT NULL, `interestRate` REAL NOT NULL, `startDateMillis` INTEGER NOT NULL, `maturityDateMillis` INTEGER NOT NULL, `sipDayOfMonth` INTEGER NOT NULL, `bankName` TEXT NOT NULL, `notes` TEXT NOT NULL, `lastUpdatedMillis` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `goals` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `name` TEXT NOT NULL, `goalType` TEXT NOT NULL, `targetAmountPaise` INTEGER NOT NULL, `savedAmountPaise` INTEGER NOT NULL, `deadlineMillis` INTEGER NOT NULL, `isCompleted` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `loans` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `loanType` TEXT NOT NULL, `bankName` TEXT NOT NULL, `principalAmountPaise` INTEGER NOT NULL, `emiAmountPaise` INTEGER NOT NULL, `interestRate` REAL NOT NULL, `startDateMillis` INTEGER NOT NULL, `tenureMonths` INTEGER NOT NULL, `remainingEmiCount` INTEGER NOT NULL, `notes` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `chit_funds` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `organizerName` TEXT NOT NULL, `totalAmountPaise` INTEGER NOT NULL, `monthlyInstalmentPaise` INTEGER NOT NULL, `durationMonths` INTEGER NOT NULL, `startDateMillis` INTEGER NOT NULL, `prizeReceivedPaise` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, `notes` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `gold_assets` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `weightGrams` REAL NOT NULL, `purity` TEXT NOT NULL, `purchasePricePerGramPaise` INTEGER NOT NULL, `purchaseDateMillis` INTEGER NOT NULL, `storageType` TEXT NOT NULL, `notes` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '69c5445cf6b727074e9f490c5bf24eb9')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `user_profiles`");
        _db.execSQL("DROP TABLE IF EXISTS `transactions`");
        _db.execSQL("DROP TABLE IF EXISTS `investments`");
        _db.execSQL("DROP TABLE IF EXISTS `goals`");
        _db.execSQL("DROP TABLE IF EXISTS `loans`");
        _db.execSQL("DROP TABLE IF EXISTS `chit_funds`");
        _db.execSQL("DROP TABLE IF EXISTS `gold_assets`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUserProfiles = new HashMap<String, TableInfo.Column>(9);
        _columnsUserProfiles.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("incomeType", new TableInfo.Column("incomeType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("monthlyIncomePaise", new TableInfo.Column("monthlyIncomePaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("cityTier", new TableInfo.Column("cityTier", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("state", new TableInfo.Column("state", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("preferredLanguage", new TableInfo.Column("preferredLanguage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("isOnboardingDone", new TableInfo.Column("isOnboardingDone", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProfiles.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserProfiles = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserProfiles = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserProfiles = new TableInfo("user_profiles", _columnsUserProfiles, _foreignKeysUserProfiles, _indicesUserProfiles);
        final TableInfo _existingUserProfiles = TableInfo.read(_db, "user_profiles");
        if (! _infoUserProfiles.equals(_existingUserProfiles)) {
          return new RoomOpenHelper.ValidationResult(false, "user_profiles(com.arthsaarthi.data.db.UserProfile).\n"
                  + " Expected:\n" + _infoUserProfiles + "\n"
                  + " Found:\n" + _existingUserProfiles);
        }
        final HashMap<String, TableInfo.Column> _columnsTransactions = new HashMap<String, TableInfo.Column>(13);
        _columnsTransactions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("amountPaise", new TableInfo.Column("amountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("paymentMode", new TableInfo.Column("paymentMode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("merchantName", new TableInfo.Column("merchantName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("note", new TableInfo.Column("note", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("dateMillis", new TableInfo.Column("dateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("isVerified", new TableInfo.Column("isVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("isDeleted", new TableInfo.Column("isDeleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransactions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransactions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransactions = new TableInfo("transactions", _columnsTransactions, _foreignKeysTransactions, _indicesTransactions);
        final TableInfo _existingTransactions = TableInfo.read(_db, "transactions");
        if (! _infoTransactions.equals(_existingTransactions)) {
          return new RoomOpenHelper.ValidationResult(false, "transactions(com.arthsaarthi.data.db.Transaction).\n"
                  + " Expected:\n" + _infoTransactions + "\n"
                  + " Found:\n" + _existingTransactions);
        }
        final HashMap<String, TableInfo.Column> _columnsInvestments = new HashMap<String, TableInfo.Column>(13);
        _columnsInvestments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("investedAmountPaise", new TableInfo.Column("investedAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("currentValuePaise", new TableInfo.Column("currentValuePaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("interestRate", new TableInfo.Column("interestRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("startDateMillis", new TableInfo.Column("startDateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("maturityDateMillis", new TableInfo.Column("maturityDateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("sipDayOfMonth", new TableInfo.Column("sipDayOfMonth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("bankName", new TableInfo.Column("bankName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInvestments.put("lastUpdatedMillis", new TableInfo.Column("lastUpdatedMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvestments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvestments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvestments = new TableInfo("investments", _columnsInvestments, _foreignKeysInvestments, _indicesInvestments);
        final TableInfo _existingInvestments = TableInfo.read(_db, "investments");
        if (! _infoInvestments.equals(_existingInvestments)) {
          return new RoomOpenHelper.ValidationResult(false, "investments(com.arthsaarthi.data.db.Investment).\n"
                  + " Expected:\n" + _infoInvestments + "\n"
                  + " Found:\n" + _existingInvestments);
        }
        final HashMap<String, TableInfo.Column> _columnsGoals = new HashMap<String, TableInfo.Column>(9);
        _columnsGoals.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("goalType", new TableInfo.Column("goalType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("targetAmountPaise", new TableInfo.Column("targetAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("savedAmountPaise", new TableInfo.Column("savedAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("deadlineMillis", new TableInfo.Column("deadlineMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoals = new TableInfo("goals", _columnsGoals, _foreignKeysGoals, _indicesGoals);
        final TableInfo _existingGoals = TableInfo.read(_db, "goals");
        if (! _infoGoals.equals(_existingGoals)) {
          return new RoomOpenHelper.ValidationResult(false, "goals(com.arthsaarthi.data.db.Goal).\n"
                  + " Expected:\n" + _infoGoals + "\n"
                  + " Found:\n" + _existingGoals);
        }
        final HashMap<String, TableInfo.Column> _columnsLoans = new HashMap<String, TableInfo.Column>(11);
        _columnsLoans.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("loanType", new TableInfo.Column("loanType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("bankName", new TableInfo.Column("bankName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("principalAmountPaise", new TableInfo.Column("principalAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("emiAmountPaise", new TableInfo.Column("emiAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("interestRate", new TableInfo.Column("interestRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("startDateMillis", new TableInfo.Column("startDateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("tenureMonths", new TableInfo.Column("tenureMonths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("remainingEmiCount", new TableInfo.Column("remainingEmiCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoans.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLoans = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLoans = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLoans = new TableInfo("loans", _columnsLoans, _foreignKeysLoans, _indicesLoans);
        final TableInfo _existingLoans = TableInfo.read(_db, "loans");
        if (! _infoLoans.equals(_existingLoans)) {
          return new RoomOpenHelper.ValidationResult(false, "loans(com.arthsaarthi.data.db.Loan).\n"
                  + " Expected:\n" + _infoLoans + "\n"
                  + " Found:\n" + _existingLoans);
        }
        final HashMap<String, TableInfo.Column> _columnsChitFunds = new HashMap<String, TableInfo.Column>(10);
        _columnsChitFunds.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("organizerName", new TableInfo.Column("organizerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("totalAmountPaise", new TableInfo.Column("totalAmountPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("monthlyInstalmentPaise", new TableInfo.Column("monthlyInstalmentPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("durationMonths", new TableInfo.Column("durationMonths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("startDateMillis", new TableInfo.Column("startDateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("prizeReceivedPaise", new TableInfo.Column("prizeReceivedPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChitFunds.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChitFunds = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChitFunds = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChitFunds = new TableInfo("chit_funds", _columnsChitFunds, _foreignKeysChitFunds, _indicesChitFunds);
        final TableInfo _existingChitFunds = TableInfo.read(_db, "chit_funds");
        if (! _infoChitFunds.equals(_existingChitFunds)) {
          return new RoomOpenHelper.ValidationResult(false, "chit_funds(com.arthsaarthi.data.db.ChitFund).\n"
                  + " Expected:\n" + _infoChitFunds + "\n"
                  + " Found:\n" + _existingChitFunds);
        }
        final HashMap<String, TableInfo.Column> _columnsGoldAssets = new HashMap<String, TableInfo.Column>(8);
        _columnsGoldAssets.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("weightGrams", new TableInfo.Column("weightGrams", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("purity", new TableInfo.Column("purity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("purchasePricePerGramPaise", new TableInfo.Column("purchasePricePerGramPaise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("purchaseDateMillis", new TableInfo.Column("purchaseDateMillis", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("storageType", new TableInfo.Column("storageType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoldAssets.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoldAssets = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoldAssets = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoldAssets = new TableInfo("gold_assets", _columnsGoldAssets, _foreignKeysGoldAssets, _indicesGoldAssets);
        final TableInfo _existingGoldAssets = TableInfo.read(_db, "gold_assets");
        if (! _infoGoldAssets.equals(_existingGoldAssets)) {
          return new RoomOpenHelper.ValidationResult(false, "gold_assets(com.arthsaarthi.data.db.GoldAsset).\n"
                  + " Expected:\n" + _infoGoldAssets + "\n"
                  + " Found:\n" + _existingGoldAssets);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "69c5445cf6b727074e9f490c5bf24eb9", "9230551e6138bbadd1ddaab291e4e5b7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_profiles","transactions","investments","goals","loans","chit_funds","gold_assets");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `user_profiles`");
      _db.execSQL("DELETE FROM `transactions`");
      _db.execSQL("DELETE FROM `investments`");
      _db.execSQL("DELETE FROM `goals`");
      _db.execSQL("DELETE FROM `loans`");
      _db.execSQL("DELETE FROM `chit_funds`");
      _db.execSQL("DELETE FROM `gold_assets`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TransactionDao.class, TransactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserProfileDao.class, UserProfileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(InvestmentDao.class, InvestmentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GoalDao.class, GoalDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LoanDao.class, LoanDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChitFundDao.class, ChitFundDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GoldAssetDao.class, GoldAssetDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public TransactionDao transactionDao() {
    if (_transactionDao != null) {
      return _transactionDao;
    } else {
      synchronized(this) {
        if(_transactionDao == null) {
          _transactionDao = new TransactionDao_Impl(this);
        }
        return _transactionDao;
      }
    }
  }

  @Override
  public UserProfileDao userProfileDao() {
    if (_userProfileDao != null) {
      return _userProfileDao;
    } else {
      synchronized(this) {
        if(_userProfileDao == null) {
          _userProfileDao = new UserProfileDao_Impl(this);
        }
        return _userProfileDao;
      }
    }
  }

  @Override
  public InvestmentDao investmentDao() {
    if (_investmentDao != null) {
      return _investmentDao;
    } else {
      synchronized(this) {
        if(_investmentDao == null) {
          _investmentDao = new InvestmentDao_Impl(this);
        }
        return _investmentDao;
      }
    }
  }

  @Override
  public GoalDao goalDao() {
    if (_goalDao != null) {
      return _goalDao;
    } else {
      synchronized(this) {
        if(_goalDao == null) {
          _goalDao = new GoalDao_Impl(this);
        }
        return _goalDao;
      }
    }
  }

  @Override
  public LoanDao loanDao() {
    if (_loanDao != null) {
      return _loanDao;
    } else {
      synchronized(this) {
        if(_loanDao == null) {
          _loanDao = new LoanDao_Impl(this);
        }
        return _loanDao;
      }
    }
  }

  @Override
  public ChitFundDao chitFundDao() {
    if (_chitFundDao != null) {
      return _chitFundDao;
    } else {
      synchronized(this) {
        if(_chitFundDao == null) {
          _chitFundDao = new ChitFundDao_Impl(this);
        }
        return _chitFundDao;
      }
    }
  }

  @Override
  public GoldAssetDao goldAssetDao() {
    if (_goldAssetDao != null) {
      return _goldAssetDao;
    } else {
      synchronized(this) {
        if(_goldAssetDao == null) {
          _goldAssetDao = new GoldAssetDao_Impl(this);
        }
        return _goldAssetDao;
      }
    }
  }
}
