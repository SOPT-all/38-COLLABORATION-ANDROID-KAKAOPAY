package com.example.a38_collaboration_android_kakaopay.data.remote.api

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ExpenseApi{

    @GET("api/v1/expenses/{transactionId}")
    suspend fun getExpenseDetail(
        @Path("transactionId") transactionId: Long
    ): BaseResponse<ExpenseDetailResponse>

}
