package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.annotation.DrawableRes
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.app.navigation.*


enum class MainTab(
    val label: String,
    val route: Route,
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val pressedIconRes: Int
) {
    HOME(
        label = "홈",
        route = Home,
        defaultIconRes = R.drawable.ic_bottom_bar_home_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_home_pressed_24px
    ),
    BENEFITS(
        label = "혜택",
        route = Benefits,
        defaultIconRes = R.drawable.ic_bottom_bar_giftbox_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_giftbox_pressed_24px
    ),
    PAY(
        label = "결제",
        route = Pay,
        defaultIconRes = R.drawable.ic_bottom_bar_payment_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_payment_pressed_24px
    ),
    ASSET(
        label = "자산",
        route = Asset,
        defaultIconRes = R.drawable.ic_bottom_bar_asset_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_asset_pressed_24px
    ),
    INVEST(
        label = "주식",
        route = Invest,
        defaultIconRes = R.drawable.ic_bottom_bar_securities_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_securities_pressed_24px
    )
}