package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.state.UiState
import com.example.a38_collaboration_android_kakaopay.data.mapper.toUiModel
import com.example.a38_collaboration_android_kakaopay.data.remote.RetrofitClient
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.SpendingAnalysisDataSource
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingAnalysisUiModel
import kotlinx.coroutines.launch

class SpendingAnalysisViewModel : ViewModel() {
    companion object {
        private const val TAG = "SpendingAnalysisVM"
    }

    var uiState by mutableStateOf<UiState<SpendingAnalysisUiModel>>(UiState.Loading)
        private set

    init {
        getSpendingAnalysis("2026-05")
    }

    fun getSpendingAnalysis(yearMonth: String) {
        viewModelScope.launch {
            uiState = UiState.Loading
            Log.d(TAG, "getSpendingAnalysis called. yearMonth=$yearMonth")

            runCatching {
                val response = SpendingAnalysisDataSource(RetrofitClient.spendingAnalysisApi)
                    .getSpendingAnalysis(yearMonth)
                Log.d(
                    TAG,
                    "API success. code=${response.code}, message=${response.message}, data=${response.data}"
                )

                val remoteData = response.data

                val month = yearMonth.split("-").getOrNull(1)?.toIntOrNull() ?: 5
                val imageResId = getChartImageResource(month)

                remoteData.toUiModel(yearMonth = yearMonth, chartImageResId = imageResId)
            }.onSuccess { data ->
                Log.d(TAG, "Mapped uiModel successfully. data=$data")
                uiState = UiState.Success(data)
            }.onFailure { throwable ->
                Log.e(
                    TAG,
                    "getSpendingAnalysis failed. yearMonth=$yearMonth, error=${throwable.message}",
                    throwable
                )
                uiState = UiState.Failure
            }
        }
    }

    private fun getChartImageResource(month: Int): Int {
        return when (month) {
            4 -> R.drawable.img_chart_april
            5 -> R.drawable.img_chart_may
            else -> R.drawable.img_chart_may
        }
    }
}
