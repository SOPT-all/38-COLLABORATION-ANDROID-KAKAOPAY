package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
            val navItems = remember {
                listOf(
                    NavigationItem(R.string.nav_home, R.drawable.ic_bottom_bar_home_default_24px, R.drawable.ic_bottom_bar_home_pressed_24px),
                    NavigationItem(R.string.nav_benefits, R.drawable.ic_bottom_bar_giftbox_default_24px, R.drawable.ic_bottom_bar_giftbox_pressed_24px),
                    NavigationItem(R.string.nav_payment, R.drawable.ic_bottom_bar_payment_default_24px, R.drawable.ic_bottom_bar_payment_pressed_24px),
                    NavigationItem(R.string.nav_assets, R.drawable.ic_bottom_bar_asset_default_24px, R.drawable.ic_bottom_bar_asset_pressed_24px),
                    NavigationItem(R.string.nav_stock, R.drawable.ic_bottom_bar_securities_default_24px, R.drawable.ic_bottom_bar_securities_pressed_24px)
                )
            }

            navItems.forEachIndexed { index, item ->
                val isSelected = selectedTab == index
                val label = stringResource(id = item.labelRes)

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            onTabSelected(index)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = if (isSelected) item.pressedIconRes else item.defaultIconRes),
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
private fun KakaoPayBottomNavigationPreview() {
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