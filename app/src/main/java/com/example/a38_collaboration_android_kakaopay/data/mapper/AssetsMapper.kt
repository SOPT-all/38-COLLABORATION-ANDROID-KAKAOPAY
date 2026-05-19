package com.example.a38_collaboration_android_kakaopay.data.mapper

import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.AssetsResponse
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FavoriteAccountUiModel
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinancialOverviewUiModel

fun AssetsResponse.toUiModel(): FinancialOverviewUiModel {
    return FinancialOverviewUiModel(
        kakaopayBalance = kakaopayBalance,
        favoriteAccounts = favoriteAccounts.map { account ->
            FavoriteAccountUiModel(
                accountId = account.accountId,
                accountInfo = account.accountInfo,
            )
        },
        totalExpense = totalExpense,
    )
}
