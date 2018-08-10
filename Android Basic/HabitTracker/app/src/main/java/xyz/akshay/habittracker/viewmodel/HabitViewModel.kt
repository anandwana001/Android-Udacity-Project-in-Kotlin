package xyz.akshay.habittracker.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import xyz.akshay.habittracker.HabitRepository
import xyz.akshay.habittracker.db.entity.Habits

/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 11:43 AM.
 */
class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val habitRepository: HabitRepository
    internal val allWords: LiveData<List<Habits>>

    init {
        habitRepository = HabitRepository(application)
        allWords = habitRepository.getAllWords()
    }

    fun insert(habits: Habits) {
        habitRepository.insert(habits)
    }
}
