package com.alireza.eliqtask.presentation.forecast.currentWeather

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alireza.eliqtask.R
import com.alireza.eliqtask.domian.model.weather.CurrentWeather
import com.alireza.eliqtask.presentation.forecast.currentWeather.sampleData.CurrentWeatherProvider
import com.alireza.eliqtask.presentation.ui.theme.EliqTaskTheme


@Composable
fun CurrentWeather(modifier: Modifier = Modifier, currentWeather: CurrentWeather) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surfaceVariant,  MaterialTheme.colorScheme.surface
                    )
                )
            )
    ) {
        Column(
            modifier
        ) {
            Text(
                modifier = modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = currentWeather.location ?: "",
                style = MaterialTheme.typography.titleLarge
            )
            CurrentWeatherCenterView(
                modifier = modifier,
                weatherIcon = currentWeather.weatherCode?.getPrepareIcon(
                    currentWeather.isDay
                ) ?: R.drawable.fluent_weather_sunny_24_regular,
                date = currentWeather.time.toString(),
                temperature = currentWeather.temperature.toString(),
                weather = currentWeather.weatherCode?.title ?: R.string.Clear
            )

            Divider(
                modifier = modifier.padding(horizontal = 32.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                thickness = 1.dp
            )

            CurrentWeatherBottomView(
                modifier = modifier,
                windSpeed = currentWeather.windSpeed.toString(),
                windDirection = currentWeather.windDirection.toString()
            )
        }

    }
}


@Composable
fun CurrentWeatherCenterView(
    modifier: Modifier = Modifier,
    @DrawableRes weatherIcon: Int,
    date: String,
    temperature: String,
    @StringRes weather: Int
) {
    Row(modifier = modifier) {
        Image(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(horizontal = 16.dp),
            painter = painterResource(id = weatherIcon),
            contentDescription = ""
        )
        Column(modifier = modifier.weight(1f)) {

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = date,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = temperature,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = TextUnit(0f, TextUnitType(0)),
                )
            )

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = stringResource(id = weather),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun CurrentWeatherBottomView(
    modifier: Modifier = Modifier,
    windSpeed: String,
    windDirection: String
) {
    Row(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier
                    .size(32.dp)
                    .padding(end = 8.dp),
                painter = painterResource(id = R.drawable.fluent_weather_squalls_24_regular),
                contentDescription = ""
            )
            Column {
                Text(text = windSpeed)
                Text(text = stringResource(id = R.string.wind))
            }
        }
        Row(
            modifier = modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier
                    .size(32.dp)
                    .padding(end = 8.dp),
                painter = painterResource(id = R.drawable.fluent_temperature_24_regular),
                contentDescription = ""
            )
            Column {
                Text(text = windDirection)
                Text(text = stringResource(id = R.string.pressure))
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewCurrentWeather(@PreviewParameter(CurrentWeatherProvider::class) weather: CurrentWeather) {
    EliqTaskTheme {
        CurrentWeather(currentWeather = weather)
    }
}