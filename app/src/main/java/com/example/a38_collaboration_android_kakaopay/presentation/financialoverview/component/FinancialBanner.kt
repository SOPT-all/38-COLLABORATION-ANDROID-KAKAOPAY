package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component


import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
        modifier = modifier,

        ) {

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
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
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
//        FinancialBanner()
        CtaInlineButton()
    }
}
