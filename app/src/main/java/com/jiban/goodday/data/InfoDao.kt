package com.jiban.goodday.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface InfoDao {

    //private var sonhn: String = "yes"

    @Query("SELECT * FROM info_table ORDER BY month ASC,day ASC")
    fun getInfos(): Flow<List<Info>>

    @Query("Select * FROM info_table WHERE month = :myMonth AND day = :myday")
    fun getMyday(myMonth: Int, myday: Int): Flow<Info>

    @Query("Select * FROM info_table WHERE month = :myMonth")
    fun getSearchMonth(myMonth: Int): Flow<List<Info>>

    //Outdoor
    @Query("SELECT * FROM info_table WHERE month = :myMonth AND korea < 5")
    fun getSearchMonthOutdoorAndKorea(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND seoul < 5")
    fun getSearchMonthOutdoorAndSeoul(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND jejue < 5")
    fun getSearchMonthOutdoorAndjejue(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND gangwon < 5")
    fun getSearchMonthOutdoorAndGangwon(myMonth: Int): Flow<List<Info>>

    //Move
    @Query("SELECT * FROM info_table WHERE month = :myMonth AND korea < 5 AND theDayWithoutSohn LIKE '%yes%'")
    fun getSearchMonthMoveAndKorea(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND seoul < 5 AND theDayWithoutSohn LIKE '%yes%'")
    fun getSearchMonthMoveAndSeoul(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND jejue < 5 AND theDayWithoutSohn LIKE '%yes%'")
    fun getSearchMonthMoveAndJejue(myMonth: Int): Flow<List<Info>>

    @Query("SELECT * FROM info_table WHERE month = :myMonth AND gangwon < 5 AND theDayWithoutSohn LIKE '%yes%'")
    fun getSearchMonthMoveAndGangwon(myMonth: Int): Flow<List<Info>>

    @Query("Select * FROM info_table ORDER BY korea ASC")
    fun getKorea(): Flow<List<Info>>

    @Query("Select * FROM info_table ORDER BY seoul ASC")
    fun getSeoul(): Flow<List<Info>>

    @Query("Select * FROM info_table ORDER BY jejue ASC")
    fun getJejue(): Flow<List<Info>>

    @Query("Select * FROM info_table ORDER BY gangwon ASC")
    fun getGangwon(): Flow<List<Info>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(info: List<Info>)

    @Delete
    fun delete(info: Info)
}