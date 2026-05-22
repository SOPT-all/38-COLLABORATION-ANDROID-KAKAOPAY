package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment.SegmentDropdownControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment.SegmentItem
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSegment

private val primarySegments = listOf(
    SpendingSegment.ALL,
    SpendingSegment.CARD,
    SpendingSegment.ACCOUNT,
    SpendingSegment.PAY
)

private val secondarySegments = listOf(
    SpendingSegment.POINT,
    SpendingSegment.PAY_MONEY,
    SpendingSegment.PAY_POINT
)

@Composable
fun SegmentControlBar(
    modifier: Modifier = Modifier,
) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedSegment by remember { mutableStateOf(SpendingSegment.ALL) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 10.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                primarySegments.forEach { segment ->
                    SegmentItem(
                        text = stringResource(segment.label),
                        isSelected = selectedSegment == segment,
                        onClick = { selectedSegment = segment }
                    )
                }
            }

            SegmentDropdownControl(
                onClick = { isExpanded = !isExpanded },
                isExpanded = isExpanded
            )

        }

        AnimatedVisibility(
            visible = isExpanded,
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                secondarySegments.forEach { segment ->
                    SegmentItem(
                        text = stringResource(segment.label),
                        isSelected = selectedSegment == segment,
                        onClick = { selectedSegment = segment }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun SegmentControlBarPreview() {
    KakaoPayTheme {
        SegmentControlBar()
    }
}