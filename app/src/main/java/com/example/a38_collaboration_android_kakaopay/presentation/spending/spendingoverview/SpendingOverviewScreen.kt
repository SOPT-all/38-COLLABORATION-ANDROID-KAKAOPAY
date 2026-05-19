package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.binarytab.BinaryTabControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPayScrollTopButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.dropdown.TransactionDropdown
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.MonthControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.DailyTransactions
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.Transaction
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.ActionContainer
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.SegmentControlBar
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.SwapViewButton
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component.TransactionGroup
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch

@Composable
fun SpendingOverviewRoute(
    paddingValues: PaddingValues,
    spendingSummary: SpendingSummary,
    onCategoryAnalysisClick: () -> Unit,
    dailyTransactions: List<DailyTransactions>,
    navController: NavController,
) {
    SpendingOverviewScreen(
        paddingValues = paddingValues,
        spendingSummary = spendingSummary,
        onCategoryAnalysisClick = onCategoryAnalysisClick,
        dailyTransactions = dailyTransactions
    )
}

@Composable
fun SpendingOverviewScreen(
    paddingValues: PaddingValues,
    spendingSummary: SpendingSummary,
    onCategoryAnalysisClick: () -> Unit,
    dailyTransactions: List<DailyTransactions>,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            KakaoPaySubTopBar(
                title = {},
                onBackClick = {},
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
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Column(
                        modifier = Modifier,
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))

                        OverviewSection(
                            spendingSummary = spendingSummary,
                            onCategoryAnalysisClick = onCategoryAnalysisClick
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TransactionHeader()
                    }
                }

                dailyTransactions.forEach { dailyTransaction ->
                    item {
                        TransactionGroup(
                            dailyTransactions = dailyTransaction,
                            modifier = Modifier
                                .padding(bottom = 24.dp)
                        )
                    }
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
                .navigationBarsPadding()
                .padding(16.dp)
        )
    }
}

@Composable
private fun OverviewSection(
    spendingSummary: SpendingSummary,
    onCategoryAnalysisClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        DateControl()

        SegmentControlBar()

        ActionContainer(
            spendingSummary = spendingSummary,
            onCategoryAnalysisClick = onCategoryAnalysisClick,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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
        MonthControl()

        SwapViewButton(
            onClick = {}
        )
    }
}

private val dummyDailyTransactions = listOf(
    DailyTransactions(
        date = "2026-04-27",
        dayOfWeek = "월",
        dailyTotal = -16325,
        transactions = persistentListOf(
            Transaction(
                transactionId = 1,
                transactionType = TransactionType.PAYMENT,
                transactionMethod = TransactionMethod.PAY_MONEY,
                transactionName = "우아한형제들·마라로제 떡볶이X튀2 콤보",
                amount = -11800,
                includeInTotal = true
            ),
            Transaction(
                transactionId = 2,
                transactionType = TransactionType.TRANSFER_SEND,
                transactionMethod = TransactionMethod.PAY_MONEY,
                transactionName = "염*원(카카오뱅크1234)",
                amount = -4525,
                includeInTotal = true
            )
        )
    ),
    DailyTransactions(
        date = "2026-04-23",
        dayOfWeek = "목",
        dailyTotal = -3475,
        transactions = persistentListOf(
            Transaction(
                transactionId = 3,
                transactionType = TransactionType.TRANSFER_SEND,
                transactionMethod = TransactionMethod.PAY_MONEY,
                transactionName = "박솝트(박솝트)",
                amount = -3475,
                includeInTotal = false
            )
        )
    ),
    DailyTransactions(
        date = "2026-04-16",
        dayOfWeek = "목",
        dailyTotal = 123000,
        transactions = persistentListOf(
            Transaction(
                transactionId = 4,
                transactionType = TransactionType.TRANSFER_RECEIVE,
                transactionMethod = TransactionMethod.PAY_MONEY,
                transactionName = "김솝트(김솝트)",
                amount = 123000,
                includeInTotal = true
            )
        )
    )
)

@Preview(showBackground = true)
@Composable
private fun SpendingOverviewScreenPreview() {
    KakaoPayTheme {
        SpendingOverviewScreen(
            paddingValues = PaddingValues(),
            spendingSummary = SpendingSummary(
                fixedExpense = 173253,
                previousMonthTotal = 55000,
                totalExpense = 79650,
                totalIncome = 150000,
            ),
            onCategoryAnalysisClick = {},
            dailyTransactions = dummyDailyTransactions
        )
    }
}