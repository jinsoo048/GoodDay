package com.jiban.goodday.di

import android.content.Context
import com.jiban.goodday.data.AppDatabase
import com.jiban.goodday.data.InfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun privideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideInfoDao(appDatabase: AppDatabase): InfoDao {
        return appDatabase.infoDao()
    }

}