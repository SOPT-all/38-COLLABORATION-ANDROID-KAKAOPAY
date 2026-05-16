package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme

@Composable
fun KakaoPayTopBar(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_top_bar_kakaopay_lg),
                contentDescription = null,
                modifier = Modifier.height(24.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_search_24px),
                    contentDescription = null,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_notification_24px),
                    contentDescription = null,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_hamburger_24px),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPayTopBarPreview() {
    KakaoPayTheme {
        KakaoPayTopBar()
    }
}