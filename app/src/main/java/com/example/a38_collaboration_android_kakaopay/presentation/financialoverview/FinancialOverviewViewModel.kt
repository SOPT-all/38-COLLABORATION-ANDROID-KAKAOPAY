package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.data.mapper.toUiModel
import com.example.a38_collaboration_android_kakaopay.data.remote.RetrofitClient
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.AssetDataSource
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinancialOverviewUiModel
import kotlinx.coroutines.launch

class FinancialOverviewViewModel : ViewModel() {
    var uiState by mutableStateOf<UiState<FinancialOverviewUiModel>>(UiState.Loading)
        private set

    init {
        getAssets()
    }

    fun getAssets() {
        viewModelScope.launch {
            uiState = UiState.Loading
            runCatching {
                AssetDataSource(RetrofitClient.assetsApi)
                    .getAssets()
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
