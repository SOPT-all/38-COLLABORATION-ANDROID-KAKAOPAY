package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.data.mapper.toUiModel
import com.example.a38_collaboration_android_kakaopay.data.remote.RetrofitClient
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.ExpenseDataSource
import kotlinx.coroutines.launch

class SpendingDetailsViewModel : ViewModel() {

    var uiState by mutableStateOf<UiState<SpendingDetailUiModel>>(UiState.Loading)
        private set

    init {
        getExpenseDetail(transactionId = 1L)
    }

    fun getExpenseDetail(transactionId: Long = 1L) {
        viewModelScope.launch {
            uiState = UiState.Loading
            runCatching {
                ExpenseDataSource(RetrofitClient.expenseApi)
                    .getExpenseDetail(transactionId)
                    .data
                    .toUiModel()
            }.onSuccess { data ->
                uiState = UiState.Success(data)
            }.onFailure {
                uiState = UiState.Failure
            }
        }
    }
    fun onToggleChanged(newValue: Boolean) {
        val currentState = uiState
        if (currentState is UiState.Success) {
            val updatedSummary = currentState.data.summaryInfo.copy(isIncludedInTotal = newValue)

            uiState = UiState.Success(
                currentState.data.copy(summaryInfo = updatedSummary)
            )
        }
    }
}