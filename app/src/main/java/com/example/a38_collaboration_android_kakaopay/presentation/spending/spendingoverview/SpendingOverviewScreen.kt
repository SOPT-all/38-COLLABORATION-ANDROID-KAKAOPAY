package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingAnalysis
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingDetails
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.core.common.util.KakaoPullToIndicator
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.binarytab.BinaryTabControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPayScrollTopButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.dropdown.TransactionDropdown
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCaseType
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.Month
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.MonthControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.edgecase.EdgeCaseScreen
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.ActionContainer
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.ActionContainerSkeleton
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.SegmentControlBar
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.SwapViewButton
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.TransactionGroup
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.DailyTransactionsUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.SpendingOverviewUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.TransactionsUiModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch

@Composable
fun SpendingOverviewRoute(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: SpendingOverviewViewModel = viewModel(),
) {
    when (val uiState = viewModel.uiState) {
        is UiState.Empty -> {
            EdgeCaseScreen(type = EdgeCaseType.Empty)
        }

        is UiState.Failure -> {
            EdgeCaseScreen(type = EdgeCaseType.General)
        }

        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(KakaoTheme.colors.white),
                contentAlignment = Alignment.Center
            ) {
                KakaoPullToIndicator(
                    isRefreshing = true,
                    onRefresh = {}
                ) {
                    Box(modifier = Modifier.size(36.dp))
                }
            }
        }

        is UiState.Success -> {
            SpendingOverviewScreen(
                paddingValues = paddingValues,
                uiState = uiState,
                selectedMonth = viewModel.selectedMonth,
                onMonthChanged = { month -> viewModel.onMonthChanged(month) },
                onBackClick = { navController.popBackStack() },
                onCategoryAnalysisClick = {
                    navController.navigate(SpendingAnalysis)
                },
                onTransactionClick = { transaction ->
                    navController.navigate(SpendingDetails)
                }
            )
        }
    }
}

@Composable
fun SpendingOverviewScreen(
    paddingValues: PaddingValues,
    uiState: UiState<SpendingOverviewUiModel>,
    selectedMonth: Month,
    onMonthChanged: (Month) -> Unit,
    onBackClick: () -> Unit,
    onCategoryAnalysisClick: () -> Unit,
    onTransactionClick: (TransactionsUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            KakaoPaySubTopBar(
                title = {},
                onBackClick = onBackClick,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            BinaryTabControl(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )

            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(
                    bottom = 123.dp
                ),
            ) {
                item {
                    Column(
                        modifier = Modifier,
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))

                        OverviewSection(
                            uiState = uiState,
                            onMonthChanged = onMonthChanged,
                            selectedMonth = selectedMonth,
                            onCategoryAnalysisClick = onCategoryAnalysisClick
                        )

                        if (uiState is UiState.Success) {
                            Spacer(modifier = Modifier.height(32.dp))

                            TransactionHeader()
                        }
                    }
                }

                when (uiState) {
                    is UiState.Success -> {
                        uiState.data.dailyTransactions.forEach { dailyTransaction ->
                            item {
                                TransactionGroup(
                                    dailyTransactions = dailyTransaction,
                                    onTransactionClick = onTransactionClick,
                                    modifier = Modifier
                                        .padding(bottom = 24.dp)
                                )
                            }
                        }
                    }

                    is UiState.Loading -> {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 18.dp),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                KakaoPullToIndicator(
                                    isRefreshing = true,
                                    onRefresh = {}
                                ) { }
                            }
                        }
                    }

                    else -> {}
                }
            }
        }

        KakaoPayScrollTopButton(
            onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = paddingValues.calculateBottomPadding() + 16.dp,
                    end = 16.dp
                )
        )
    }
}

@Composable
private fun OverviewSection(
    uiState: UiState<SpendingOverviewUiModel>,
    selectedMonth: Month,
    onMonthChanged: (Month) -> Unit,
    onCategoryAnalysisClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        DateControl(
            selectedMonth = selectedMonth,
            onMonthChanged = onMonthChanged
        )

        SegmentControlBar()

        when (uiState) {
            is UiState.Success -> ActionContainer(
                spendingSummary = uiState.data.spendingSummary,
                onCategoryAnalysisClick = onCategoryAnalysisClick,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            is UiState.Loading -> ActionContainerSkeleton()
            else -> {}
        }
    }
}

@Composable
private fun TransactionHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, bottom = 23.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        TransactionDropdown(
            onClick = {}
        )
    }
}

@Composable
private fun DateControl(
    selectedMonth: Month,
    onMonthChanged: (Month) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 10.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MonthControl(
            selectedMonth = selectedMonth,
            onMonthChanged = onMonthChanged,
        )

        SwapViewButton(
            onClick = {}
        )
    }
}

private val dummyDailyTransactions = listOf(
    DailyTransactionsUiModel(
        date = "2026-04-27",
        dayOfWeek = "월",
        dailyTotal = -16325,
        transactions = persistentListOf(
            TransactionsUiModel(
                transactionId = 1,
                transactionType = TransactionType.PAYMENT,
                transactionMethod = TransactionMethod.PAY_MONEY,
                transactionName = "우아한형제들·마라로제 떡볶이X튀2 콤보",
                amount = -11800,
                includeInTotal = true,
                thumbnail = R.drawable.img_profile_placeholder
            ),
        )
    )
)

@Preview(showBackground = true)
@Composable
private fun SpendingOverviewScreenPreview() {
    KakaoPayTheme {
        SpendingOverviewScreen(
            paddingValues = PaddingValues(),
            uiState = UiState.Success(
                SpendingOverviewUiModel(
                    spendingSummary = SpendingSummary(
                        fixedExpense = 173253,
                        previousMonthTotal = 55000,
                        totalExpense = 79650,
                        totalIncome = 150000,
                    ),
                    dailyTransactions = dummyDailyTransactions
                )
            ),
            selectedMonth = Month.MAY,
            onMonthChanged = {},
            onBackClick = {},
            onCategoryAnalysisClick = {},
            onTransactionClick = {}
        )
    }
}
