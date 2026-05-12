package com.example.a38_collaboration_android_kakaopay.core.common.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaoPullToIndicator(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier,
        indicator = {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .dropShadow(
                        shape = CircleShape,
                        shadow = Shadow(
                            radius = 8.dp,
                            offset = DpOffset(x = 0.dp, y = 2.dp)
                        )
                    )
                    .background(
                        color = KakaoTheme.colors.white,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = KakaoTheme.colors.grey600,
                    trackColor = KakaoTheme.colors.grey200,
                    strokeWidth = 2.dp
                )
            }
        }
    ) {
        content()
    }
}

@Preview
@Composable
private fun KakaoPullToRefreshPreview() {
    KakaoPullToIndicator(
        isRefreshing = true,
        onRefresh = {}
    ) {
        Box(modifier = Modifier.size(200.dp))
    }
}
