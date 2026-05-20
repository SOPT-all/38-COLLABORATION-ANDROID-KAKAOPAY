package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SpendingDetailsLoadingScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
            .padding(horizontal = 16.dp)
    ) {
        KakaoPaySubTopBar(
            onBackClick = {},
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .background(KakaoTheme.colors.white),
            title = {
                Text(
                    text = "상세내역",
                    style = KakaoTheme.typography.bodyB16,
                    color = KakaoTheme.colors.black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailsLoadingScreenPreview() {
    KakaoPayTheme {
        SpendingDetailsLoadingScreen(paddingValues = PaddingValues())
    }
}