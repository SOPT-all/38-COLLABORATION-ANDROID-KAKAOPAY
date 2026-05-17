package com.example.a38_collaboration_android_kakaopay.presentation.edgecase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCase
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCaseType
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.colors

@Composable
fun EdgeCaseScreen(
    type: EdgeCaseType,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(3f))

        EdgeCase(type = type)

        Spacer(modifier = Modifier.weight(4f))
    }
}

@Preview
@Composable
private fun EdgeCaseScreenPreview() {
    KakaoPayTheme {
        EdgeCaseScreen(
            type = EdgeCaseType.Empty
        )
    }
}