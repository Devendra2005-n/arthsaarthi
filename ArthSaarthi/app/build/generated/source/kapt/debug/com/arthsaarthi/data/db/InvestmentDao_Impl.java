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
import java.lang.Long;
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
public final class InvestmentDao_Impl implements InvestmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Investment> __insertionAdapterOfInvestment;

  private final EntityDeletionOrUpdateAdapter<Investment> __deletionAdapterOfInvestment;

  private final EntityDeletionOrUpdateAdapter<Investment> __updateAdapterOfInvestment;

  public InvestmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvestment = new EntityInsertionAdapter<Investment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `investments` (`id`,`userId`,`type`,`name`,`investedAmountPaise`,`currentValuePaise`,`interestRate`,`startDateMillis`,`maturityDateMillis`,`sipDayOfMonth`,`bankName`,`notes`,`lastUpdatedMillis`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Investment value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        stmt.bindLong(5, value.getInvestedAmountPaise());
        stmt.bindLong(6, value.getCurrentValuePaise());
        stmt.bindDouble(7, value.getInterestRate());
        stmt.bindLong(8, value.getStartDateMillis());
        stmt.bindLong(9, value.getMaturityDateMillis());
        stmt.bindLong(10, value.getSipDayOfMonth());
        if (value.getBankName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBankName());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotes());
        }
        stmt.bindLong(13, value.getLastUpdatedMillis());
      }
    };
    this.__deletionAdapterOfInvestment = new EntityDeletionOrUpdateAdapter<Investment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `investments` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Investment value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfInvestment = new EntityDeletionOrUpdateAdapter<Investment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `investments` SET `id` = ?,`userId` = ?,`type` = ?,`name` = ?,`investedAmountPaise` = ?,`currentValuePaise` = ?,`interestRate` = ?,`startDateMillis` = ?,`maturityDateMillis` = ?,`sipDayOfMonth` = ?,`bankName` = ?,`notes` = ?,`lastUpdatedMillis` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Investment value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        stmt.bindLong(5, value.getInvestedAmountPaise());
        stmt.bindLong(6, value.getCurrentValuePaise());
        stmt.bindDouble(7, value.getInterestRate());
        stmt.bindLong(8, value.getStartDateMillis());
        stmt.bindLong(9, value.getMaturityDateMillis());
        stmt.bindLong(10, value.getSipDayOfMonth());
        if (value.getBankName() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBankName());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotes());
        }
        stmt.bindLong(13, value.getLastUpdatedMillis());
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final Investment investment, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInvestment.insert(investment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Investment investment, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfInvestment.handle(investment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Investment investment, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfInvestment.handle(investment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Investment>> getAllInvestments(final String userId) {
    final String _sql = "SELECT * FROM investments WHERE userId = ? ORDER BY type ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"investments"}, new Callable<List<Investment>>() {
      @Override
      public List<Investment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfInvestedAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "investedAmountPaise");
          final int _cursorIndexOfCurrentValuePaise = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValuePaise");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfStartDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "startDateMillis");
          final int _cursorIndexOfMaturityDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "maturityDateMillis");
          final int _cursorIndexOfSipDayOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "sipDayOfMonth");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfLastUpdatedMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdatedMillis");
          final List<Investment> _result = new ArrayList<Investment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Investment _item;
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
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpInvestedAmountPaise;
            _tmpInvestedAmountPaise = _cursor.getLong(_cursorIndexOfInvestedAmountPaise);
            final long _tmpCurrentValuePaise;
            _tmpCurrentValuePaise = _cursor.getLong(_cursorIndexOfCurrentValuePaise);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final long _tmpStartDateMillis;
            _tmpStartDateMillis = _cursor.getLong(_cursorIndexOfStartDateMillis);
            final long _tmpMaturityDateMillis;
            _tmpMaturityDateMillis = _cursor.getLong(_cursorIndexOfMaturityDateMillis);
            final int _tmpSipDayOfMonth;
            _tmpSipDayOfMonth = _cursor.getInt(_cursorIndexOfSipDayOfMonth);
            final String _tmpBankName;
            if (_cursor.isNull(_cursorIndexOfBankName)) {
              _tmpBankName = null;
            } else {
              _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpLastUpdatedMillis;
            _tmpLastUpdatedMillis = _cursor.getLong(_cursorIndexOfLastUpdatedMillis);
            _item = new Investment(_tmpId,_tmpUserId,_tmpType,_tmpName,_tmpInvestedAmountPaise,_tmpCurrentValuePaise,_tmpInterestRate,_tmpStartDateMillis,_tmpMaturityDateMillis,_tmpSipDayOfMonth,_tmpBankName,_tmpNotes,_tmpLastUpdatedMillis);
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

  @Override
  public Flow<List<Investment>> getByType(final String userId, final String type) {
    final String _sql = "SELECT * FROM investments WHERE userId = ? AND type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"investments"}, new Callable<List<Investment>>() {
      @Override
      public List<Investment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfInvestedAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "investedAmountPaise");
          final int _cursorIndexOfCurrentValuePaise = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValuePaise");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfStartDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "startDateMillis");
          final int _cursorIndexOfMaturityDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "maturityDateMillis");
          final int _cursorIndexOfSipDayOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "sipDayOfMonth");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfLastUpdatedMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdatedMillis");
          final List<Investment> _result = new ArrayList<Investment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Investment _item;
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
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpInvestedAmountPaise;
            _tmpInvestedAmountPaise = _cursor.getLong(_cursorIndexOfInvestedAmountPaise);
            final long _tmpCurrentValuePaise;
            _tmpCurrentValuePaise = _cursor.getLong(_cursorIndexOfCurrentValuePaise);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final long _tmpStartDateMillis;
            _tmpStartDateMillis = _cursor.getLong(_cursorIndexOfStartDateMillis);
            final long _tmpMaturityDateMillis;
            _tmpMaturityDateMillis = _cursor.getLong(_cursorIndexOfMaturityDateMillis);
            final int _tmpSipDayOfMonth;
            _tmpSipDayOfMonth = _cursor.getInt(_cursorIndexOfSipDayOfMonth);
            final String _tmpBankName;
            if (_cursor.isNull(_cursorIndexOfBankName)) {
              _tmpBankName = null;
            } else {
              _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpLastUpdatedMillis;
            _tmpLastUpdatedMillis = _cursor.getLong(_cursorIndexOfLastUpdatedMillis);
            _item = new Investment(_tmpId,_tmpUserId,_tmpType,_tmpName,_tmpInvestedAmountPaise,_tmpCurrentValuePaise,_tmpInterestRate,_tmpStartDateMillis,_tmpMaturityDateMillis,_tmpSipDayOfMonth,_tmpBankName,_tmpNotes,_tmpLastUpdatedMillis);
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

  @Override
  public Flow<Long> getTotalCurrentValue(final String userId) {
    final String _sql = "SELECT COALESCE(SUM(currentValuePaise), 0) FROM investments WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"investments"}, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
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
  public Flow<Long> getTotalInvested(final String userId) {
    final String _sql = "SELECT COALESCE(SUM(investedAmountPaise), 0) FROM investments WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"investments"}, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
