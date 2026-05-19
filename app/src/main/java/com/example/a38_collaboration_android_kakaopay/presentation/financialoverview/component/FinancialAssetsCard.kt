package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPaySecondaryButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FinancialAssetsCard(
    financialItems: ImmutableList<FinancialList>,
    onViewSpendingHistoryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    KakaoPayBasicCard(
        enabled = true, onClick = onViewSpendingHistoryClick, modifier = modifier
    ) {
        Column {

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

                FinancialAssetsTitle(
                    modifier = modifier.padding(vertical = 16.dp)
                )

                financialItems.forEach { financialItem ->
                    FinancialOverviewAssetsRow(
                        account = financialItem.account,
                        icon = financialItem.icon,
                        onClick = {},
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }

            HorizontalDivider(thickness = 1.dp, color = KakaoTheme.colors.grey200)

            FinancialMenuRow(
                financialMenus = listOf(
                    R.string.financial_valuation_amount_view,
                    R.string.financial_point_membership,
                    R.string.financial_total_assets_view,
                )
            )
        }
    }
}


@Composable
private fun FinancialAssetsTitle(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.financial_frequently_used),
            modifier = Modifier.padding(end = 4.dp),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.titleB18
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(999.dp))
                .border(border = BorderStroke(width = 1.dp, color = KakaoTheme.colors.grey200))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = stringResource(R.string.financial_protection_required),
                color = KakaoTheme.colors.grey400,
                style = KakaoTheme.typography.labelB12
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.financial_edit),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyR14
        )
    }
}

@Composable
private fun FinancialOverviewAssetsRow(
    account: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FinancialOverviewRow(
        icon = icon, useCompactIconSize = true, trailingContent = {
            KakaoPaySecondaryButton(
                text = stringResource(R.string.financial_securities_account_send), onClick = onClick
            )
        }, modifier = modifier
    ) {

        Text(
            text = account,
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.labelR12
        )

        Text(
            text = stringResource(R.string.financial_balance_view),
            color = KakaoTheme.colors.highlightPrimaryBlue,
            style = KakaoTheme.typography.bodyB16
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun FinancialOverviewAssetsRowPreview() {
    KakaoPayTheme {
        FinancialOverviewAssetsRow(
            account = "카카오뱅크",
            onClick = {},
            icon = R.drawable.img_kakaopay_logo,
        )
    }
}

@Preview
@Composable
private fun FinancialAssetsCardPreview() {
    KakaoPayTheme {

        FinancialAssetsCard(
            financialItems = persistentListOf(
                FinancialList(
                    icon = R.drawable.img_kakaopay_logo, account = "카카오뱅크"
                ), FinancialList(
                    icon = R.drawable.img_toss_logo, account = "토스뱅크"
                ), FinancialList(
                    icon = R.drawable.img_dgbank_logo, account = "대구은행"
                )
            ), onViewSpendingHistoryClick = {})
    }
}
