package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPaySecondaryButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun CreditScoreCard(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
) {
    KakaoPayBasicCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            FinancialOverviewRow(
                icon = iconRes,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                trailingContent = {
                    KakaoPaySecondaryButton(
                        text = stringResource(R.string.financial_credit_score_raise),
                        onClick = {}
                    )
                }
            ) {
                Text(
                    text = stringResource(R.string.financial_credit_score),
                    color = KakaoTheme.colors.grey500,
                    style = KakaoTheme.typography.bodyR14
                )

                Text(
                    text = stringResource(R.string.financial_credit_score_check),
                    color = KakaoTheme.colors.highlightPrimaryBlue,
                    style = KakaoTheme.typography.bodyB16
                )
            }

            HorizontalDivider(
                thickness = 1.dp,
                color = KakaoTheme.colors.grey200
            )

            FinancialMenuRow(
                financialMenus = listOf(
                    R.string.financial_my_loan,
                    R.string.financial_loan_apply,
                    R.string.financial_card_issue,
                ),
                textStyle = KakaoTheme.typography.bodyB16
            )
        }
    }
}


@Preview
@Composable
private fun CreditScoreCardPreview() {
    KakaoPayTheme {
        CreditScoreCard(
            iconRes = R.drawable.img_credit_icon_32px
        )
    }
}

