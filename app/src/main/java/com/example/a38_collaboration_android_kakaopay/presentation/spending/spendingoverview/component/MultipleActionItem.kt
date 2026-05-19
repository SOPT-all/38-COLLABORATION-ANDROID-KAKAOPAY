package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun MultipleActionItem(
    totalExpense: Int,
    totalIncome: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(KakaoTheme.colors.grey100)
            .padding(
                horizontal = 14.dp,
                vertical = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CashFlowItem(
            label = R.string.spending_overview_total_expense,
            amount = totalExpense,
            onClick = {},
        )

        CashFlowItem(
            label = R.string.spending_overview_total_income,
            amount = totalIncome,
            onClick = {},
        )
    }
}

@Composable
private fun CashFlowItem(
    @StringRes label: Int,
    amount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .noRippleClickableWithPressedColor(
                pressedColor = KakaoTheme.colors.buttonSecondaryPressed,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(label),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyR14
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = amount.toWonFormat(),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyB14
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right_grey300_16px),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun MultipleActionItemPreview() {
    KakaoPayTheme {
        MultipleActionItem(
            totalExpense = 79650,
            totalIncome = 150000,
        )
    }
}