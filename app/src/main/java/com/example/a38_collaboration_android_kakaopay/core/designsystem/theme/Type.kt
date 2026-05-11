package com.example.a38_collaboration_android_kakaopay.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a38_collaboration_android_kakaopay.R

val NotoSansKR = FontFamily(
    Font(R.font.noto_sans_kr_bold, FontWeight.Bold),
    Font(R.font.noto_sans_kr_medium, FontWeight.Medium),
    Font(R.font.noto_sans_kr_regular, FontWeight.Normal)
)

fun getTextStyle(
    fontWeight: FontWeight,
    fontSize: Int,
    lineHeightPercent: Double = 1.4,
    letterSpacingPercent: Double = -0.01
): TextStyle = TextStyle(
    fontFamily = NotoSansKR,
    fontWeight = fontWeight,
    fontSize = fontSize.sp,
    lineHeight = (fontSize * lineHeightPercent).sp,
    letterSpacing = (fontSize * letterSpacingPercent).sp
)

val TitleB26 = getTextStyle(FontWeight.Bold, 26)
val TitleB24 = getTextStyle(FontWeight.Bold, 24)
val TitleB20 = getTextStyle(FontWeight.Bold, 20)
val TitleB18 = getTextStyle(FontWeight.Bold, 18)
val TitleM18 = getTextStyle(FontWeight.Medium, 18)

val BodyB16 = getTextStyle(FontWeight.Bold, 16)
val BodyM16 = getTextStyle(FontWeight.Medium, 16)
val BodyB14 = getTextStyle(FontWeight.Bold, 14)
val BodyM14 = getTextStyle(FontWeight.Medium, 14)
val BodyR14 = getTextStyle(FontWeight.Normal, 14)

val LabelB12 = getTextStyle(FontWeight.Bold, 12)
val LabelM12 = getTextStyle(FontWeight.Medium, 12)
val LabelR12 = getTextStyle(FontWeight.Normal, 12)
val LabelR10 = getTextStyle(FontWeight.Normal, 10)




