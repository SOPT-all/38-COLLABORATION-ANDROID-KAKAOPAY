package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Span
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayBasicCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Box(
        modifier
            .clip(RoundedCornerShape(14.dp))
            .background(KakaoTheme.colors.white)
            .then(
                if (enabled && onClick != null) {
                    Modifier.noRippleClickableWithPressedColor {
                        onClick.invoke()
                    }
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    )
    { content() }

}

@Preview
@Composable
private fun KakaoPayBasicCardPreview() {
    KakaoPayTheme {
        KakaoPayBasicCard(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)

            ) {
                Spacer(Modifier.height(20.dp))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24px),
                    contentDescription = null
                )

                Text(
                    text = "자산추가하기",
                    color = KakaoTheme.colors.black,
                    style = KakaoTheme.typography.bodyB16
                )
            }
        }
    }
}
