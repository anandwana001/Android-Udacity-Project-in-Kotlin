package xyz.akshay.habittracker.db;

/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 12:46 PM.
 */

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import xyz.akshay.habittracker.db.dao.HabitDao;
import xyz.akshay.habittracker.db.entity.Habits;

@Database(entities = {Habits.class}, version = 1)
public abstract class HabitRoomDatabase extends RoomDatabase{

  public abstract HabitDao wordDao();

  private static HabitRoomDatabase INSTANCE;

  public static HabitRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (HabitRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              HabitRoomDatabase.class, "word_database")
              .addCallback(sRoomDatabaseCallback)
              .build();
        }
      }
    }
    return INSTANCE;
  }

  private static RoomDatabase.Callback sRoomDatabaseCallback =
      new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
          super.onOpen(db);
          new PopulateDbAsync(INSTANCE).execute();
        }
      };

  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final HabitDao mDao;

    PopulateDbAsync(HabitRoomDatabase db) {
      mDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
      mDao.deleteAll();
      Habits word = new Habits("Hello");
      mDao.insert(word);
      word = new Habits("World");
      mDao.insert(word);
      return null;
    }
  }
}
