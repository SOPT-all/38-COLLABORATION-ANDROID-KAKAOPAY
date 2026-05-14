package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a38_collaboration_android_kakaopay.R

sealed class EdgeCaseType(
    @get:DrawableRes val icon: Int,
    @get:StringRes val text: Int,
) {

    // 데이터가 없을 때
    object Empty : EdgeCaseType (
        icon = R.drawable.img_error,
        text = R.string.edge_case_empty,
    )

    // 에러페이지 (404)
    object Error404 : EdgeCaseType (
        icon = R.drawable.img_404_error,
        text = R.string.edge_case_404,
    )

    // 전체 에러페이지
    object General : EdgeCaseType (
        icon = R.drawable.img_error,
        text = R.string.edge_case_general,
    )

}