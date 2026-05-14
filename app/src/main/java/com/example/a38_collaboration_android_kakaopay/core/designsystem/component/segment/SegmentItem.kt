package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.colors
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.typography

@Composable
fun SegmentItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (isSelected) colors.segmentBackgroundSelected else colors.white
    val borderColor = if (isSelected) Color.Transparent else colors.grey200
    val textColor = if (isSelected) colors.white else colors.grey500
    val textStyle = if (isSelected) typography.bodyB14 else typography.bodyR14

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(6.dp),
            )
            .noRippleClickable(onClick)
            .padding(
                vertical = 6.dp,
                horizontal = 12.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            modifier = Modifier,
            color = textColor,
            style = textStyle,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SegmentItemPreview() {
    KakaoPayTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            SegmentItem(
                text = "전체",
                isSelected = true,
                onClick = {},
            )
            SegmentItem(
                text = "전체",
                isSelected = false,
                onClick = {}
            )
        }
    }
}