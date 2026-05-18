package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.selection

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayToggle(
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean = true
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (checked) KakaoTheme.colors.toggleActive else KakaoTheme.colors.toggleInactive,
    )

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) 17.dp else 0.dp,
    )

    // 토글 트랙
    Box(
        modifier = modifier
            .width(48.dp)
            .height(31.dp)
            .background(backgroundColor, RoundedCornerShape(99.dp))
            .noRippleClickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.CenterStart
    ) {
        // 토글 핸들
        Box(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .offset(x = thumbOffset)
                .size(27.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = CircleShape,
                    clip = false
                )
                .background(KakaoTheme.colors.white, CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPayTogglePreview() {
    KakaoPayTheme {
        val isChecked = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            KakaoPayToggle(
                checked = isChecked.value,
                onCheckedChange = { newValue ->
                    isChecked.value = newValue
                }
            )

        }
    }
}