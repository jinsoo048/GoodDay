package com.jiban.goodday.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info_table")
data class Info(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "month") val month: Int,
    @ColumnInfo(name = "day") val day: Int,
    @ColumnInfo(name = "dayOfTheWeek") val dayOfTheWeek: String,
    @ColumnInfo(name = "korea") val korea: Int,
    @ColumnInfo(name = "seoul") val seoul: Int,
    @ColumnInfo(name = "jejue") val jejue: Int,
    @ColumnInfo(name = "gangwon") val gangwon: Int,
    @ColumnInfo(name = "theDayWithoutSohn") val theDayWithoutSohn: String
) {
    constructor() : this(0, 0, 0, "", 0, 0, 0, 0, "")
}
