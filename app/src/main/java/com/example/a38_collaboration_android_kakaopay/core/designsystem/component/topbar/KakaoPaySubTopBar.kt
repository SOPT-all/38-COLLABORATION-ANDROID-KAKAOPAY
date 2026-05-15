package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPaySubTopBar(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = KakaoTheme.colors.white
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // 뒤로가기 버튼
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_arrow_left_24px),
                    contentDescription = "뒤로가기",
                    tint = KakaoTheme.colors.black,
                    modifier = Modifier.size(24.dp)
                )
            }

            // 제목 영역
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                title()
            }

            IconButton(
                onClick = onHomeClick,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_top_bar_home_24px),
                    contentDescription = "홈",
                    tint = KakaoTheme.colors.black,
                    modifier = Modifier.size(24.dp)
                )
            }
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
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            onBackClick = {},
            onHomeClick = {}
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
            onHomeClick = {}
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
            onHomeClick = {}
        )
    }
}