package com.example.a38_collaboration_android_kakaopay.data.remote.api

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.SpendingAnalysisResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpendingAnalysisApi {

    @GET("/api/v1/expenses/analysis?yearMonth={yearMonth}")
    suspend fun getSpendingAnalysis(
        @Query("yearMonth") yearMonth: String,
    ): BaseResponse<SpendingAnalysisResponse>

}