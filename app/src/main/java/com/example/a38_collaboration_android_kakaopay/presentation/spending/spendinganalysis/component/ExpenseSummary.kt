package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun ExpenseSummary(
    currentMonthTotal: Long,
    previousMonthTotal: Long,
    modifier: Modifier = Modifier,
) {
    val isMoreSpent = calculateDiff(current = currentMonthTotal, previous = previousMonthTotal)

    val totalDiffAmount = kotlin.math.abs(currentMonthTotal - previousMonthTotal).toWonFormat()

    val totalDiffTextMessage =
        if (isMoreSpent) {
            "지난달 같은 기간보다 +${totalDiffAmount} 더 쓰고 있어요"
        } else {
            "지난달 같은 기간보다 ${totalDiffAmount} 덜 쓰고 있어요"
        }

    val totalDiffTextColor =
        if (isMoreSpent) {
            KakaoTheme.colors.highlightPrimaryRed
        } else {
            KakaoTheme.colors.highlightPrimaryBlue
        }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = currentMonthTotal.toWonFormat(),
                style = KakaoTheme.typography.titleB24,
                color = KakaoTheme.colors.black
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_chevron_down_grey600_24px),
                contentDescription = null
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = totalDiffTextMessage,
            style = KakaoTheme.typography.bodyR14,
            color = totalDiffTextColor
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun ExpenseSummaryPreview() {
    KakaoPayTheme {
        ExpenseSummary(
            currentMonthTotal = 184270,
            previousMonthTotal = 154270,
        )
    }
}
