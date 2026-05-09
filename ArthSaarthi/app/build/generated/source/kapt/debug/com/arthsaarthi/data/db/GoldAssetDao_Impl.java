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
public final class GoldAssetDao_Impl implements GoldAssetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GoldAsset> __insertionAdapterOfGoldAsset;

  private final EntityDeletionOrUpdateAdapter<GoldAsset> __deletionAdapterOfGoldAsset;

  private final EntityDeletionOrUpdateAdapter<GoldAsset> __updateAdapterOfGoldAsset;

  public GoldAssetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGoldAsset = new EntityInsertionAdapter<GoldAsset>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `gold_assets` (`id`,`userId`,`weightGrams`,`purity`,`purchasePricePerGramPaise`,`purchaseDateMillis`,`storageType`,`notes`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GoldAsset value) {
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
        stmt.bindDouble(3, value.getWeightGrams());
        if (value.getPurity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurity());
        }
        stmt.bindLong(5, value.getPurchasePricePerGramPaise());
        stmt.bindLong(6, value.getPurchaseDateMillis());
        if (value.getStorageType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStorageType());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
      }
    };
    this.__deletionAdapterOfGoldAsset = new EntityDeletionOrUpdateAdapter<GoldAsset>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `gold_assets` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GoldAsset value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfGoldAsset = new EntityDeletionOrUpdateAdapter<GoldAsset>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `gold_assets` SET `id` = ?,`userId` = ?,`weightGrams` = ?,`purity` = ?,`purchasePricePerGramPaise` = ?,`purchaseDateMillis` = ?,`storageType` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GoldAsset value) {
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
        stmt.bindDouble(3, value.getWeightGrams());
        if (value.getPurity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurity());
        }
        stmt.bindLong(5, value.getPurchasePricePerGramPaise());
        stmt.bindLong(6, value.getPurchaseDateMillis());
        if (value.getStorageType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStorageType());
        }
        if (value.getNotes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNotes());
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final GoldAsset goldAsset, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGoldAsset.insert(goldAsset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final GoldAsset goldAsset, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGoldAsset.handle(goldAsset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final GoldAsset goldAsset, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGoldAsset.handle(goldAsset);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<GoldAsset>> getAllGold(final String userId) {
    final String _sql = "SELECT * FROM gold_assets WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"gold_assets"}, new Callable<List<GoldAsset>>() {
      @Override
      public List<GoldAsset> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfWeightGrams = CursorUtil.getColumnIndexOrThrow(_cursor, "weightGrams");
          final int _cursorIndexOfPurity = CursorUtil.getColumnIndexOrThrow(_cursor, "purity");
          final int _cursorIndexOfPurchasePricePerGramPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePricePerGramPaise");
          final int _cursorIndexOfPurchaseDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseDateMillis");
          final int _cursorIndexOfStorageType = CursorUtil.getColumnIndexOrThrow(_cursor, "storageType");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<GoldAsset> _result = new ArrayList<GoldAsset>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GoldAsset _item;
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
            final double _tmpWeightGrams;
            _tmpWeightGrams = _cursor.getDouble(_cursorIndexOfWeightGrams);
            final String _tmpPurity;
            if (_cursor.isNull(_cursorIndexOfPurity)) {
              _tmpPurity = null;
            } else {
              _tmpPurity = _cursor.getString(_cursorIndexOfPurity);
            }
            final long _tmpPurchasePricePerGramPaise;
            _tmpPurchasePricePerGramPaise = _cursor.getLong(_cursorIndexOfPurchasePricePerGramPaise);
            final long _tmpPurchaseDateMillis;
            _tmpPurchaseDateMillis = _cursor.getLong(_cursorIndexOfPurchaseDateMillis);
            final String _tmpStorageType;
            if (_cursor.isNull(_cursorIndexOfStorageType)) {
              _tmpStorageType = null;
            } else {
              _tmpStorageType = _cursor.getString(_cursorIndexOfStorageType);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new GoldAsset(_tmpId,_tmpUserId,_tmpWeightGrams,_tmpPurity,_tmpPurchasePricePerGramPaise,_tmpPurchaseDateMillis,_tmpStorageType,_tmpNotes);
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
