package com.oscar.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.domain.models.Stat

const val MAX_STAT = 255;
const val BAR_SIZE = 280;

/**
 * Composable that displays a bar representing a specific statistic of a Pokemon.
 *
 * @param stat The Stat enum representing the type of statistic.
 * @param value The value of the statistic to display.
 */
@Composable
fun StatBar(stat: Stat, value: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stat.text)
        Box(
            modifier = Modifier
                .width(BAR_SIZE.dp)
                .height(20.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(
                    Color.Gray
                ),
            contentAlignment = Alignment.TopStart
        ) {

            val innerBarSize = (BAR_SIZE * value)/ MAX_STAT;

            Box(modifier = Modifier
                .width(innerBarSize.dp)
                .height(20.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(
                    stat.color
                )
                .clip(
                    RoundedCornerShape(20.dp)
                ),
                contentAlignment = Alignment.Center){}

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "$value/$MAX_STAT")

            }
        }
    }
}