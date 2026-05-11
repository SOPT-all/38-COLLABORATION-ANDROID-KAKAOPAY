package com.example.a38_collaboration_android_kakaopay.core.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Grey100 = Color(0xFFF8F9FB)
val Grey200 = Color(0xFFE9E9EA)
val Grey300 = Color(0xFFBABBBD)
val Grey400 = Color(0xFF969A9C)
val Grey500 = Color(0xFF73767B)
val Grey600 = Color(0xFF474A50)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF060B11)

val KakaoYellow = Color(0xFFFFEB00)
val KakaoYellowActive = Color(0xFFFFDB00)
val KakaoBlue = Color(0xFF008DFF)
val KakaoRed = Color(0xFFFF112D)

val BrandPrimary = KakaoYellow
val ActionPrimary =  KakaoBlue
val HighlightPrimary = KakaoRed
val HighlightPrimaryGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFF0075FF), // 0%
        Color(0xFF8A76ED)  // 100%
    )
)
val HighlightSecondary = Color(0xFFCED4DB)

val FeedbackPositive = KakaoBlue
val FeedbackNegative = KakaoRed

val BackgroundDefault = Color(0xFFF3F4F6)
val BackgroundSubtle = Color(0xFFE8ECEE)

val ButtonPrimaryPressed = Color(0xFFE1E1E1)
val ButtonSecondaryPressed = Color(0xFFF0F0F0)
val ButtonInlineDefault = Color(0xFFE1E1E1)
val ButtonInlinePressed = Color(0xFFDADEE1)

val SegmentSelected = Color(0xFF444B53)
val ToggleActive = KakaoYellowActive
val ToggleInactive = Color(0xFFDDE2E8)
