package com.example.a38_collaboration_android_kakaopay.domain.repository

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.ExpenseDetailResponse

interface ExpenseRepository {
    suspend fun getExpenseDetail(transactionId: Long): Result<BaseResponse<ExpenseDetailResponse>>
}