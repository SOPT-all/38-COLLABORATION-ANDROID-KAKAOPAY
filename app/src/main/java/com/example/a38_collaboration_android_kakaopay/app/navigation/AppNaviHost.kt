package com.example.a38_collaboration_android_kakaopay.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.SpendingSummary
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.DailyTransactions
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.Transaction
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.FinancialOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.SpendingAnalysisRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.SpendingDetailsRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.SpendingOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.splash.SplashRoute
import kotlinx.collections.immutable.persistentListOf

@Composable
fun AppNaviHost(
    navController: NavHostController,

    innerPadding: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        startDestination = Asset::class,
        modifier = Modifier.fillMaxSize()
    ) {
        composable<FinancialOverview> {
            FinancialOverviewRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<SpendingAnalysis> {
            SpendingAnalysisRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<SpendingDetails> {
            SpendingDetailsRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Asset> {
            FinancialOverviewRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }


        composable<Splash> {
            SplashRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Home> {
            SpendingAnalysisRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Benefits> {
            SpendingDetailsRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Pay> {
            // 테스트용 더미 데이터 (추후 삭제)
            val dummySummary = SpendingSummary(
                fixedExpense = 173253,
                previousMonthTotal = 55000,
                totalExpense = 79650,
                totalIncome = 150000,
            )

            val dummyDailyTransactions = listOf(
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

            SpendingOverviewRoute(
                paddingValues = innerPadding,
                navController = navController,
                spendingSummary = dummySummary,
                dailyTransactions = dummyDailyTransactions,
                onCategoryAnalysisClick = {}
            )
        }

//        composable<Asset> {}

        composable<Invest> {}

    }
}
