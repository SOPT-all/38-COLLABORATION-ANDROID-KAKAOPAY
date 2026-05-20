package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.example.a38_collaboration_android_kakaopay.R

@Immutable
data class FinanceMenuItem(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
)

val financeMenuItems = listOf(
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_dividend_32px,
        titleRes = R.string.finance_menu_dividend
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_safe_guard_32px,
        titleRes = R.string.finance_menu_guard
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_credit_planner_32px,
        titleRes = R.string.finance_menu_credit_planner
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_insurance_32px,
        titleRes = R.string.finance_menu_my_insurance
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_loan_32px,
        titleRes = R.string.finance_menu_my_loan
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_real_estate_32px,
        titleRes = R.string.finance_menu_real_estate
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_analysis_32px,
        titleRes = R.string.finance_menu_consumption_analysis
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_together_32px,
        titleRes = R.string.finance_menu_together_asset
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_fortune_32px,
        titleRes = R.string.finance_menu_invest_inspiration
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_hospital_expense_32px,
        titleRes = R.string.finance_menu_hospital_bill
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_my_insurance_32px,
        titleRes = R.string.finance_menu_for_me_insurance
    ),
    FinanceMenuItem(
        iconRes = R.drawable.ic_graphic_secretary_32px,
        titleRes = R.string.finance_menu_finance_assistant
    ),
)
