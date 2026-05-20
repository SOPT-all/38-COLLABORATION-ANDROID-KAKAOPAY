package com.example.a38_collaboration_android_kakaopay.data.remote.api

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExpenseApi{
    @GET("api/v1/expenses")
    suspend fun getExpenses(
        @Query("yearMonth") yearMonth: String
    ): BaseResponse<ExpenseResponse>
}
