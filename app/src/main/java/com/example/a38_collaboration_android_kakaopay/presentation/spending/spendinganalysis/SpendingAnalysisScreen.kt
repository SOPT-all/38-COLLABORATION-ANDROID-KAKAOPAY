package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.core.common.util.KakaoPullToIndicator
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCaseType
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.Month
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.MonthControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.KakaoPaySegmentControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.SegmentTab
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.edgecase.EdgeCaseScreen
import com.example.a38_collaboration_android_kakaopay.presentation.loading.SpendingAnaysisyLoadingScreen
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.AssetAction
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.CategoryExpenseItem
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.ExpenseList
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.ExpenseSummary
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingAnalysisUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingCategoryModel
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SpendingAnalysisRoute(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: SpendingAnalysisViewModel = viewModel(),
) {
    val state = viewModel.uiState

    when (state) {
        is UiState.Loading -> {
            SpendingAnaysisyLoadingScreen(paddingValues = paddingValues)
        }

        is UiState.Success -> {
            SpendingAnalysisScreen(
                paddingValues = paddingValues,
                uiModel = state.data,
                onMonthNavigate = { yearMonth ->
                    viewModel.getSpendingAnalysis(yearMonth)
                })
        }

        is UiState.Failure -> {
            EdgeCaseScreen(type = EdgeCaseType.General)
        }

        is UiState.Empty -> {
            EdgeCaseScreen(type = EdgeCaseType.Empty)
        }
    }
}

@Composable
fun SpendingAnalysisScreen(
    paddingValues: PaddingValues,
    uiModel: SpendingAnalysisUiModel,
    onMonthNavigate: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var currentTab by remember { mutableStateOf(SegmentTab.SUMMARY) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        KakaoPaySubTopBar(
            title = {
                Text(
                    text = "소비분석",
                    style = KakaoTheme.typography.bodyM16,
                    color = KakaoTheme.colors.black
                )
            },
            onBackClick = {},
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.weight(12f))

        KakaoPaySegmentControl(
            selectedTab = currentTab,
            onTabSelected = { selected ->
                currentTab = selected
            },
        )

        Spacer(modifier = Modifier.weight(21f))

        MonthControl(
            selectedMonth = uiModel.selectedMonth,
            onMonthChanged = { newMonth ->
                val targetYearMonth = if (newMonth == Month.APRIL) "2026-04" else "2026-05"
                onMonthNavigate(targetYearMonth)
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        ExpenseSummary(
            currentMonthTotal = uiModel.currentMonthTotal,
            previousMonthTotal = uiModel.previousMonthTotal,
        )

        Spacer(modifier = Modifier.weight(16f))

        Image(
            painter = painterResource(id = uiModel.chartImageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.weight(27f))

        AssetAction(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.weight(30f))

        ExpenseList(
            categoryExpenses = uiModel.categoryExpenses,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(43f))

    }

}

@Preview(showBackground = true)
@Composable
private fun SpendingAnalysisScreenPreview() {

    val mockUiModel = SpendingAnalysisUiModel(
        selectedMonth = Month.MAY,
        currentMonthTotal = 11800L,
        previousMonthTotal = 64500L,
        chartImageResId = R.drawable.img_chart_may,
        categoryExpenses = listOf(
            CategoryExpenseItem(SpendingCategoryModel.TRANSPORTATION, 58450L, 68450L),
            CategoryExpenseItem(SpendingCategoryModel.FOOD, 23900L, 13900L),
            CategoryExpenseItem(SpendingCategoryModel.COFFEE_DESSERT, 5000L, -5000L)
        ).toImmutableList()
    )

    KakaoPayTheme {
        SpendingAnalysisScreen(
            paddingValues = PaddingValues(), uiModel = mockUiModel, onMonthNavigate = {})
    }
}
