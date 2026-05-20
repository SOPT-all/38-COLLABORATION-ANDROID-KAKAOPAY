package com.example.a38_collaboration_android_kakaopay.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExpenseDetailResponse(
    @SerialName("id")
    val id: Long,

    @SerialName("expenseName")
    val expenseName: String,

    @SerialName("paymentMethod")
    val paymentMethod: String,

    @SerialName("splitAmount")
    val splitAmount: Long,

    @SerialName("totalAmount")
    val totalAmount: Long,

    @SerialName("participantCount")
    val participantCount: Int,

    @SerialName("orderNumber")
    val orderNumber: String,

    @SerialName("orderedAt")
    val orderedAt: String,

    @SerialName("category")
    val category: String,

    @SerialName("includeInTotal")
    val includeInTotal: Boolean
)