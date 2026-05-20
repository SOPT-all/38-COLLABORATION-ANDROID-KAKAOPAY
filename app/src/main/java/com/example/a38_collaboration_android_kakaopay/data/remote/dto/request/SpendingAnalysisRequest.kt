package com.example.a38_collaboration_android_kakaopay.data.remote.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpendingAnalysisRequest(
    @SerialName("yearMonth")
    val yearMonth: String,
)