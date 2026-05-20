package com.example.a38_collaboration_android_kakaopay.data.mapper

import android.util.Log
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.Month
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.categoryExpenses
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.SpendingAnalysisResponse
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.CategoryExpenseItem
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingAnalysisUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingCategoryModel
import kotlinx.collections.immutable.toImmutableList

fun SpendingAnalysisResponse.toUiModel(
    yearMonth: String,
    chartImageResId: Int
): SpendingAnalysisUiModel {
    val monthInt = yearMonth.split("-").getOrNull(1)?.toIntOrNull() ?: 5

    val enumMonth = if (monthInt == 4) Month.APRIL else Month.MAY

    return SpendingAnalysisUiModel(
        selectedMonth = enumMonth,
        currentMonthTotal = this.monthlyCumulativeTotal,
        previousMonthTotal = this.previousMonthSamePeriodTotal,
        chartImageResId = chartImageResId,
        categoryExpenses = this.categoryExpenses.map { it.toUiItem() }.toImmutableList()
    )
}

fun categoryExpenses.toUiItem(): CategoryExpenseItem {
    return CategoryExpenseItem(
        categoryType = SpendingCategoryModel.valueOf(this.category.uppercase()),
        currentMonthAmount = this.currentMonthAmount,
        previousMonthAmount = this.previousMonthAmount
    )
}
