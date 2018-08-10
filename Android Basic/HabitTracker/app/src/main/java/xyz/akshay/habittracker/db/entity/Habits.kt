package xyz.akshay.habittracker.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 10:44 AM.
 */
@Entity(tableName = "habitClass")
data class Habits(@PrimaryKey
                  @ColumnInfo(name = "habit") val habit: String)
