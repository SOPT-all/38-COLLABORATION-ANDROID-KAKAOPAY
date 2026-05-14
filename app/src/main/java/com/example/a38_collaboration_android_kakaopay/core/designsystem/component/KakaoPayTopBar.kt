package com.example.a38_collaboration_android_kakaopay.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp), // 상단바 전체 높이 48dp
        color = KakaoTheme.colors.white
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 1. 로고 영역 (왼쪽 패딩 16dp 적용)
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(80.dp)
                    .height(48.dp)
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logo_top_bar_kakaopay_lg),
                    contentDescription = "로고",
                    tint = Color.Unspecified,
                    modifier = Modifier.height(24.dp)
                )
            }

            // 2. 오른쪽 아이콘 영역 (아이콘끼리 간격 없이 48dp씩 차지)
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 검색 아이콘 버튼
                IconButton(
                    onClick = onSearchClick,
                    modifier = Modifier.size(48.dp) // 전체 영역 48x48 (12+24+12)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_top_bar_search_24px),
                        contentDescription = "검색",
                        tint = KakaoTheme.colors.black,
                        modifier = Modifier.size(24.dp) // 실제 아이콘 크기 24x24
                    )
                }

                // 알림 아이콘 버튼
                IconButton(
                    onClick = onNotificationClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_top_bar_notification_24px),
                        contentDescription = "알림",
                        tint = KakaoTheme.colors.black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // 메뉴 아이콘 버튼
                IconButton(
                    onClick = onMenuClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_top_bar_hamburger_24px),
                        contentDescription = "메뉴",
                        tint = KakaoTheme.colors.black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // 마지막 오른쪽 여백 4dp 처리 (피그마 수치 반영)
                Box(modifier = Modifier.width(4.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun KakaoPayTopBarPreview() {
    KakaoPayTheme {
        KakaoPayTopBar()
    }
}