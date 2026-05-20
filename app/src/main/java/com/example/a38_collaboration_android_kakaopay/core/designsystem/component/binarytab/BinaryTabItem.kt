package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.binarytab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun BinaryTabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val strokeColor = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.grey200
    val strokeWidth = if (isSelected) 2.dp else 1.dp

    Box(
        modifier = modifier
            .drawBehind {
                val strokeWidth = strokeWidth.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = strokeColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
            .padding(
                vertical = 6.dp,
                horizontal = 2.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .noRippleClickableWithPressedColor(
                pressedColor = KakaoTheme.colors.buttonSecondaryPressed,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.titleM18
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun BinaryTabItemPreview() {
    BinaryTabItem(
        text = "내역",
        isSelected = true,
        onClick = {}
    )
}