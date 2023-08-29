package com.alireza.eliqtask.data.local.file.uiPatternStore

import android.app.Application
import android.content.Context
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject

class UiPatterDataStore @Inject constructor(private val context: Context, private val moshi:Moshi) {
    suspend fun getUiPattern(fileName:String):UiPattern?{
        val assetManager = context.assets
        val jsonAdapter: JsonAdapter<UiPattern> = moshi.adapter(UiPattern::class.java)

        return try {
            val inputStream = assetManager.open(fileName)
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val json = bufferedReader.use { it.readText() }
            bufferedReader.close()

            jsonAdapter.fromJson(json)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
