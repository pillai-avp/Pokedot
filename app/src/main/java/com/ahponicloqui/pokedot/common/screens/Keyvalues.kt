package com.ahponicloqui.pokedot.common.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KeyValues(
    modifier: Modifier,
    key: String,
    value: String? = null,
    values: List<String> = emptyList<String>()
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = key,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            if (value != null)
                Text(
                    modifier = Modifier.weight(1f),
                    text = value,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            else if (values.isNotEmpty()) {
                Column(modifier = Modifier.weight(1f)) {
                    values.forEach {
                        Text(text = it, fontWeight = FontWeight.Normal, fontSize = 14.sp)
                    }
                }
            }

        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
    }

}

@Preview
@Composable
fun KeyValuesPreview() {
    Column {
        KeyValues(modifier = Modifier.fillMaxWidth(), "National No", "0001")
        KeyValues(modifier = Modifier.fillMaxWidth(), "National No", "0001")
        KeyValues(modifier = Modifier.fillMaxWidth(), "National No", "0001")
        KeyValues(modifier = Modifier.fillMaxWidth(), "National No", "0001")
    }

}