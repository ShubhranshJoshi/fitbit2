package com.example.fitbit2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_table")
data class SleepEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "hours") val hours: Int?,
    @ColumnInfo(name = "quality") val quality: String?,
    @ColumnInfo(name = "date") val date: String?
)
