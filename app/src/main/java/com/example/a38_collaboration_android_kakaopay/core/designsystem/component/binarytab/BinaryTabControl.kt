package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.binarytab

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun BinaryTabControl() {
    var selectedTab by remember { mutableStateOf("내역") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            BinaryTabItem(
                text = "내역",
                isSelected = selectedTab == "내역",
                onClick = { selectedTab = "내역" },
                modifier = Modifier.weight(1f)
            )

            BinaryTabItem(
                text = "카드만들기",
                isSelected = selectedTab == "카드만들기",
                onClick = { selectedTab = "카드만들기" },
                modifier = Modifier.weight(1f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
        ) {
            val indicatorOffset by animateDpAsState(
                targetValue = if (selectedTab == "내역") {
                    0.dp
                } else {
                    (LocalConfiguration.current.screenWidthDp / 2).dp
                },
                label = "lineAnimation"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .offset(x = indicatorOffset)
                    .background(KakaoTheme.colors.black)
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun BinaryTabControlPreview() {
    BinaryTabControl()
}