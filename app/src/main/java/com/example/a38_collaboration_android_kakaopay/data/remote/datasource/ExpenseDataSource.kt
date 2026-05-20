package com.example.a38_collaboration_android_kakaopay.data.remote.datasource

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.api.ExpenseApi
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse

class ExpenseDataSource(
    private val expenseApi: ExpenseApi,
) {
    suspend fun getExpenseDetail(transactionId: Long): BaseResponse<ExpenseDetailResponse> {
        return expenseApi.getExpenseDetail(transactionId)
    }
}