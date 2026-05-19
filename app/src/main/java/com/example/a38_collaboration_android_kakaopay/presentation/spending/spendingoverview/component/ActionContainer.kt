package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary

@Composable
fun ActionGroup(
    spendingSummary: SpendingSummary,
    modifier: Modifier = Modifier
) {
    val expenseDiff = spendingSummary.totalExpense - spendingSummary.previousMonthTotal

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ActionItemsGroup(
            expenseDiff = expenseDiff,
            fixedExpense = spendingSummary.fixedExpense
        )

        MultipleActionItem(
            totalExpense = spendingSummary.totalExpense,
            totalIncome = spendingSummary.totalIncome
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ActionGroupPreview() {
    KakaoPayTheme {
        ActionGroup(
            spendingSummary = SpendingSummary(
                totalExpense = 79650,
                totalIncome = 150000,
                fixedExpense = 173253,
                previousMonthTotal = 40000,
            )
        )
    }
}