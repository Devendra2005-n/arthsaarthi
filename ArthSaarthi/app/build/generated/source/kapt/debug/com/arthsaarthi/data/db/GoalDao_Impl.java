package com.arthsaarthi.data.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GoalDao_Impl implements GoalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Goal> __insertionAdapterOfGoal;

  private final EntityDeletionOrUpdateAdapter<Goal> __deletionAdapterOfGoal;

  private final EntityDeletionOrUpdateAdapter<Goal> __updateAdapterOfGoal;

  public GoalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGoal = new EntityInsertionAdapter<Goal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `goals` (`id`,`userId`,`name`,`goalType`,`targetAmountPaise`,`savedAmountPaise`,`deadlineMillis`,`isCompleted`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goal value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getGoalType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGoalType());
        }
        stmt.bindLong(5, value.getTargetAmountPaise());
        stmt.bindLong(6, value.getSavedAmountPaise());
        stmt.bindLong(7, value.getDeadlineMillis());
        final int _tmp = value.isCompleted() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getCreatedAt());
      }
    };
    this.__deletionAdapterOfGoal = new EntityDeletionOrUpdateAdapter<Goal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `goals` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goal value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfGoal = new EntityDeletionOrUpdateAdapter<Goal>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `goals` SET `id` = ?,`userId` = ?,`name` = ?,`goalType` = ?,`targetAmountPaise` = ?,`savedAmountPaise` = ?,`deadlineMillis` = ?,`isCompleted` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goal value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getGoalType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGoalType());
        }
        stmt.bindLong(5, value.getTargetAmountPaise());
        stmt.bindLong(6, value.getSavedAmountPaise());
        stmt.bindLong(7, value.getDeadlineMillis());
        final int _tmp = value.isCompleted() ? 1 : 0;
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
  public Object insert(final Goal goal, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGoal.insert(goal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Goal goal, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGoal.handle(goal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Goal goal, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGoal.handle(goal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Goal>> getActiveGoals(final String userId) {
    final String _sql = "SELECT * FROM goals WHERE userId = ? AND isCompleted = 0 ORDER BY deadlineMillis ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"goals"}, new Callable<List<Goal>>() {
      @Override
      public List<Goal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfGoalType = CursorUtil.getColumnIndexOrThrow(_cursor, "goalType");
          final int _cursorIndexOfTargetAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "targetAmountPaise");
          final int _cursorIndexOfSavedAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "savedAmountPaise");
          final int _cursorIndexOfDeadlineMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "deadlineMillis");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Goal> _result = new ArrayList<Goal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Goal _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpGoalType;
            if (_cursor.isNull(_cursorIndexOfGoalType)) {
              _tmpGoalType = null;
            } else {
              _tmpGoalType = _cursor.getString(_cursorIndexOfGoalType);
            }
            final long _tmpTargetAmountPaise;
            _tmpTargetAmountPaise = _cursor.getLong(_cursorIndexOfTargetAmountPaise);
            final long _tmpSavedAmountPaise;
            _tmpSavedAmountPaise = _cursor.getLong(_cursorIndexOfSavedAmountPaise);
            final long _tmpDeadlineMillis;
            _tmpDeadlineMillis = _cursor.getLong(_cursorIndexOfDeadlineMillis);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Goal(_tmpId,_tmpUserId,_tmpName,_tmpGoalType,_tmpTargetAmountPaise,_tmpSavedAmountPaise,_tmpDeadlineMillis,_tmpIsCompleted,_tmpCreatedAt);
            _result.add(_item);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
