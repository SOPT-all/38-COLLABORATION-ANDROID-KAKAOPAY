package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview

import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component.FinancialList
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FavoriteAccounts

fun FavoriteAccounts.toFinancialList(): FinancialList {
    return FinancialList(
        icon = accountInfo.toBankIcon(),
        account = accountInfo
    )
}

private fun String.toBankIcon(): Int {
    return when {
        contains("카카오뱅크") -> R.drawable.img_kakaopay_logo
        contains("토스뱅크") -> R.drawable.img_toss_logo
        contains("대구뱅크") -> R.drawable.img_dgbank_logo
        else -> R.drawable.ic_bottom_bar_asset_default_24px
    }
}
