package com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview

import androidx.annotation.StringRes
import com.example.a38_collaboration_android_kakaopay.R

enum class SpendingSegment(@StringRes val label: Int) {
    ALL(label = R.string.spending_overview_segment_all),
    CARD(label = R.string.spending_overview_segment_card),
    ACCOUNT(label = R.string.spending_overview_segment_account),
    PAY(label = R.string.spending_overview_segment_pay),
    POINT(label = R.string.spending_overview_segment_point),
    PAY_MONEY(label = R.string.spending_overview_segment_pay_money),
    PAY_POINT(label = R.string.spending_overview_segment_pay_point)
}