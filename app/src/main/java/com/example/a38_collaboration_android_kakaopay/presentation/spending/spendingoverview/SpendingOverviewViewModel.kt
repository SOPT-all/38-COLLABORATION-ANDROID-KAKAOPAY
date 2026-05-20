package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
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

    fun getTransactionsList() {
        viewModelScope.launch {
            uiState = UiState.Loading
            runCatching {
                ExpenseDataSource(RetrofitClient.expenseApi)
                    .getExpenses(yearMonth = "2026-04")
                    .data
                    .toUiModel()
            }.onSuccess { data ->
                uiState = UiState.Success(data)
            }.onFailure {
                uiState = UiState.Failure
            }
        }
    }
}