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
public final class ChitFundDao_Impl implements ChitFundDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChitFund> __insertionAdapterOfChitFund;

  private final EntityDeletionOrUpdateAdapter<ChitFund> __updateAdapterOfChitFund;

  public ChitFundDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChitFund = new EntityInsertionAdapter<ChitFund>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `chit_funds` (`id`,`userId`,`organizerName`,`totalAmountPaise`,`monthlyInstalmentPaise`,`durationMonths`,`startDateMillis`,`prizeReceivedPaise`,`isActive`,`notes`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChitFund value) {
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
        if (value.getOrganizerName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOrganizerName());
        }
        stmt.bindLong(4, value.getTotalAmountPaise());
        stmt.bindLong(5, value.getMonthlyInstalmentPaise());
        stmt.bindLong(6, value.getDurationMonths());
        stmt.bindLong(7, value.getStartDateMillis());
        stmt.bindLong(8, value.getPrizeReceivedPaise());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        if (value.getNotes() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getNotes());
        }
      }
    };
    this.__updateAdapterOfChitFund = new EntityDeletionOrUpdateAdapter<ChitFund>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `chit_funds` SET `id` = ?,`userId` = ?,`organizerName` = ?,`totalAmountPaise` = ?,`monthlyInstalmentPaise` = ?,`durationMonths` = ?,`startDateMillis` = ?,`prizeReceivedPaise` = ?,`isActive` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChitFund value) {
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
        if (value.getOrganizerName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOrganizerName());
        }
        stmt.bindLong(4, value.getTotalAmountPaise());
        stmt.bindLong(5, value.getMonthlyInstalmentPaise());
        stmt.bindLong(6, value.getDurationMonths());
        stmt.bindLong(7, value.getStartDateMillis());
        stmt.bindLong(8, value.getPrizeReceivedPaise());
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        if (value.getNotes() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getNotes());
        }
        if (value.getId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final ChitFund chitFund, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChitFund.insert(chitFund);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final ChitFund chitFund, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfChitFund.handle(chitFund);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<ChitFund>> getActiveChits(final String userId) {
    final String _sql = "SELECT * FROM chit_funds WHERE userId = ? AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"chit_funds"}, new Callable<List<ChitFund>>() {
      @Override
      public List<ChitFund> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfOrganizerName = CursorUtil.getColumnIndexOrThrow(_cursor, "organizerName");
          final int _cursorIndexOfTotalAmountPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmountPaise");
          final int _cursorIndexOfMonthlyInstalmentPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "monthlyInstalmentPaise");
          final int _cursorIndexOfDurationMonths = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMonths");
          final int _cursorIndexOfStartDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "startDateMillis");
          final int _cursorIndexOfPrizeReceivedPaise = CursorUtil.getColumnIndexOrThrow(_cursor, "prizeReceivedPaise");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<ChitFund> _result = new ArrayList<ChitFund>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChitFund _item;
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
            final String _tmpOrganizerName;
            if (_cursor.isNull(_cursorIndexOfOrganizerName)) {
              _tmpOrganizerName = null;
            } else {
              _tmpOrganizerName = _cursor.getString(_cursorIndexOfOrganizerName);
            }
            final long _tmpTotalAmountPaise;
            _tmpTotalAmountPaise = _cursor.getLong(_cursorIndexOfTotalAmountPaise);
            final long _tmpMonthlyInstalmentPaise;
            _tmpMonthlyInstalmentPaise = _cursor.getLong(_cursorIndexOfMonthlyInstalmentPaise);
            final int _tmpDurationMonths;
            _tmpDurationMonths = _cursor.getInt(_cursorIndexOfDurationMonths);
            final long _tmpStartDateMillis;
            _tmpStartDateMillis = _cursor.getLong(_cursorIndexOfStartDateMillis);
            final long _tmpPrizeReceivedPaise;
            _tmpPrizeReceivedPaise = _cursor.getLong(_cursorIndexOfPrizeReceivedPaise);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new ChitFund(_tmpId,_tmpUserId,_tmpOrganizerName,_tmpTotalAmountPaise,_tmpMonthlyInstalmentPaise,_tmpDurationMonths,_tmpStartDateMillis,_tmpPrizeReceivedPaise,_tmpIsActive,_tmpNotes);
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
