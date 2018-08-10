package xyz.akshay.habittracker

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import xyz.akshay.habittracker.db.HabitRoomDatabase
import xyz.akshay.habittracker.db.dao.HabitDao
import xyz.akshay.habittracker.db.entity.Habits


/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 11:29 AM.
 */
class HabitRepository(application: Application) {

    private val habitDao: HabitDao
    private val listLiveData: LiveData<List<Habits>>

    init {
        val habitRoomDatabase = HabitRoomDatabase.getDatabase(application)
        habitDao = habitRoomDatabase?.wordDao()!!
        listLiveData = habitDao?.getAllHabits()
    }

    fun getAllWords(): LiveData<List<Habits>> {
        return listLiveData
    }

    fun insert(word: Habits) {
        insertAsyncTask(habitDao).execute(word)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: HabitDao) : AsyncTask<Habits, Void, Void>() {

        override fun doInBackground(vararg params: Habits): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}
