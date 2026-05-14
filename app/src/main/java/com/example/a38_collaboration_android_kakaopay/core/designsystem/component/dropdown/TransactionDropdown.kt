package com.example.a38_collaboration_android_kakaopay.core.designsystem.component.dropdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.colors
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme.typography

@Composable
fun TransactionDropdown(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .noRippleClickableWithPressedColor(onClick = onClick)
            .padding(
                vertical = 2.dp,
                horizontal = 6.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ){
        Text(
            text = stringResource(R.string.transaction_dropdown_all),
            color = colors.black,
            style = typography.bodyB16,
            textAlign = TextAlign.Center
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down_black_16px),
            contentDescription = null,
            tint = colors.black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionDropdownPreview() {
    KakaoPayTheme {
        Box(
            modifier = Modifier.padding(20.dp)
        ) {
            TransactionDropdown(
                onClick = {},
            )
        }
    }
}