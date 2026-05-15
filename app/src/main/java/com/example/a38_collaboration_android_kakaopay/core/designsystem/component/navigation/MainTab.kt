package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.app.navigation.*


enum class MainTab(
    val route: Route,
    @StringRes val labelRes: Int,
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val pressedIconRes: Int
) {
    HOME(
        Home,
        R.string.nav_home,
        R.drawable.ic_bottom_bar_home_default_24px,
        R.drawable.ic_bottom_bar_home_pressed_24px
    ),
    BENEFITS(
        Benefits,
        R.string.nav_benefits,
        R.drawable.ic_bottom_bar_giftbox_default_24px,
        R.drawable.ic_bottom_bar_giftbox_pressed_24px
    ),
    PAY(
        Pay,
        R.string.nav_payment,
        R.drawable.ic_bottom_bar_payment_default_24px,
        R.drawable.ic_bottom_bar_payment_pressed_24px
    ),
    ASSET(
        Asset,
        R.string.nav_assets,
        R.drawable.ic_bottom_bar_asset_default_24px,
        R.drawable.ic_bottom_bar_asset_pressed_24px
    ),
    INVEST(
        Invest,
        R.string.nav_stock,
        R.drawable.ic_bottom_bar_securities_default_24px,
        R.drawable.ic_bottom_bar_securities_pressed_24px
    )
}