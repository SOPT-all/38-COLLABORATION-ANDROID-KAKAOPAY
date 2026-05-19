package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SpendingDetailBanner(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(KakaoTheme.colors.grey100)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = stringResource(R.string.spending_detail_ad_title),
                style = KakaoTheme.typography.labelM12,
                color = KakaoTheme.colors.black
            )
            Text(
                text = stringResource(R.string.spending_detail_ad_sub_title),
                style = KakaoTheme.typography.bodyB16,
                color = KakaoTheme.colors.black
            )
        }

        Image(
            painter = painterResource(id = R.drawable.img_3d_04),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailBannerPreview() {
    KakaoPayTheme {
        SpendingDetailBanner(
            modifier = Modifier.padding(16.dp)
        )
    }
}