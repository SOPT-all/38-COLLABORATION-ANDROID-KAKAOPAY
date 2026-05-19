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
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment.SegmentDropdownControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment.SegmentItem
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSegment

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
                start = 10.dp,
                end = 16.dp
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
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_all),
                    isSelected = selectedSegment == SpendingSegment.ALL,
                    onClick = { selectedSegment = SpendingSegment.ALL }
                )
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_card),
                    isSelected = selectedSegment == SpendingSegment.CARD,
                    onClick = { selectedSegment = SpendingSegment.CARD }
                )
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_account),
                    isSelected = selectedSegment == SpendingSegment.ACCOUNT,
                    onClick = { selectedSegment = SpendingSegment.ACCOUNT }
                )
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_pay),
                    isSelected = selectedSegment == SpendingSegment.PAY,
                    onClick = { selectedSegment = SpendingSegment.PAY }
                )
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
            ) {
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_point),
                    isSelected = selectedSegment == SpendingSegment.POINT,
                    onClick = { selectedSegment = SpendingSegment.POINT }
                )
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_pay_money),
                    isSelected = selectedSegment == SpendingSegment.PAY_MONEY,
                    onClick = { selectedSegment = SpendingSegment.PAY_MONEY }
                )
                SegmentItem(
                    text = stringResource(R.string.spending_overview_segment_pay_point),
                    isSelected = selectedSegment == SpendingSegment.PAY_POINT,
                    onClick = { selectedSegment = SpendingSegment.PAY_POINT }
                )
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