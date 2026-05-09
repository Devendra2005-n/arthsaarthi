package com.arthsaarthi.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class TransactionDao_Impl implements TransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Transaction> __insertionAdapterOfTransaction;

  private final EntityDeletionOrUpdateAdapter<Transaction> __updateAdapterOfTransaction;

  private final SharedSQLiteStatement __preparedStmtOfSoftDelete;

  public TransactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaction = new EntityInsertionAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `transactions` (`id`,`userId`,`amountPaise`,`type`,`category`,`paymentMode`,`merchantName`,`note`,`dateMillis`,`source`,`isVerified`,`isDeleted`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
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
        stmt.bindLong(3, value.getAmountPaise());
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCategory());
        }
        if (value.getPaymentMode() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPaymentMode());
        }
        if (value.getMerchantName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMerchantName());
        }
        if (value.getNote() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNote());
        }
        stmt.bindLong(9, value.getDateMillis());
        if (value.getSource() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSource());
        }
        final int _tmp = value.isVerified() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(12, _tmp_1);
        stmt.bindLong(13, value.getCreatedAt());
      }
    };
    this.__updateAdapterOfTransaction = new EntityDeletionOrUpdateAdapter<Transaction>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `transactions` SET `id` = ?,`userId` = ?,`amountPaise` = ?,`type` = ?,`category` = ?,`paymentMode` = ?,`merchantName` = ?,`note` = ?,`dateMillis` = ?,`source` = ?,`isVerified` = ?,`isDeleted` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Transaction value) {
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
        stmt.bindLong(3, value.getAmountPaise());
        if (value.getType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCategory());
        }
        if (value.getPaymentMode() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPaymentMode());
        }
        if (value.getMerchantName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMerchantName());
        }
        if (value.getNote() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNote());
        }
        stmt.bindLong(9, value.getDateMillis());
        if (value.getSource() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSource());
        }
        final int _tmp = value.isVerified() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        final int _tmp_1 = value.isDeleted() ? 1 : 0;
        stmt.bindLong(12, _tmp_1);
        stmt.bindLong(13, value.getCreatedAt());
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getId());
        }
      }
    };
    this.__preparedStmtOfSoftDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE transactions SET isDeleted = 1 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Transaction transaction,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTransaction.insert(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Transaction transaction,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTransaction.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object softDelete(final String id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSoftDelete.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfSoftDelete.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Transaction>> getAllTransactions(final String userId) {
    final String _sql = "SELECT * FROM transactions WHERE userId = ? AND isDeleted = 0 ORDER BY dateMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<List<Transaction>>() {
      @Override
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "amountPaise");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPaymentMode = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMode");
          final int _cursorIndexOfMerchantName = CursorUtil.getColumnIndexOrThrow(_cursor, "merchantName");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isVerified");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Transaction _item;
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
            final long _tmpAmountPaise;
            _tmpAmountPaise = _cursor.getLong(_cursorIndexOfAmountPaise);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpPaymentMode;
            if (_cursor.isNull(_cursorIndexOfPaymentMode)) {
              _tmpPaymentMode = null;
            } else {
              _tmpPaymentMode = _cursor.getString(_cursorIndexOfPaymentMode);
            }
            final String _tmpMerchantName;
            if (_cursor.isNull(_cursorIndexOfMerchantName)) {
              _tmpMerchantName = null;
            } else {
              _tmpMerchantName = _cursor.getString(_cursorIndexOfMerchantName);
            }
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final boolean _tmpIsVerified;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsVerified);
            _tmpIsVerified = _tmp != 0;
            final boolean _tmpIsDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Transaction(_tmpId,_tmpUserId,_tmpAmountPaise,_tmpType,_tmpCategory,_tmpPaymentMode,_tmpMerchantName,_tmpNote,_tmpDateMillis,_tmpSource,_tmpIsVerified,_tmpIsDeleted,_tmpCreatedAt);
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
  public Flow<List<Transaction>> getRecentTransactions(final String userId, final int limit) {
    final String _sql = "SELECT * FROM transactions WHERE userId = ? AND isDeleted = 0 ORDER BY dateMillis DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<List<Transaction>>() {
      @Override
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "amountPaise");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPaymentMode = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMode");
          final int _cursorIndexOfMerchantName = CursorUtil.getColumnIndexOrThrow(_cursor, "merchantName");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isVerified");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Transaction _item;
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
            final long _tmpAmountPaise;
            _tmpAmountPaise = _cursor.getLong(_cursorIndexOfAmountPaise);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpPaymentMode;
            if (_cursor.isNull(_cursorIndexOfPaymentMode)) {
              _tmpPaymentMode = null;
            } else {
              _tmpPaymentMode = _cursor.getString(_cursorIndexOfPaymentMode);
            }
            final String _tmpMerchantName;
            if (_cursor.isNull(_cursorIndexOfMerchantName)) {
              _tmpMerchantName = null;
            } else {
              _tmpMerchantName = _cursor.getString(_cursorIndexOfMerchantName);
            }
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final boolean _tmpIsVerified;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsVerified);
            _tmpIsVerified = _tmp != 0;
            final boolean _tmpIsDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Transaction(_tmpId,_tmpUserId,_tmpAmountPaise,_tmpType,_tmpCategory,_tmpPaymentMode,_tmpMerchantName,_tmpNote,_tmpDateMillis,_tmpSource,_tmpIsVerified,_tmpIsDeleted,_tmpCreatedAt);
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
  public Flow<List<Transaction>> getThisMonthExpenses(final String userId,
      final long startOfMonth) {
    final String _sql = "SELECT * FROM transactions WHERE userId = ? AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= ? ORDER BY dateMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startOfMonth);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<List<Transaction>>() {
      @Override
      public List<Transaction> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "amountPaise");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPaymentMode = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMode");
          final int _cursorIndexOfMerchantName = CursorUtil.getColumnIndexOrThrow(_cursor, "merchantName");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfIsVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "isVerified");
          final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isDeleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Transaction> _result = new ArrayList<Transaction>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Transaction _item;
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
            final long _tmpAmountPaise;
            _tmpAmountPaise = _cursor.getLong(_cursorIndexOfAmountPaise);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpPaymentMode;
            if (_cursor.isNull(_cursorIndexOfPaymentMode)) {
              _tmpPaymentMode = null;
            } else {
              _tmpPaymentMode = _cursor.getString(_cursorIndexOfPaymentMode);
            }
            final String _tmpMerchantName;
            if (_cursor.isNull(_cursorIndexOfMerchantName)) {
              _tmpMerchantName = null;
            } else {
              _tmpMerchantName = _cursor.getString(_cursorIndexOfMerchantName);
            }
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final boolean _tmpIsVerified;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsVerified);
            _tmpIsVerified = _tmp != 0;
            final boolean _tmpIsDeleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDeleted);
            _tmpIsDeleted = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Transaction(_tmpId,_tmpUserId,_tmpAmountPaise,_tmpType,_tmpCategory,_tmpPaymentMode,_tmpMerchantName,_tmpNote,_tmpDateMillis,_tmpSource,_tmpIsVerified,_tmpIsDeleted,_tmpCreatedAt);
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
  public Flow<Long> getThisMonthTotalSpend(final String userId, final long startOfMonth) {
    final String _sql = "SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = ? AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startOfMonth);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<Long>() {
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
  public Flow<Long> getThisMonthTotalIncome(final String userId, final long startOfMonth) {
    final String _sql = "SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = ? AND type = 'INCOME' AND isDeleted = 0 AND dateMillis >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startOfMonth);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<Long>() {
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
  public Flow<List<CategoryTotal>> getTopCategories(final String userId, final long startOfMonth) {
    final String _sql = "SELECT category, SUM(amountPaise) as total FROM transactions WHERE userId = ? AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= ? GROUP BY category ORDER BY total DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startOfMonth);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"transactions"}, new Callable<List<CategoryTotal>>() {
      @Override
      public List<CategoryTotal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCategory = 0;
          final int _cursorIndexOfTotal = 1;
          final List<CategoryTotal> _result = new ArrayList<CategoryTotal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CategoryTotal _item;
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final long _tmpTotal;
            _tmpTotal = _cursor.getLong(_cursorIndexOfTotal);
            _item = new CategoryTotal(_tmpCategory,_tmpTotal);
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
  public Object getCount(final String userId, final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COUNT(*) FROM transactions WHERE userId = ? AND isDeleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
