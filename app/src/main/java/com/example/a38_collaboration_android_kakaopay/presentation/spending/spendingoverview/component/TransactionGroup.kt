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
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.DailyTransactionsUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.TransactionsUiModel
import kotlinx.collections.immutable.persistentListOf

@Composable
fun TransactionGroup(
    dailyTransactions: DailyTransactionsUiModel,
    onTransactionClick: (TransactionsUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TransactionGroupHeader(dailyTransactions)

        dailyTransactions.transactions.forEach { transaction ->
            TransactionListItem(
                transaction = transaction,
                onClick = { onTransactionClick(transaction) }
            )
        }
    }
}

@Composable
private fun TransactionGroupHeader(
    dailyTransactions: DailyTransactionsUiModel,
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
            text = dailyTransactions.formattedDailyTotal,
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
            dailyTransactions = DailyTransactionsUiModel (
                date = "2026-04-23",
                dayOfWeek = "목",
                dailyTotal = -3475,
                transactions = persistentListOf(
                    TransactionsUiModel (
                        transactionId = 13,
                        transactionType = TransactionType.TRANSFER_SEND,
                        transactionMethod = TransactionMethod.PAY_MONEY,
                        transactionName = "염*원(카카오뱅크1234)",
                        amount = -3475,
                        includeInTotal = true,
                        thumbnail = R.drawable.img_kakaopay_logo
                    ),
                    TransactionsUiModel (
                        transactionId = 14,
                        transactionType = TransactionType.TRANSFER_SEND,
                        transactionMethod = TransactionMethod.PAY_MONEY,
                        transactionName = "박솝트(박솝트)",
                        amount = -84632,
                        includeInTotal = false,
                        thumbnail = R.drawable.img_profile_placeholder
                    )
                )
            ),
            onTransactionClick = {}
        )
    }
}
