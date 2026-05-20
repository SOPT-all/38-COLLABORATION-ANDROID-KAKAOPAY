package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Asset
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.KakaoPayTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.KakaoPayNavigatorBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.MainTab
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.CreditScoreCard
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinanceMenuSection
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialAssetsCard
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialBanner
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

        }

        is UiState.Empty -> {

        }

        is UiState.Failure -> {
            Text(state.message ?: "불러오기 실패")
        }

        is UiState.Success -> {
            FinancialOverviewScreen(
                paddingValues = paddingValues,
                uiState = state.data,
                onTabSelected = {
                    tab -> navController.navigate(tab.route)
                }
            )
        }

        else -> {
            Text("지금 안됨 왜 안될까 ")
        }
    }

}

@Composable
fun FinancialOverviewScreen(
    paddingValues: PaddingValues,
    onTabSelected: (MainTab) -> Unit,
    uiState: FinancialOverviewUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { KakaoPayTopBar(onClick = {})
                 },
        bottomBar = {
            KakaoPayNavigatorBar(
                currentRoute = Asset,
                onTabSelected = onTabSelected,
                modifier = Modifier.background(KakaoTheme.colors.white)
            )
        } )
    { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = modifier
                    .fillMaxSize()
                    .background(KakaoTheme.colors.grey100)
                    .padding(20.dp),
            ) {
                item { FinancialBanner(modifier = Modifier.fillMaxWidth()) }

                item { Spacer(Modifier.height(10.dp)) }

                item {
                    SecuritiesAccountCard(money = uiState.kakaopayBalance)
                }

                item { Spacer(Modifier.height(14.dp)) }

                item {
                    FinancialAssetsCard(
                        financialItems = uiState.favoriteAccounts,
                        onViewSpendingHistoryClick = {})
                }
                item { Spacer(Modifier.height(14.dp)) }

                item {
                    SpendingOverviewCard(
                        uiState.totalExpense,
                        onViewSpendingHistoryClick = {}
                    )
                }
                item { Spacer(Modifier.height(14.dp)) }

                item {
                    CreditScoreCard(iconRes = R.drawable.img_credit_icon_32px)
                }
                item { Spacer(Modifier.height(14.dp)) }

                item {
                    CreditScoreCard(iconRes = R.drawable.img_credit_icon_32px)
                }

                item {
                    FinanceMenuSection()
                }



                item{
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 16.dp)

                    ) {
                        Spacer(Modifier.height(20.dp))

                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24px),
                            contentDescription = null
                        )

                        Text(
                            text = "자산추가하기",
                            color = KakaoTheme.colors.black,
                            style = KakaoTheme.typography.bodyB16
                        )
                    }
                }


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
        )
    }
}
