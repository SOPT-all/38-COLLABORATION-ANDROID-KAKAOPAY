package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinancialOverviewUiModel

@Composable
fun FinancialOverviewRoute(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: FinancialOverviewViewModel = viewModel(),
) {
    FinancialOverviewScreen(
        paddingValues = paddingValues,
        uiState = viewModel.uiState,
    )
}

@Composable
fun FinancialOverviewScreen(
    paddingValues: PaddingValues,
    uiState: UiState<FinancialOverviewUiModel>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        when (val currentState = uiState) {
            UiState.Empty -> Unit
            UiState.Loading -> Text(text = "Loading assets...")
            UiState.Failure -> Text(text = "Failed to load assets")
            is UiState.Success -> {
                Text(text = "Balance: ${currentState.data.kakaopayBalance}")
                Text(text = "Total expense: ${currentState.data.totalExpense}")
                Text(text = "Favorite accounts: ${currentState.data.favoriteAccounts.size}")
            }
        }
    }
}
