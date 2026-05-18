package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


enum class Month(val value: Int) {
    APRIL(4),
    MAY(5),
}

@Composable
fun MonthControl(
    modifier: Modifier = Modifier,
) {
    var selectedMonth by remember { mutableStateOf(Month.APRIL) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){

        MonthArrow(
            iconResId = R.drawable.ic_chevron_left_black_24px,
            isEnabled = selectedMonth == Month.MAY,
            modifier = Modifier.noRippleClickable {
                if (selectedMonth == Month.MAY) selectedMonth = Month.APRIL
            }
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "${selectedMonth.value}월",
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.titleB20
        )

        Spacer(modifier = Modifier.width(3.dp))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_caret_down_16px),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(12.dp))

        MonthArrow(
            iconResId = R.drawable.ic_chevron_right_black_24px,
            isEnabled = selectedMonth == Month.APRIL,
            modifier = Modifier.noRippleClickable {
                if (selectedMonth == Month.APRIL) selectedMonth = Month.MAY
            }
        )



        }

    }

@Composable
private fun MonthArrow(
    iconResId: Int,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
){
    Icon(
        imageVector = ImageVector.vectorResource(id = iconResId),
        contentDescription = null,
        tint = if (isEnabled) KakaoTheme.colors.black else KakaoTheme.colors.grey300,
        modifier = modifier,
    )
}


@Preview
@Composable
private fun MonthControlPreview() {
    KakaoPayTheme {
        MonthControl()
    }
}