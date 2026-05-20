package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.Month
import com.example.a38_collaboration_android_kakaopay.data.mapper.toUiModel
import com.example.a38_collaboration_android_kakaopay.data.remote.RetrofitClient
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.ExpenseDataSource
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.model.SpendingOverviewUiModel
import kotlinx.coroutines.launch

class SpendingOverviewViewModel : ViewModel() {
    var uiState by mutableStateOf<UiState<SpendingOverviewUiModel>>(UiState.Loading)
        private set

    init {
        getTransactionsList()
    }

    var selectedMonth by mutableStateOf(Month.MAY)
        private set

    fun onMonthChanged(month: Month) {
        selectedMonth = month
        getTransactionsList(month.toYearMonth())
    }

    private fun Month.toYearMonth(): String = when (this) {
        Month.APRIL -> "2026-04"
        Month.MAY -> "2026-05"
    }

    fun getTransactionsList(yearMonth: String = "2026-05") {
        viewModelScope.launch {
            uiState = UiState.Loading
            runCatching {
                ExpenseDataSource(RetrofitClient.expenseApi)
                    .getExpenses(yearMonth)
                    .data
                    .toUiModel()
            }.onSuccess { data ->
                uiState = UiState.Success(data)
            }.onFailure {

            }
        }
    }
}
