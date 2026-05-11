package com.example.a38_collaboration_android_kakaopay.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("status")
    val status : Int,

    @SerialName("message")
    val message : String,

    @SerialName("data")
    val data : T,
    )
