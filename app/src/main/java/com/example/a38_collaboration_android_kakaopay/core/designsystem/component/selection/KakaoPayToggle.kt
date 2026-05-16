package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.selection

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayToggle(
    modifier: Modifier = Modifier,
    initialChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    val isChecked = remember { mutableStateOf(initialChecked) }

    KakaoPayToggle(
        checked = isChecked.value,
        onCheckedChange = { newValue ->
            isChecked.value = newValue
            onCheckedChange(newValue)
        },
        modifier = modifier
    )
}

@Composable
fun KakaoPayToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (checked) KakaoTheme.colors.toggleActive else KakaoTheme.colors.toggleInactive,
        label = "backgroundColor"
    )

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) 17.dp else 0.dp,
        label = "thumbOffset"
    )

    // 토글 트랙
    Box(
        modifier = modifier
            .width(48.dp)
            .height(31.dp)
            .clip(RoundedCornerShape(99.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
            ) {
                onCheckedChange(!checked)
            },
        contentAlignment = Alignment.CenterStart
    ) {
        // 토글 핸들
        Box(
            modifier = Modifier
                .padding(start = 2.dp)
                .offset(x = thumbOffset)
                .size(27.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = CircleShape,
                    spotColor = KakaoTheme.colors.black.copy(alpha = 0.2f), // #00000033 반영
                    ambientColor = KakaoTheme.colors.black.copy(alpha = 0.2f)
                )
                .clip(CircleShape)
                .background(KakaoTheme.colors.white)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KakaoPayTogglePreview() {
    KakaoPayTheme {
        val testChecked = remember { mutableStateOf(false) }

        Column {
            KakaoPayToggle(
                initialChecked = false,
                onCheckedChange = { isChecked ->
                }
            )
        }
    }
}