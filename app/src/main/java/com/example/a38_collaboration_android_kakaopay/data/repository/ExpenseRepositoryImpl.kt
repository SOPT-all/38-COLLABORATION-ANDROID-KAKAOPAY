package com.example.a38_collaboration_android_kakaopay.data.repository

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.datasource.ExpenseDataSource
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse
import com.example.a38_collaboration_android_kakaopay.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl(
    private val expenseDataSource: ExpenseDataSource
) : ExpenseRepository {

    override suspend fun getExpenseDetail(transactionId: Long): Result<BaseResponse<ExpenseDetailResponse>> {
        return runCatching {
            val response = expenseDataSource.getExpenseDetail(transactionId)
            response
        }.onFailure { exception ->
            exception.printStackTrace()
        }
    }
}
