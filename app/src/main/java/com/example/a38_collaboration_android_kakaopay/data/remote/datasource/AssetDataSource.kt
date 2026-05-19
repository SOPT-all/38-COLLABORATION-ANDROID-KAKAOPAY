package com.example.a38_collaboration_android_kakaopay.data.remote.datasource

import com.example.a38_collaboration_android_kakaopay.core.network.BaseResponse
import com.example.a38_collaboration_android_kakaopay.data.remote.api.AssetsApi
import com.example.a38_collaboration_android_kakaopay.data.remote.dto.response.AssetsResponse

class AssetDataSource(
    private val assetsApi: AssetsApi,
) {
    suspend fun getAssets(): BaseResponse<AssetsResponse> {
        return assetsApi.getAssets()
    }
}
