package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model

import com.example.a38_collaboration_android_kakaopay.R

enum class SpendingCategoryModel(val koreanName: String, val imageResId: Int) {
    TRANSPORTATION("교통", R.drawable.img_transport),
    FOOD("음식", R.drawable.img_food),
    COFFEE_DESERT("커피/디저트", R.drawable.img_cafe),
}