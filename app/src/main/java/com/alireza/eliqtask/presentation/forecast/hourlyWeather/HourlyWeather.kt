package com.alireza.eliqtask.presentation.forecast.hourlyWeather

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.alireza.eliqtask.domian.model.weather.Hourly
import com.alireza.eliqtask.domian.model.weather.HourlyData
import com.alireza.eliqtask.presentation.forecast.hourlyWeather.sampleData.HourlyWeatherProvider
import com.alireza.eliqtask.presentation.ui.theme.EliqTaskTheme
import kotlinx.coroutines.launch

@Composable
fun HourlyWeather(modifier: Modifier = Modifier, hourly: Hourly) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val nowIndex by remember { mutableIntStateOf(hourly.data.indexOfFirst { it.time =="Now" }) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Text(
            modifier = modifier
                .padding(top = 8.dp, start = 16.dp),
            text = hourly.timeUnit,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow(
            state= listState,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .background(color = MaterialTheme.colorScheme.surface),
        ) {
            itemsIndexed(hourly.data) { index , item->
                HourlyWeatherItem(data = item)
            }
        }
        LaunchedEffect(listState){
            coroutineScope.launch {
                listState.scrollToItem(nowIndex)
            }
        }
    }
}


@Composable
fun HourlyWeatherItem(modifier: Modifier = Modifier, data: HourlyData) {

    Column(
        modifier = modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = modifier
                .padding(top = 8.dp),
            text = data.time,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )

        Icon(
            painter = painterResource(id = data.weatherCode.getPrepareIcon(data.isDay)),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = modifier
                .size(32.dp)
                .padding(top = 8.dp)
        )

        Text(
            modifier = modifier
                .padding(top = 8.dp),
            text = data.temperature2m,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            modifier = modifier
                .padding(top = 4.dp, bottom = 8.dp),
            text = data.precipitationProbability,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )

    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HourlyWeatherItemPreview(@PreviewParameter(HourlyWeatherProvider::class) hourlyData: Hourly) {
    EliqTaskTheme {
        HourlyWeatherItem(data = hourlyData.data[0])
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HourlyWeatherPreview(@PreviewParameter(HourlyWeatherProvider::class) hourlyData: Hourly) {
    EliqTaskTheme {
        HourlyWeather(hourly = hourlyData)
    }
}