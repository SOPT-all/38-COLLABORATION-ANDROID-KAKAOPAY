package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPaySubTopBar(
    title: String = "",
    modifier: Modifier = Modifier,
    showHomeIcon: Boolean = true,
    isCenterTitle: Boolean = false,
    titleStyle: TextStyle = KakaoTheme.typography.bodyB16,
    onBackClick: () -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        color = KakaoTheme.colors.white
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 1. 뒤로가기 버튼
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 4.dp)
                    .size(48.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_top_bar_arrow_left_24px),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "뒤로가기",
                )
            }

            // 2. 제목 영역
            if (title.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.Center)
                        .padding(horizontal = 52.dp),
                    contentAlignment = if (isCenterTitle) Alignment.Center else Alignment.CenterStart
                ) {
                    Text(
                        text = title,
                        style = titleStyle,
                        color = KakaoTheme.colors.black,
                        modifier = if (isCenterTitle) Modifier else Modifier.fillMaxWidth()
                    )
                }
            }

            // 3. 우측 홈 버튼
            if (showHomeIcon) {
                IconButton(
                    onClick = onHomeClick,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                        .size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_top_bar_home_24px),
                        contentDescription = "홈",
                        tint = KakaoTheme.colors.black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypeA() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = "상세내역",
            isCenterTitle = false,
            titleStyle = KakaoTheme.typography.bodyB16
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypeB() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = "소비분석",
            isCenterTitle = true,
            titleStyle = KakaoTheme.typography.bodyM16
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypeC() {
    KakaoPayTheme {
        KakaoPaySubTopBar(title = "", showHomeIcon = true)
    }
}