package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.app.navigation.*


enum class MainTab(
    val label: Int,
    val route: Route,
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val pressedIconRes: Int
) {
    HOME(
        label = R.string.nav_home,
        route = Home,
        defaultIconRes = R.drawable.ic_bottom_bar_home_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_home_pressed_24px
    ),
    BENEFITS(
        label = R.string.nav_benefits,
        route = Benefits,
        defaultIconRes = R.drawable.ic_bottom_bar_giftbox_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_giftbox_pressed_24px
    ),
    PAY(
        label = R.string.nav_payment,
        route = Pay,
        defaultIconRes = R.drawable.ic_bottom_bar_payment_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_payment_pressed_24px
    ),
    ASSET(
        label = R.string.nav_assets,
        route = Asset,
        defaultIconRes = R.drawable.ic_bottom_bar_asset_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_asset_pressed_24px
    ),
    INVEST(
        label = R.string.nav_stock,
        route = Invest,
        defaultIconRes = R.drawable.ic_bottom_bar_securities_default_24px,
        pressedIconRes = R.drawable.ic_bottom_bar_securities_pressed_24px
    )
}