package com.example.fitbit2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {
    @Query("SELECT * FROM sleep_table")
    fun getAll(): Flow<List<SleepEntry>>

    @Insert
    suspend fun insert(sleepEntry: SleepEntry)

    @Query("DELETE FROM sleep_table")
    suspend fun deleteAll()
}
