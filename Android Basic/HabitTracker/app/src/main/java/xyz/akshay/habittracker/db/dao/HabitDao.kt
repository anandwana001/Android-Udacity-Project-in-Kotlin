package xyz.akshay.habittracker.db.dao;

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import xyz.akshay.habittracker.db.entity.Habits

/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 10:50 AM.
 */

@Dao
interface HabitDao {

    @Insert
    fun insert(habit: Habits)

    @Query("DELETE FROM habitClass")
    fun deleteAll()

    @Query("SELECT * FROM habitClass ORDER BY habit ASC" )
    fun getAllHabits() : LiveData<List<Habits>>
}
