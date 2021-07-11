package com.jiban.goodday.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.jiban.goodday.data.AppDatabase
import com.jiban.goodday.data.Info
import com.jiban.goodday.utilities.INFO_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(INFO_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val infoType = object : TypeToken<List<Info>>() {}.type
                    val infoList: List<Info> =
                        Gson().fromJson(jsonReader, infoType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.infoDao().insertAll(infoList)
                    Result.success()
                }

            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "DeedDatabaseWorker"
    }


}
