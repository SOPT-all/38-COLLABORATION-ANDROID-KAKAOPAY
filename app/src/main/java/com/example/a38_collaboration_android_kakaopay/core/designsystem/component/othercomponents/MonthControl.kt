package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.othercomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun MonthControl(
    modifier: Modifier = Modifier
) {
    var selectedMonth by remember { mutableStateOf("4월") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .height(30.dp)
            .width(121.dp)
    ) {
        IconButton(
            onClick = { if (selectedMonth == "4월") selectedMonth = "5월" },
            enabled = (selectedMonth == "5월")
        ) {
            Icon(
                painter = if (selectedMonth == "4월") {
                    painterResource(id = R.drawable.ic_chevron_left_grey300_24px)
                } else {
                    painterResource(id = R.drawable.ic_chevron_left_black_24px)
                },
                contentDescription = "4월"
            )

        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "${selectedMonth}월",
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.titleB20
        )

        Spacer(modifier = Modifier.width(3.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_caret_down_16px),
            contentDescription = "드롭다운 아이콘"
        )

        Spacer(modifier = Modifier.width(12.dp))

        IconButton(
            onClick = { if (selectedMonth == "5월") selectedMonth = "4월" },
            enabled = (selectedMonth == "4월")
        ) {
            Icon(
                painter = if (selectedMonth == "5월") {
                    painterResource(id = R.drawable.ic_chevron_right_grey300_24px)
                } else {
                    painterResource(id = R.drawable.ic_chevron_right_black_24px)
                },
                contentDescription = "5월"
            )
        }
    }
}

@Preview
@Composable
fun MonthControlPreview(){
    MonthControl()
}