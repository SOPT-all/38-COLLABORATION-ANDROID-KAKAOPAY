package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayBottomNavigation(
    modifier: Modifier = Modifier,
    selectedTab: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(53.dp),
        shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp),
        color = KakaoTheme.colors.white
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val navItems = listOf(
                Triple("홈", R.drawable.ic_bottom_bar_home_default_24px, R.drawable.ic_bottom_bar_home_pressed_24px),
                Triple("혜택", R.drawable.ic_bottom_bar_giftbox_default_24px, R.drawable.ic_bottom_bar_giftbox_pressed_24px),
                Triple("결제", R.drawable.ic_bottom_bar_payment_default_24px, R.drawable.ic_bottom_bar_payment_pressed_24px),
                Triple("자산", R.drawable.ic_bottom_bar_asset_default_24px, R.drawable.ic_bottom_bar_asset_pressed_24px),
                Triple("증권", R.drawable.ic_bottom_bar_securities_default_24px, R.drawable.ic_bottom_bar_securities_pressed_24px)
            )

            navItems.forEachIndexed { index, (label, defaultIcon, pressedIcon) ->
                val isSelected = selectedTab == index

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                        ) {
                            onTabSelected(index)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = if (isSelected) pressedIcon else defaultIcon),
                        contentDescription = label,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                    Text(
                        text = label,
                        style = if (isSelected) KakaoTheme.typography.labelB12 else KakaoTheme.typography.labelR12,
                        color = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.grey500
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KakaoPayBottomNavigationPreview() {
    KakaoPayTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(KakaoTheme.colors.backgroundDefaultGrey),
            contentAlignment = Alignment.BottomCenter
        ) {
            KakaoPayBottomNavigation(selectedTab = 3)
        }
    }
}