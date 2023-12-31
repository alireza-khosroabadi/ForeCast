package com.alireza.eliqtask.data.local.file

import android.app.Application
import android.content.res.AssetManager
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.io.ByteArrayInputStream

class UiPatternDataStoreTest{
    private lateinit var uiPatternDataStore: UiPatterDataStore
    private lateinit var mockContext: Application
    private lateinit var mockAssetManager: AssetManager
    private lateinit var moshi: Moshi

    @Before
    fun setUp() {
        mockContext = mock()
        mockAssetManager = mock()
        moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        whenever(mockContext.assets).thenReturn(mockAssetManager)
        uiPatternDataStore = UiPatterDataStore(mockContext, moshi)
    }


    @Test
    fun `test reading text file from assets`() = runBlocking {
        val fileName = "test.json"
        val fileContents = "{\n" +
                "  \"pattern\": [\n" +
                "    {\n" +
                "      \"type\": \"CurrentWeather\",\n" +
                "      \"isVisible\": true,\n" +
                "      \"order\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Hourly\",\n" +
                "      \"isVisible\": true,\n" +
                "      \"order\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Daily\",\n" +
                "      \"isVisible\": true,\n" +
                "      \"order\": 3\n" +
                "    }\n" +
                "  ]\n" +
                "}"

        val inputStream = ByteArrayInputStream(fileContents.toByteArray())
        whenever(mockAssetManager.open(any())).thenReturn(inputStream)

        val result = uiPatternDataStore.getUiPattern(fileName)

        assertEquals(3, result?.pattern?.size)
    }


}