package com.alireza.eliqtask.presentation.forecast.dailyWeather

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.alireza.eliqtask.domian.model.weather.Daily
import com.alireza.eliqtask.domian.model.weather.DailyData
import com.alireza.eliqtask.presentation.forecast.dailyWeather.sampleData.DailyWeatherProvider
import com.alireza.eliqtask.presentation.ui.theme.EliqTaskTheme

@Composable
fun DailyWeather(modifier: Modifier = Modifier, daily: Daily) {

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
                return Offset.Zero
            }
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .nestedScroll(nestedScrollConnection)
            .padding(top = 4.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        items(daily.data) { item -> DailyWeatherItem(data = item) }
    }
}


@Composable
fun DailyWeatherItem(modifier: Modifier = Modifier, data: DailyData) {

    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            modifier = modifier
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)
                .weight(1f),
            text = data.time,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = modifier
                .padding(vertical = 8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = data.weatherCode.iconDay),
                contentDescription = "",
                modifier = modifier
                    .size(32.dp)
            )

            Text(
                modifier = modifier
                    .padding(vertical = 8.dp),
                text = stringResource(id = data.weatherCode.title),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
            )
        }

        Text(
            modifier = modifier
                .padding(end = 16.dp)
                .weight(1f),
            text = data.windSpeed10mMax,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.titleSmall
        )

    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DailyWeatherItemPreview(@PreviewParameter(DailyWeatherProvider::class) dailyData: Daily) {
    EliqTaskTheme {
        DailyWeatherItem(data = dailyData.data[0])
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DailyWeatherPreview(@PreviewParameter(DailyWeatherProvider::class) data: Daily) {
    EliqTaskTheme {
        DailyWeather(daily = data)
    }
}