package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.colors
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.typography

@Composable
fun EdgeCase(
    type: EdgeCaseType,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Image(
            painter = painterResource(type.icon),
            contentDescription = null,
            modifier = Modifier.size(64.dp),
        )
        Text(
            text = stringResource(type.text),
            color = colors.black,
            style = typography.titleB20,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EdgeCasePreview() {
    KakaoPayTheme {
        EdgeCase(
            type = EdgeCaseType.General
        )
    }
}