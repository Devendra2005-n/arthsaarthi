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
public final class LoanDao_Impl implements LoanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Loan> __insertionAdapterOfLoan;

  private final EntityDeletionOrUpdateAdapter<Loan> __deletionAdapterOfLoan;

  private final EntityDeletionOrUpdateAdapter<Loan> __updateAdapterOfLoan;

  public LoanDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoan = new EntityInsertionAdapter<Loan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `loans` (`id`,`userId`,`loanType`,`bankName`,`principalAmountPaise`,`emiAmountPaise`,`interestRate`,`startDateMillis`,`tenureMonths`,`remainingEmiCount`,`notes`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Loan value) {
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
        if (value.getLoanType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLoanType());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBankName());
        }
        stmt.bindLong(5, value.getPrincipalAmountPaise());
        stmt.bindLong(6, value.getEmiAmountPaise());
        stmt.bindDouble(7, value.getInterestRate());
        stmt.bindLong(8, value.getStartDateMillis());
        stmt.bindLong(9, value.getTenureMonths());
        stmt.bindLong(10, value.getRemainingEmiCount());
        if (value.getNotes() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getNotes());
        }
      }
    };
    this.__deletionAdapterOfLoan = new EntityDeletionOrUpdateAdapter<Loan>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `loans` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Loan value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfLoan = new EntityDeletionOrUpdateAdapter<Loan>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `loans` SET `id` = ?,`userId` = ?,`loanType` = ?,`bankName` = ?,`principalAmountPaise` = ?,`emiAmountPaise` = ?,`interestRate` = ?,`startDateMillis` = ?,`tenureMonths` = ?,`remainingEmiCount` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Loan value) {
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
        if (value.getLoanType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLoanType());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBankName());
        }
        stmt.bindLong(5, value.getPrincipalAmountPaise());
        stmt.bindLong(6, value.getEmiAmountPaise());
        stmt.bindDouble(7, value.getInterestRate());
        stmt.bindLong(8, value.getStartDateMillis());
        stmt.bindLong(9, value.getTenureMonths());
        stmt.bindLong(10, value.getRemainingEmiCount());
        if (value.getNotes() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getNotes());
        }
        if (value.getId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final Loan loan, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLoan.insert(loan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final Loan loan, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfLoan.handle(loan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Loan loan, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLoan.handle(loan);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Loan>> getAllLoans(final String userId) {
    final String _sql = "SELECT * FROM loans WHERE userId = ? ORDER BY emiAmountPaise DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"loans"}, new Callable<List<Loan>>() {
      @Override
      public List<Loan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfLoanType = CursorUtil.getColumnIndexOrThrow(_cursor, "loanType");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
          final int _cursorIndexOfPrincipalAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "principalAmountPaise");
          final int _cursorIndexOfEmiAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "emiAmountPaise");
          final int _cursorIndexOfInterestRate = CursorUtil.getColumnIndexOrThrow(_cursor, "interestRate");
          final int _cursorIndexOfStartDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "startDateMillis");
          final int _cursorIndexOfTenureMonths = CursorUtil.getColumnIndexOrThrow(_cursor, "tenureMonths");
          final int _cursorIndexOfRemainingEmiCount = CursorUtil.getColumnIndexOrThrow(_cursor, "remainingEmiCount");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Loan> _result = new ArrayList<Loan>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Loan _item;
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
            final String _tmpLoanType;
            if (_cursor.isNull(_cursorIndexOfLoanType)) {
              _tmpLoanType = null;
            } else {
              _tmpLoanType = _cursor.getString(_cursorIndexOfLoanType);
            }
            final String _tmpBankName;
            if (_cursor.isNull(_cursorIndexOfBankName)) {
              _tmpBankName = null;
            } else {
              _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
            }
            final long _tmpPrincipalAmountPaise;
            _tmpPrincipalAmountPaise = _cursor.getLong(_cursorIndexOfPrincipalAmountPaise);
            final long _tmpEmiAmountPaise;
            _tmpEmiAmountPaise = _cursor.getLong(_cursorIndexOfEmiAmountPaise);
            final double _tmpInterestRate;
            _tmpInterestRate = _cursor.getDouble(_cursorIndexOfInterestRate);
            final long _tmpStartDateMillis;
            _tmpStartDateMillis = _cursor.getLong(_cursorIndexOfStartDateMillis);
            final int _tmpTenureMonths;
            _tmpTenureMonths = _cursor.getInt(_cursorIndexOfTenureMonths);
            final int _tmpRemainingEmiCount;
            _tmpRemainingEmiCount = _cursor.getInt(_cursorIndexOfRemainingEmiCount);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Loan(_tmpId,_tmpUserId,_tmpLoanType,_tmpBankName,_tmpPrincipalAmountPaise,_tmpEmiAmountPaise,_tmpInterestRate,_tmpStartDateMillis,_tmpTenureMonths,_tmpRemainingEmiCount,_tmpNotes);
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
  public Flow<Long> getTotalEmiPerMonth(final String userId) {
    final String _sql = "SELECT COALESCE(SUM(emiAmountPaise), 0) FROM loans WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"loans"}, new Callable<Long>() {
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
