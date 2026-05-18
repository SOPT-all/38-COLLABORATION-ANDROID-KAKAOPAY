package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.binarytab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun BinaryTabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .noRippleClickable(onClick)
            .padding(
                vertical = 6.dp,
                horizontal = 4.dp
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