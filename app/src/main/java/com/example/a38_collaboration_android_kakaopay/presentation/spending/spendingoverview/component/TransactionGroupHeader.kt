package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.DailyTransactions

@Composable
fun TransactionGroupHeader(
    dailyTransactions: DailyTransactions,
    modifier: Modifier = Modifier
) {
    val day = dailyTransactions.date.split("-").lastOrNull() ?: ""
    val cleanDay = day.toIntOrNull()?.toString() ?: day

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = "${cleanDay}일 ${dailyTransactions.dayOfWeek}요일",
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyB14,
        )
        Text(
            text = dailyTransactions.dailyTotal.toString().toWonFormat(),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyB14,
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun TransactionGroupHeaderPreview() {
    KakaoPayTheme {
        TransactionGroupHeader(
            dailyTransactions = DailyTransactions(
                date = "2026-04-27",
                dayOfWeek = "월",
                dailyTotal = -11800,
                transactions = emptyList()
            )
        )
    }
}