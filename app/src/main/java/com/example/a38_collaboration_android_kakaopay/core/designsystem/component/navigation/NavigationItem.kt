package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NavigationItem(
    @StringRes val labelRes: Int,
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val pressedIconRes: Int
)