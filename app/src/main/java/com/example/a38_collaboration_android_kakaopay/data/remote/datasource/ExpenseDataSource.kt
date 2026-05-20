package com.example.a38_collaboration_android_kakaopay.data.remote.datasource

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.api.ExpenseApi
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseResponse

class ExpenseDataSource(
    private val expenseApi: ExpenseApi
) {
    suspend fun getExpenses(yearMonth: String): BaseResponse<ExpenseResponse> {
        return expenseApi.getExpenses(yearMonth)
    }
}