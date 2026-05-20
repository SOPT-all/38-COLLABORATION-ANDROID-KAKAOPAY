package com.example.a38_collaboration_android_kakaopay.presentation.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.util.KakaoPullToIndicator
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.KakaoPaySegmentControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.SegmentTab
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SpendingAnaysisyLoadingScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    var currentTab by remember { mutableStateOf(SegmentTab.SUMMARY) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
            .padding(horizontal = 16.dp)
    ) {
        KakaoPaySubTopBar(
            title = {
                Text(
                    text = "소비분석",
                    style = KakaoTheme.typography.bodyM16,
                    color = KakaoTheme.colors.black
                )
            },
            onBackClick = {},
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        KakaoPaySegmentControl(
            selectedTab = currentTab,
            onTabSelected = { selected ->
                currentTab = selected
            },
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(2.dp))

            Box(
                modifier = Modifier.size(36.dp),
                contentAlignment = Alignment.Center
            ) {
                KakaoPullToIndicator(
                    isRefreshing = true,
                    onRefresh = {}
                ) {
                    Box(modifier = Modifier.size(36.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingAnaysisyLoadingScreenPreview() {
    KakaoPayTheme {
        SpendingAnaysisyLoadingScreen(paddingValues = PaddingValues())
    }
}
