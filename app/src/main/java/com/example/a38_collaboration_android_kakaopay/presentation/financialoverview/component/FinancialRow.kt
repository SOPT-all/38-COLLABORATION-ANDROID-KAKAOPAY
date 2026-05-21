package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme


@Composable
fun FinancialOverviewRow(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    useCompactIconSize: Boolean = false,
    contentSpacing: Dp = 4.dp,
    trailingContent: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .then(
                    if (useCompactIconSize) {
                        Modifier
                            .size(30.dp)
                            .clip(RoundedCornerShape(12.dp))
                    } else {
                        Modifier.size(32.dp)
                    }
                )
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(contentSpacing),
            content = content
        )

        trailingContent?.invoke(this)
    }
}

@Composable
fun FinancialMenuRow(
    financialMenus: List<Int>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = KakaoTheme.typography.bodyB14,
) {
    val horizontalPadding = if (textStyle == KakaoTheme.typography.bodyB14) {
        6.dp
    } else {
        4.dp
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        financialMenus.forEachIndexed { index, textRes ->
            Text(
                text = stringResource(textRes),
                modifier = Modifier
                    .padding(horizontal = horizontalPadding, vertical = 10.dp),
                color = KakaoTheme.colors.grey500,
                style = textStyle
            )

            if (index != financialMenus.lastIndex) {
                Text(
                    text = stringResource(R.string.word_divider),
                    color = KakaoTheme.colors.grey200,
                    style = KakaoTheme.typography.labelR12
                )
            }
        }
    }
}
