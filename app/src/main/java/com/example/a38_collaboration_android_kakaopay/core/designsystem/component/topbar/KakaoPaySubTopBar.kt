package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPaySubTopBar(
    onBackClick: () -> Unit,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(KakaoTheme.colors.white)
            .height(48.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_arrow_left_24px),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable { onBackClick() }
            )

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                title()
            }

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_home_24px),
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPaySubTopBarTypeAPreview() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = {
                Text(
                    text = "상세내역",
                    style = KakaoTheme.typography.bodyB16,
                    color = KakaoTheme.colors.black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                )
            },
            onBackClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPaySubTopBarTypeBPreview() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = {
                Text(
                    text = "소비분석",
                    style = KakaoTheme.typography.bodyM16,
                    color = KakaoTheme.colors.black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            onBackClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPaySubTopBarTypeCPreview() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = {},
            onBackClick = {},
        )
    }
}
