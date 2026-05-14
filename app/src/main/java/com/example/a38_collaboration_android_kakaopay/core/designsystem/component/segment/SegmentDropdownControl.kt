package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.colors
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.typography

@Composable
fun SegmentDropdownControl(
    isExpanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = if (isExpanded) R.string.segment_dropdown_control_close else R.string.segment_dropdown_control_detail
    val icon =
        if (isExpanded) R.drawable.ic_chevron_up_grey500_16px else R.drawable.ic_chevron_down_grey500_16px

    Row(
        modifier = modifier
            .noRippleClickable(onClick)
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = stringResource(text),
            color = colors.grey500,
            style = typography.bodyR14,
        )
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SegmentDropdownControlPreview() {
    KakaoPayTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SegmentDropdownControl(
                isExpanded = false,
                onClick = {}
            )
            SegmentDropdownControl(
                isExpanded = true,
                onClick = {}
            )
        }
    }
}