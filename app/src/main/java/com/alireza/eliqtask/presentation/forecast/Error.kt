package com.alireza.eliqtask.presentation.forecast

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alireza.eliqtask.R
import com.alireza.eliqtask.base.data.dataModel.ErrorModel

@Composable
fun ErrorView(modifier: Modifier = Modifier, error: ErrorModel, onClickAction: ()->Unit) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.cloud_error),
                contentDescription = "error image",
                tint = Color.Unspecified,
                modifier = modifier.size(150.dp),
            )

            Text(
                modifier = modifier
                    .padding(top = 8.dp),
                text = error.errorMessage,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )

            OutlinedButton(modifier = modifier.padding(16.dp), onClick = onClickAction) {
                Text(
                    modifier = modifier,
                    text = stringResource(id = R.string.retry),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorViewPreview() {
    ErrorView(error = ErrorModel(100, "No network"), onClickAction = {})
}