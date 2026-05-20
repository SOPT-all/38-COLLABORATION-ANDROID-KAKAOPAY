package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.data.mapper.toUiModel
import com.example.a38_collaboration_android_kakaopay.data.remote.RetrofitClient
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.AssetDataSource
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FinancialOverviewViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<FinancialOverviewUiState>>(UiState.Loading)
    val uiState: StateFlow<UiState<FinancialOverviewUiState>> = _uiState.asStateFlow()

    init {
        getAssets()
    }

    fun getAssets() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            runCatching {
             AssetDataSource(RetrofitClient.assetsApi)
                    .getAssets()
                    .data
                    .toUiModel()
            }.onSuccess { data ->
                _uiState.value = UiState.Success(
                    data = FinancialOverviewUiState(
                       kakaopayBalance =  data.kakaopayBalance,
                        totalExpense = data.totalExpense,
                       favoriteAccounts =  data.favoriteAccounts
                           .map { it.toFinancialList() }
                           .toImmutableList()
                    )
                )

            }.onFailure {
                _uiState.value = UiState.Failure
            }
        }
    }
}
