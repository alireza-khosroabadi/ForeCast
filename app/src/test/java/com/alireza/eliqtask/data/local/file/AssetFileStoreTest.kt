package com.alireza.eliqtask.data.local.file

import android.app.Application
import android.content.res.AssetManager
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.io.ByteArrayInputStream
import java.io.InputStream

//@RunWith(AndroidJUnit4::class)
class AssetFileStoreTest{
    private lateinit var assetReader: AssetFileStore
    private lateinit var mockContext: Application
    private lateinit var mockAssetManager: AssetManager
    private lateinit var moshi: Moshi

    @Before
    fun setUp() {
        mockContext = mock()
        mockAssetManager = mock()
        moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        whenever(mockContext.assets).thenReturn(mockAssetManager)
        assetReader = AssetFileStore(mockContext, moshi)
    }


    @Test
    fun `test reading text file from assets`() = runBlocking {
        val fileName = "test.json"
        val fileContents = "{\n" +
                "  \"uiPattern\": [\n" +
                "    {\n" +
                "      \"type\": \"Title\",\n" +
                "      \"isVisible\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Hourly\",\n" +
                "      \"isVisible\": true\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Daily\",\n" +
                "      \"isVisible\": true\n" +
                "    }\n" +
                "  ]\n" +
                "}"

        val inputStream = ByteArrayInputStream(fileContents.toByteArray())
        whenever(mockAssetManager.open(any())).thenReturn(inputStream)

        val result = assetReader.getUiPattern(fileName)

        assertEquals(3, result?.uiPattern?.size)
    }


}