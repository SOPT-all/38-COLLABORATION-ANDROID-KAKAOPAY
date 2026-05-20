package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Asset
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingOverview
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.core.common.util.KakaoPullToIndicator
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.KakaoPayTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCaseType
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.KakaoPayNavigatorBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.MainTab
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.edgecase.EdgeCaseScreen
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.CreditScoreCard
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinanceMenuSection
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialAssetsCard
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialBanner
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialCtaButton
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialList
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.SecuritiesAccountCard
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.SpendingOverviewCard
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FinancialOverviewRoute(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: FinancialOverviewViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {

        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                KakaoPullToIndicator(
                    isRefreshing = true,
                    onRefresh = {}
                ) {
                    Box(modifier = Modifier.size(36.dp))
                }
            }
        }

        is UiState.Empty -> {
            EdgeCaseScreen(type = EdgeCaseType.Empty)
        }

        is UiState.Failure -> {
            EdgeCaseScreen(type = EdgeCaseType.General)
        }

        is UiState.Success -> {
            FinancialOverviewScreen(
                paddingValues = paddingValues,
                uiState = state.data,
                onTabSelected = { tab ->
                    navController.navigate(tab.route)
                },
                onNavigator = {navController.navigate(SpendingOverview)}
            )
        }

    }
}

@Composable
fun FinancialOverviewScreen(
    paddingValues: PaddingValues,
    onTabSelected: (MainTab) -> Unit,
    onNavigator : () -> Unit,
    uiState: FinancialOverviewUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(KakaoTheme.colors.backgroundDefaultGrey)
                    .statusBarsPadding()
            ) {
                KakaoPayTopBar(
                    onClick = {}
                )
            }

        },
        bottomBar = {
            KakaoPayNavigatorBar(
                currentRoute = Asset,
                onTabSelected = onTabSelected,
                modifier = Modifier
            )
        },
    )

    { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = modifier
                .fillMaxSize()
                .background(KakaoTheme.colors.backgroundDefaultGrey)
                .consumeWindowInsets(innerPadding)
                .padding(horizontal = 20.dp)


        ) {
            item { FinancialBanner(modifier = Modifier.fillMaxWidth()) }

            item { Spacer(Modifier.height(10.dp)) }

            item { SecuritiesAccountCard(money = uiState.kakaopayBalance) }

            item { Spacer(Modifier.height(14.dp)) }

            item { FinancialAssetsCard(financialItems = uiState.favoriteAccounts) }

            item { Spacer(Modifier.height(14.dp)) }

            item {
                SpendingOverviewCard(
                    uiState.totalExpense,
                    onViewSpendingHistoryClick = onNavigator
                )
            }

            item { Spacer(Modifier.height(14.dp)) }

            item { CreditScoreCard(iconRes = R.drawable.img_credit_icon_32px) }

            item { Spacer(Modifier.height(14.dp)) }

            item {
                FinanceMenuSection()
            }

            item { Spacer(Modifier.height(14.dp)) }

            item { FinancialCtaButton() }
        }

    }
}

@Preview
@Composable
private fun FinancialOverviewScreenPreview() {
    KakaoPayTheme {
        FinancialOverviewScreen(
            paddingValues = PaddingValues(0.dp),
            uiState = FinancialOverviewUiState(
                kakaopayBalance = 1250000L,
                totalExpense = 482000L,
                favoriteAccounts = persistentListOf(
                    FinancialList(
                        icon = R.drawable.img_kakaopay_logo,
                        account = "카카오뱅크 입출금통장"
                    )
                ),
            ),
            onTabSelected = {},
            onNavigator = {}
        )
    }
}
