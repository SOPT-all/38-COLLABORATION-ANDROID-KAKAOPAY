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
fun ActionContainer(
    spendingSummary: SpendingSummary,
    onCategoryAnalysisClick: () -> Unit,
    onFixedExpenseClick: () -> Unit,
    onTotalExpenseClick: () -> Unit,
    onTotalIncomeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ActionItemsGroup(
            expenseDiffInManWon = spendingSummary.expenseDiffInManWon,
            isOverSpent = spendingSummary.isOverSpent,
            fixedExpense = spendingSummary.fixedExpense,
            onCategoryAnalysisClick = onCategoryAnalysisClick,
            onFixedExpenseClick = onFixedExpenseClick,
        )

        MultipleActionItem(
            totalExpense = spendingSummary.totalExpense,
            totalIncome = spendingSummary.totalIncome,
            onTotalExpenseClick = onTotalExpenseClick,
            onTotalIncomeClick = onTotalIncomeClick,
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ActionContainerPreview() {
    KakaoPayTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // 지난달 대비 더 쓰는 중
            ActionContainer(
                spendingSummary = SpendingSummary(
                    fixedExpense = 173253,
                    previousMonthTotal = 40000,
                    totalExpense = 79650,
                    totalIncome = 150000,
                ),
                onCategoryAnalysisClick = {},
                onFixedExpenseClick = {},
                onTotalExpenseClick = {},
                onTotalIncomeClick = {}
            )
            // 지난달 대비 덜 쓰는 중
            ActionContainer(
                spendingSummary = SpendingSummary(
                    fixedExpense = 173253,
                    previousMonthTotal = 40000,
                    totalExpense = 25400,
                    totalIncome = 150000,
                ),
                onCategoryAnalysisClick = {},
                onFixedExpenseClick = {},
                onTotalExpenseClick = {},
                onTotalIncomeClick = {}
            )
        }
    }
}