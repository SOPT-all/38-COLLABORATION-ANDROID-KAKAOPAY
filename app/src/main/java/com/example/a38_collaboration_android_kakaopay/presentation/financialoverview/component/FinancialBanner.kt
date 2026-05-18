package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun FinancialBanner(
    modifier: Modifier = Modifier,
) {
    KakaoPayBasicCard(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(44.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            FinancialSubTitleGroup()

            Image(
                painter = painterResource(R.drawable.img_3d_03),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
private fun FinancialSubTitleGroup(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            text = stringResource( R.string.financial_banner_subtitle),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyR14
        )

        Text(
            text = stringResource(R.string.financial_banner_title),
            modifier = Modifier.padding(bottom = 14.dp),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.titleB18
        )

        CtaInlineButton()
    }
}

@Composable
private fun CtaInlineButton(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .background(KakaoTheme.colors.brandPrimaryYellow)
            .padding(horizontal = 12.dp, vertical = 6.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.cta_inline_button),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyB14
        )
    }
}

@Preview
@Composable
private fun FinancialBannerPreview() {
    KakaoPayTheme {
        FinancialBanner()
    }
}
