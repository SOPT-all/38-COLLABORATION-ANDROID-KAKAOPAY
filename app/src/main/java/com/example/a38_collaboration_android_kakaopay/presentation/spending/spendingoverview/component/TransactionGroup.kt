package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.DailyTransactions
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.Transaction
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TransactionGroup(
    dailyTransactions: DailyTransactions,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TransactionGroupHeader(dailyTransactions)

        dailyTransactions.transactions.forEach {
            TransactionListItem(
                transaction = it
            )
        }
    }
}

@Composable
private fun TransactionGroupHeader(
    dailyTransactions: DailyTransactions,
    modifier: Modifier = Modifier
) {
    val day = dailyTransactions.date.split("-").lastOrNull() ?: ""
    val cleanDay = day.toIntOrNull()?.toString() ?: day

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
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
private fun TransactionGroupPreview() {
    KakaoPayTheme {
        TransactionGroup(
            dailyTransactions = DailyTransactions(
                date = "2026-04-23",
                dayOfWeek = "목",
                dailyTotal = -3475,
                transactions = listOf(
                    Transaction(
                        transactionId = 13,
                        transactionType = TransactionType.TRANSFER_SEND,
                        transactionMethod = TransactionMethod.PAY_MONEY,
                        transactionName = "염*원(카카오뱅크1234)",
                        amount = -3475,
                        includeInTotal = true
                    ),
                    Transaction(
                        transactionId = 14,
                        transactionType = TransactionType.TRANSFER_SEND,
                        transactionMethod = TransactionMethod.PAY_MONEY,
                        transactionName = "박솝트(박솝트)",
                        amount = -84632,
                        includeInTotal = false
                    )
                ) as ImmutableList<Transaction>
            )
        )
    }
}
