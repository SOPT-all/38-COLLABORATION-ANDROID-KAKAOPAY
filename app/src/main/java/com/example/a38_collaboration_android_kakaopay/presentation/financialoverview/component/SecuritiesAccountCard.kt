package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPaySecondaryButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SecuritiesAccountCard(
    money: Long,
    modifier: Modifier = Modifier,
) {
    KakaoPayBasicCard(
        modifier = modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            KakaoPayMoney(
                money = money,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp)
            )

            KakaoPaySecondaryButton(
                text = stringResource(R.string.financial_securities_account_send),
                onClick = {}
            )
        }
    }
}

@Composable
private fun KakaoPayMoney(
    money: Long,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Icon(
            painter = painterResource(R.drawable.logo_kakaopay_sm),
            contentDescription = null,
        )

        Text(
            text = stringResource(R.string.financial_securities_account_certificate),
            modifier = Modifier.padding(end = 6.dp),
            color = KakaoTheme.colors.grey600,
            style = KakaoTheme.typography.labelR10,
        )

        Text(
            text = money.toWonFormat(),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyB16
        )
    }
}

@Preview
@Composable
private fun SecuritiesAccountCardPreview() {
    KakaoPayTheme {
        SecuritiesAccountCard(
            modifier = Modifier.width(328.dp),
            money = 12300L
        )
    }
}
