package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayOutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(999.dp))
            .background(color = KakaoTheme.colors.white)
            .border(
                border = BorderStroke(
                    width = 1.dp, color = KakaoTheme.colors.grey200
                ),
                shape = RoundedCornerShape(999.dp),
            )
            .noRippleClickable(onClick)
            .padding(horizontal = 10.dp, vertical = 12.dp),

        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyB16
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun KakaoPayOutlineButtonPreview() {
    KakaoPayTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            KakaoPayOutlineButton(
                text = "거래확인증",
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )

            KakaoPayOutlineButton(
                text = "1/N 정산하기",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            KakaoPayOutlineButton(
                text = "분할결제",
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
        }

    }

}
