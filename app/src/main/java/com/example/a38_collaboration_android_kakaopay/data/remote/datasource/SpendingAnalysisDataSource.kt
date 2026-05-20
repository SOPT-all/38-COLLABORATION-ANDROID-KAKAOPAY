package com.example.a38_collaboration_android_kakaopay.data.remote.datasource

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.api.SpendingAnalysisApi
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.SpendingAnalysisResponse

class SpendingAnalysisDataSource(
    private val spendingAnalysisApi: SpendingAnalysisApi
) {
    suspend fun getSpendingAnalysis(yearMonth: String): BaseResponse<SpendingAnalysisResponse>{
        return spendingAnalysisApi.getSpendingAnalysis(yearMonth)
    }
}