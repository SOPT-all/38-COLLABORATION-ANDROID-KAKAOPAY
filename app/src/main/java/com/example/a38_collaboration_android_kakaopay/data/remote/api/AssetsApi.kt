package com.example.a38_collaboration_android_kakaopay.data.remote.api

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.AssetsResponse
import retrofit2.http.GET

interface AssetsApi {
    @GET("api/v1/assets")
    suspend fun getAssets(): BaseResponse<AssetsResponse>
}
