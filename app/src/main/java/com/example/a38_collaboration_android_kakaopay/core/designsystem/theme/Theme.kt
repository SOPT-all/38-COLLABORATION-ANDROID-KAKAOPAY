package com.example.a38_collaboration_android_kakaopay.core.designsystem.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle

data class KakaoColors(
    val grey100: Color, val grey200: Color, val grey300: Color,
    val grey400: Color, val grey500: Color, val grey600: Color,
    val white: Color, val black: Color, val brandPrimary: Color,
    val actionPrimary: Color, val highlightPrimary: Color,
    val highlightPrimaryGradient: Brush, val highlightSecondary: Color,
    val feedbackPositive: Color, val feedbackNegative: Color,
    val backgroundDefault: Color, val backgroundSubtle: Color,
    val buttonPrimaryPressed: Color, val buttonSecondaryPressed: Color,
    val buttonInlineDefault: Color, val buttonInlinePressed: Color,
    val segmentSelected: Color, val toggleActive: Color, val toggleInactive: Color
)

data class KakaoTypography(
    val titleB26: TextStyle, val titleB24: TextStyle, val titleB20: TextStyle,
    val titleB18: TextStyle, val titleM18: TextStyle, val bodyB16: TextStyle,
    val bodyM16: TextStyle, val bodyB14: TextStyle, val bodyM14: TextStyle,
    val bodyR14: TextStyle, val labelB12: TextStyle, val labelM12: TextStyle,
    val labelR12: TextStyle, val labelR10: TextStyle
)

private val defaultKakaoColors = KakaoColors(
    grey100 = Grey100, grey200 = Grey200, grey300 = Grey300,
    grey400 = Grey400, grey500 = Grey500, grey600 = Grey600,
    white = White, black = Black, brandPrimary = BrandPrimary,
    actionPrimary = ActionPrimary, highlightPrimary = HighlightPrimary,
    highlightPrimaryGradient = HighlightPrimaryGradient,
    highlightSecondary = HighlightSecondary, feedbackPositive = FeedbackPositive,
    feedbackNegative = FeedbackNegative, backgroundDefault = BackgroundDefault,
    backgroundSubtle = BackgroundSubtle, buttonPrimaryPressed = ButtonPrimaryPressed,
    buttonSecondaryPressed = ButtonSecondaryPressed, buttonInlineDefault = ButtonInlineDefault,
    buttonInlinePressed = ButtonInlinePressed, segmentSelected = SegmentSelected,
    toggleActive = ToggleActive, toggleInactive = ToggleInactive
)

private val defaultKakaoTypography = KakaoTypography(
    titleB26 = TitleB26, titleB24 = TitleB24, titleB20 = TitleB20,
    titleB18 = TitleB18, titleM18 = TitleM18,
    bodyB16 = BodyB16, bodyM16 = BodyM16,
    bodyB14 = BodyB14, bodyM14 = BodyM14, bodyR14 = BodyR14,
    labelB12 = LabelB12, labelM12 = LabelM12, labelR12 = LabelR12,
    labelR10 = LabelR10
)

private val LocalKakaoColors = staticCompositionLocalOf { defaultKakaoColors }
private val LocalKakaoTypography = staticCompositionLocalOf { defaultKakaoTypography }

object KakaoTheme {
    val colors: KakaoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoColors.current

    val typography: KakaoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoTypography.current
}

@Composable
fun _38COLLABORATIONANDROIDKAKAOPAYTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalKakaoColors provides defaultKakaoColors,
        LocalKakaoTypography provides defaultKakaoTypography
    ) {
        content()
    }
}
