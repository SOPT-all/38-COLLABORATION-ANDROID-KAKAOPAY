package com.example.a38_collaboration_android_kakaopay.core.common.extension


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit,
): Modifier = composed {

    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

inline fun Modifier.noRippleClickableWithPressedColor(
    pressedColor: Color? = null,
    enabled : Boolean = true,
    crossinline onClick: () -> Unit,
): Modifier = composed {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressedColor = pressedColor ?: KakaoTheme.colors.buttonSecondaryPressed

    this
        .then(
            if (isPressed) {
                Modifier.background(color = pressedColor)
            } else {
                Modifier
            }
        )
        .clickable(
            indication = null,
            interactionSource = interactionSource,
            enabled = enabled
        ) {
            onClick()
        }
}
