package com.example.a38_collaboration_android_kakaopay.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssetsResponse(
    @SerialName("kakaopayBalance")
    val kakaopayBalance: Long,

    @SerialName("favoriteAccounts")
    val favoriteAccounts: List<AccountResponse>,

    @SerialName("totalExpense")
    val totalExpense: Long,

    )

@Serializable
data class AccountResponse(
    @SerialName("accountId")
    val accountId: Long,

    @SerialName("accountInfo")
    val accountInfo: String,
)
