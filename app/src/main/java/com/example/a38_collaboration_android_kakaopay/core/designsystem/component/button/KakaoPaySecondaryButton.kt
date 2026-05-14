package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun KakaoPaySecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .background(KakaoTheme.colors.backgroundSubtleGrey)
            .noRippleClickableWithPressedColor(
                pressedColor = KakaoTheme.colors.buttonInlinePressed,
                onClick = onClick
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyR14,
            textAlign = TextAlign.Center
        )
    }

}

@Preview
@Composable
private fun KakaoPaySecondaryButtonPreview() {
    KakaoPayTheme {
        Column {
            Row(
                modifier = Modifier.padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KakaoPaySecondaryButton(
                    text = "내역 보기",
                    onClick = {},
                )

                KakaoPaySecondaryButton(
                    text = "점수 올리기",
                    onClick = {},
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                KakaoPaySecondaryButton(
                    text = "송금",
                    onClick = {},
                )

                KakaoPaySecondaryButton(
                    text = "3월 내역 더보기",
                    onClick = {},
                )
            }
        }

    }

}
