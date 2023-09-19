package com.inspiration.feature.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.base.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CollapsedRowSample() {
    CollapsedRowSampleContent(range = 0..4)
}

@Composable
fun CollapsedRowSampleContent(range: IntRange) {
    CollapsedRow(
        modifier = Modifier.padding(16.dp),
        footer = {
            Box(
                modifier = Modifier
                    .background(Color.Cyan)
                    .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material.Text(
                    text = "end"
                )
            }
        }
    ) {
        range.InImage {
            AsyncImage(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(64.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.ic_100tb)
                    .placeholder(android.R.drawable.screen_background_dark)
                    .build(),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun CollapsedRow(
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val measurePolicy = collapsedRowMeasurePolicy()
    Layout(
        content = {
            content.invoke()
            footer.invoke()
        },
        modifier = modifier,
        measurePolicy = measurePolicy
    )
}

fun collapsedRowMeasurePolicy() = MeasurePolicy { measurables, constraints ->
    val placeables = measurables.map { it.measure(constraints) }
    val height = placeables.maxOf { it.height }
    val width = constraints.maxWidth
    layout(width, height) {
        var xPos = 0

        val footerPlaceable = placeables.last()
        val contentPlaceables = placeables.dropLast(1)

        contentPlaceables.forEachIndexed { index, item ->
            if (index == (contentPlaceables.lastIndex) ||
                xPos + item.width + contentPlaceables[index + 1].width < width
            ) {
                item.placeRelative(xPos, 0, 0f)
                xPos += item.width
            } else {
                footerPlaceable.placeRelative(xPos, 0, 0f)
                return@layout
            }
        }
    }
}

@Composable
fun IntRange.InImage(content: @Composable () -> Unit) {
    forEach { item ->
        content.invoke()
    }
}

@Preview(showBackground = true)
@Composable
fun CollapseRowPreview() {
    Column(modifier = Modifier.width(350.dp)) {
        CollapsedRowSampleContent(0..1)
        CollapsedRowSampleContent(0..2)
        CollapsedRowSampleContent(0..3)
        CollapsedRowSampleContent(0..4)
        CollapsedRowSampleContent(0..5)
    }
}