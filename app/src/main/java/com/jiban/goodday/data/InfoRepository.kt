package com.jiban.goodday.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InfoRepository @Inject constructor(private val infoDao: InfoDao) {

    //val infos: LiveData<List<Info>> = infoDao.getAll()

    fun getInfos() = infoDao.getInfos()

    fun getMyday(myMonth: Int, myDay: Int) = infoDao.getMyday(myMonth, myDay)

    fun getSearchMonth(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonth(myMonth).asLiveData()

    fun getSearchMonthOutdoorAndKorea(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthOutdoorAndKorea(myMonth).asLiveData()

    fun getSearchMonthOutdoorAndSeoul(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthOutdoorAndSeoul(myMonth).asLiveData()

    fun getSearchMonthOutdoorAndjejue(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthOutdoorAndjejue(myMonth).asLiveData()

    fun getSearchMonthOutdoorAndGangwon(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthOutdoorAndGangwon(myMonth).asLiveData()

    fun getSearchMonthMoveAndKorea(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthMoveAndKorea(myMonth).asLiveData()

    fun getSearchMonthMoveAndSeoul(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthMoveAndSeoul(myMonth).asLiveData()

    fun getSearchMonthMoveAndJejue(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthMoveAndJejue(myMonth).asLiveData()

    fun getSearchMonthMoveAndGangwon(myMonth: Int): LiveData<List<Info>> =
        infoDao.getSearchMonthMoveAndGangwon(myMonth).asLiveData()


}
