package com.jiban.goodday

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InfosApplication : Application()
//{
// val applicationScope = CoroutineScope(SupervisorJob())

//private val database by lazy { AppDatabase.getInstance(this) }
//val repository by lazy { InfoRepository(database.infoDao()) }
//}