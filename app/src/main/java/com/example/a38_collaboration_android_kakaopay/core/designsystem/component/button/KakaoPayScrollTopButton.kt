package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import kotlinx.coroutines.launch

@Composable
fun KakaoPayScrollTopButton(
    listState: LazyListState,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(KakaoTheme.colors.white, CircleShape)
                .border(1.dp, KakaoTheme.colors.grey200, CircleShape)
                .noRippleClickable {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_chevron_up_grey500_24px),
                contentDescription = "Scroll to Top",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun KakaoPayScrollTopTestPreview() {
    KakaoPayTheme {
        val listState = rememberLazyListState()

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(state = listState) {
                items(100) { index ->
                    Text(
                        text = "카카오페이 항목 $index",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        style = KakaoTheme.typography.bodyM16
                    )
                }
            }

            KakaoPayScrollTopButton(listState = listState)
        }
    }
}