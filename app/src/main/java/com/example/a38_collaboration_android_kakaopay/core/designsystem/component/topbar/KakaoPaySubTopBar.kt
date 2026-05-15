package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPaySubTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    isCenterTitle: Boolean = false,
    titleStyle: TextStyle = KakaoTheme.typography.bodyB16,
    backgroundColor: Color = KakaoTheme.colors.white,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
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
            horizontalArrangement = Arrangement.SpaceBetween
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
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    style = titleStyle,
                    color = KakaoTheme.colors.black,
                    textAlign = if (isCenterTitle) TextAlign.Center else TextAlign.Start, // ✅ 정렬 처리
                    modifier = Modifier
                        .weight(1f) // ✅ Row 내에서 남는 공간을 모두 차지
                        .fillMaxWidth(), // ✅ 텍스트가 차지한 영역 내에서 꽉 채움
                    maxLines = 1
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }

            // 우측 홈 버튼
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
private fun PreviewTypeA() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = "상세내역",
            isCenterTitle = false,
            titleStyle = KakaoTheme.typography.bodyB16,
            onBackClick = {},
            onHomeClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTypeB() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = "소비분석",
            isCenterTitle = true,
            titleStyle = KakaoTheme.typography.bodyM16,
            onBackClick = {},
            onHomeClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTypeC() {
    KakaoPayTheme {
        KakaoPaySubTopBar(
            title = "",
            onBackClick = {},
            onHomeClick = {}
        )
    }
}