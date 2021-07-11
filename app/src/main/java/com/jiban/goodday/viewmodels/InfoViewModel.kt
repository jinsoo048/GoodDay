package com.jiban.goodday.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jiban.goodday.data.Info
import com.jiban.goodday.data.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject internal constructor(
    private val repository: InfoRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val infos: LiveData<List<Info>> = repository.getInfos().asLiveData()

    fun getSearchMonth(myMonth: String): LiveData<List<Info>> = repository.getSearchMonth(myMonth)

    fun getSearchMonthOutdoorAndKorea(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthOutdoorAndKorea(myMonth)

    fun getSearchMonthOutdoorAndSeoul(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthOutdoorAndSeoul(myMonth)

    fun getSearchMonthOutdoorAndjejue(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthOutdoorAndjejue(myMonth)

    fun getSearchMonthOutdoorAndGangwon(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthOutdoorAndGangwon(myMonth)

    fun getSearchMonthMoveAndKorea(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthMoveAndKorea(myMonth)

    fun getSearchMonthMoveAndSeoul(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthMoveAndSeoul(myMonth)

    fun getSearchMonthMoveAndJejue(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthMoveAndJejue(myMonth)

    fun getSearchMonthMoveAndGangwon(myMonth: String): LiveData<List<Info>> =
        repository.getSearchMonthMoveAndGangwon(myMonth)

}



