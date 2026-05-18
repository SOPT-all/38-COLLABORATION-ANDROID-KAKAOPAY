package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.othercomponents

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun BinaryTabControl(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(BinaryTabType.HISTORY) }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            BinaryTabType.entries.forEach { tab ->
                        BinaryTabItem(
                            text = stringResource(tab.text),
                            isSelected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            modifier = Modifier.weight(1f)
                        )
            }
        }

        BoxWithConstraints(
            modifier = modifier
                .fillMaxWidth()
        ) {
            val tabWidth = maxWidth/2

            val indicatorOffset by animateDpAsState(
                targetValue = if (selectedTab == BinaryTabType.HISTORY) {
                    0.dp
                } else {
                    tabWidth
                }
            )
            Box(
                modifier = modifier
                    .offset(x = indicatorOffset)
                    .background(KakaoTheme.colors.grey200)
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun BinaryTabControlPreview() {

    KakaoPayTheme {
        BinaryTabControl()
    }
}