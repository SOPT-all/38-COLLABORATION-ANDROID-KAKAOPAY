package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.app.navigation.Home
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPayNavigatorBar(
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
    currentRoute: Route? = null,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .background(KakaoTheme.colors.white)
            .navigationBarsPadding(),
        shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp),
        color = KakaoTheme.colors.white
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MainTab.entries.forEach { tab ->
                val isSelected = currentRoute == tab.route

                NavigationItem(
                    tab = tab,
                    isSelected = isSelected,
                    onClick = { onTabSelected(tab) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun KakaoPayNavigatorBarPreview() {
    KakaoPayTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(KakaoTheme.colors.backgroundDefaultGrey),
            contentAlignment = Alignment.BottomCenter
        ) {
            KakaoPayNavigatorBar(
                onTabSelected = { tab -> println("Selected: ${tab.label}") },
                currentRoute = Home,
            )
        }
    }
}
