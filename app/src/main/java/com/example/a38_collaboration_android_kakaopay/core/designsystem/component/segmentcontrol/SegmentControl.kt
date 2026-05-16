package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun KakaoPaySegmentControl(
    selectedTab: SegmentTab,
    onTabSelected: (SegmentTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(KakaoTheme.colors.backgroundSubtleGrey)
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        SegmentTab.entries.forEach { tab ->
            KakaoPaySegmentItem(
                tab = tab,
                isSelected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun KakaoPaySegmentItem(
    tab: SegmentTab,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val textColor = if (isSelected) KakaoTheme.colors.black else KakaoTheme.colors.grey500

    val backgroundColor =
        if (isSelected) KakaoTheme.colors.white else KakaoTheme.colors.backgroundSubtleGrey

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tab.label,
            modifier = Modifier.padding(vertical = 8.dp),
            color = textColor,
            style = KakaoTheme.typography.labelM12
        )
    }
}

enum class SegmentTab(
    val label: String,
) {
    SUMMARY("요약"),
    EXPENSE_PREVIEW("지출 엿보기"),
}

@Preview
@Composable
private fun KakaoPaySegmentControlPreview() {
    KakaoPayTheme {
        var selectedTab by remember { mutableStateOf(SegmentTab.EXPENSE_PREVIEW) }
        
        KakaoPaySegmentControl(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}
