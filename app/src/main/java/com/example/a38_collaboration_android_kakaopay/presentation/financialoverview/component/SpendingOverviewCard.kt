package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SpendingOverviewCard(
    totalExpense: Long,
    modifier: Modifier = Modifier,
) {
    KakaoPayBasicCard(
        enabled = true,
        onClick = {},
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 16.dp
            )
        ) {

            Text(
                text = stringResource(R.string.financial_spending),
                color = KakaoTheme.colors.grey500,
                style = KakaoTheme.typography.titleB18
            )

            SpendingOverviewRow(
                title = R.string.financial_spending_upcoming_card_payment,
                content = R.string.financial_spending_shinhan_card_amount_view,
                icon = R.drawable.ic_graphic_card_bill_32px
            )

            SpendingOverviewRow(
                title = R.string.financial_spending_schedule,
                content = R.string.financial_spending_monthly_fixed_expense_view,
                icon = R.drawable.ic_graphic_monthly_expenses_32px
            )

        }
    }
}

@Composable
private fun SpendingOverviewRow(
    @StringRes title: Int,
    @StringRes content: Int,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = stringResource(title),
                color = KakaoTheme.colors.grey500,
                style = KakaoTheme.typography.bodyR14
            )

            Text(
                text = stringResource(content),
                color = KakaoTheme.colors.highlightPrimaryBlue,
                style = KakaoTheme.typography.bodyB16
            )

        }
    }
}

@Preview
@Composable
private fun SendingPreview() {
    KakaoPayTheme {
        SpendingOverviewRow(
            icon = R.drawable.ic_graphic_card_bill_32px,
            title = R.string.financial_spending_upcoming_card_payment,
            content = R.string.financial_spending_shinhan_card_amount_view,
        )
    }
}

@Preview
@Composable
private fun SpendingOverviewCardPreview() {
    KakaoPayTheme {
        SpendingOverviewCard(
            totalExpense = 33333,
        )
    }
}
