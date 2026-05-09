package com.arthsaarthi.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserProfileDao_Impl implements UserProfileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserProfile> __insertionAdapterOfUserProfile;

  private final EntityDeletionOrUpdateAdapter<UserProfile> __updateAdapterOfUserProfile;

  public UserProfileDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserProfile = new EntityInsertionAdapter<UserProfile>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user_profiles` (`id`,`name`,`incomeType`,`monthlyIncomePaise`,`cityTier`,`state`,`preferredLanguage`,`isOnboardingDone`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserProfile value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getIncomeType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIncomeType());
        }
        stmt.bindLong(4, value.getMonthlyIncomePaise());
        if (value.getCityTier() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCityTier());
        }
        if (value.getState() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getState());
        }
        if (value.getPreferredLanguage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPreferredLanguage());
        }
        final int _tmp = value.isOnboardingDone() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getCreatedAt());
      }
    };
    this.__updateAdapterOfUserProfile = new EntityDeletionOrUpdateAdapter<UserProfile>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user_profiles` SET `id` = ?,`name` = ?,`incomeType` = ?,`monthlyIncomePaise` = ?,`cityTier` = ?,`state` = ?,`preferredLanguage` = ?,`isOnboardingDone` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserProfile value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getIncomeType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIncomeType());
        }
        stmt.bindLong(4, value.getMonthlyIncomePaise());
        if (value.getCityTier() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCityTier());
        }
        if (value.getState() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getState());
        }
        if (value.getPreferredLanguage() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPreferredLanguage());
        }
        final int _tmp = value.isOnboardingDone() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getCreatedAt());
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final UserProfile profile, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserProfile.insert(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final UserProfile profile, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserProfile.handle(profile);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<UserProfile> getProfile() {
    final String _sql = "SELECT * FROM user_profiles WHERE id = 'default_user' LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"user_profiles"}, new Callable<UserProfile>() {
      @Override
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfIncomeType = CursorUtil.getColumnIndexOrThrow(_cursor, "incomeType");
          final int _cursorIndexOfMonthlyIncomePaise = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyIncomePaise");
          final int _cursorIndexOfCityTier = CursorUtil.getColumnIndexOrThrow(_cursor, "cityTier");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfPreferredLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredLanguage");
          final int _cursorIndexOfIsOnboardingDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnboardingDone");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final UserProfile _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpIncomeType;
            if (_cursor.isNull(_cursorIndexOfIncomeType)) {
              _tmpIncomeType = null;
            } else {
              _tmpIncomeType = _cursor.getString(_cursorIndexOfIncomeType);
            }
            final long _tmpMonthlyIncomePaise;
            _tmpMonthlyIncomePaise = _cursor.getLong(_cursorIndexOfMonthlyIncomePaise);
            final String _tmpCityTier;
            if (_cursor.isNull(_cursorIndexOfCityTier)) {
              _tmpCityTier = null;
            } else {
              _tmpCityTier = _cursor.getString(_cursorIndexOfCityTier);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpPreferredLanguage;
            if (_cursor.isNull(_cursorIndexOfPreferredLanguage)) {
              _tmpPreferredLanguage = null;
            } else {
              _tmpPreferredLanguage = _cursor.getString(_cursorIndexOfPreferredLanguage);
            }
            final boolean _tmpIsOnboardingDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsOnboardingDone);
            _tmpIsOnboardingDone = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new UserProfile(_tmpId,_tmpName,_tmpIncomeType,_tmpMonthlyIncomePaise,_tmpCityTier,_tmpState,_tmpPreferredLanguage,_tmpIsOnboardingDone,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getProfileOnce(final Continuation<? super UserProfile> continuation) {
    final String _sql = "SELECT * FROM user_profiles WHERE id = 'default_user' LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserProfile>() {
      @Override
      public UserProfile call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfIncomeType = CursorUtil.getColumnIndexOrThrow(_cursor, "incomeType");
          final int _cursorIndexOfMonthlyIncomePaise = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyIncomePaise");
          final int _cursorIndexOfCityTier = CursorUtil.getColumnIndexOrThrow(_cursor, "cityTier");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfPreferredLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "preferredLanguage");
          final int _cursorIndexOfIsOnboardingDone = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnboardingDone");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final UserProfile _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpIncomeType;
            if (_cursor.isNull(_cursorIndexOfIncomeType)) {
              _tmpIncomeType = null;
            } else {
              _tmpIncomeType = _cursor.getString(_cursorIndexOfIncomeType);
            }
            final long _tmpMonthlyIncomePaise;
            _tmpMonthlyIncomePaise = _cursor.getLong(_cursorIndexOfMonthlyIncomePaise);
            final String _tmpCityTier;
            if (_cursor.isNull(_cursorIndexOfCityTier)) {
              _tmpCityTier = null;
            } else {
              _tmpCityTier = _cursor.getString(_cursorIndexOfCityTier);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpPreferredLanguage;
            if (_cursor.isNull(_cursorIndexOfPreferredLanguage)) {
              _tmpPreferredLanguage = null;
            } else {
              _tmpPreferredLanguage = _cursor.getString(_cursorIndexOfPreferredLanguage);
            }
            final boolean _tmpIsOnboardingDone;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsOnboardingDone);
            _tmpIsOnboardingDone = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new UserProfile(_tmpId,_tmpName,_tmpIncomeType,_tmpMonthlyIncomePaise,_tmpCityTier,_tmpState,_tmpPreferredLanguage,_tmpIsOnboardingDone,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object isOnboardingDone(final Continuation<? super Boolean> continuation) {
    final String _sql = "SELECT isOnboardingDone FROM user_profiles WHERE id = 'default_user' LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
