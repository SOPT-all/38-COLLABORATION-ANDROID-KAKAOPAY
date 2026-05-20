package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model

import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.Month
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.CategoryExpenseItem
import kotlinx.collections.immutable.ImmutableList

data class SpendingAnalysisUiModel(
    val selectedMonth: Month,
    val currentMonthTotal: Long,
    val previousMonthTotal: Long,
    val chartImageResId: Int,
    val categoryExpenses: ImmutableList<CategoryExpenseItem>
)
