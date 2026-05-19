package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.extension.noRippleClickableWithPressedColor
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import kotlin.math.abs

@Composable
fun ActionItemsGroup(
    expenseDiff: Int,
    fixedExpense: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(14.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(KakaoTheme.colors.grey100),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        ActionList(
            icon = R.drawable.ic_graphic_analysis_24px,
            onClick = {},
            content = {
                CategoryAnalysis(
                    expenseDiff = expenseDiff
                )
            }
        )

        ActionList(
            icon = R.drawable.ic_graphic_fixed_expense_24px,
            onClick = {},
            content = {
                FixedExpense(
                    fixedExpense = fixedExpense
                )
            }
        )
    }
}

@Composable
private fun ActionList(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .noRippleClickableWithPressedColor(
                pressedColor = KakaoTheme.colors.buttonSecondaryPressed,
                onClick = onClick
            )
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = Color.Unspecified
            )

            content()
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right_blue_16px),
            contentDescription = null,
            tint = KakaoTheme.colors.grey400
        )
    }
}

@Composable
private fun CategoryAnalysis(
    expenseDiff: Int,
    modifier: Modifier = Modifier,
) {
    val statusText = stringResource(
        if (expenseDiff > 0) R.string.spending_overview_expense_diff_more else R.string.spending_overview_expense_diff_less
    )

    val statusColor =
        if (expenseDiff > 0) KakaoTheme.colors.highlightPrimaryRed else KakaoTheme.colors.highlightPrimaryBlue

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.spending_overview_category_analysis_prefix))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(stringResource(R.string.spending_overview_category_analysis_suffix))
                }
            },
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.bodyR14
        )

        Text(
            text = stringResource(
                R.string.spending_overview_expense_diff,
                abs(expenseDiff) / 10000,
                statusText
            ),
            color = statusColor,
            style = KakaoTheme.typography.labelR12
        )
    }
}

@Composable
private fun FixedExpense(
    fixedExpense: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(R.string.spending_overview_fixed_expense_prefix))
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(fixedExpense.toWonFormat())
                append(stringResource(R.string.spending_overview_fixed_expense_suffix))
            }
        },
        color = KakaoTheme.colors.black,
        style = KakaoTheme.typography.bodyR14
    )
}


@Preview(showBackground = true)
@Composable
private fun ActionItemsGroupPreview() {
    KakaoPayTheme {
        ActionItemsGroup(
            expenseDiff = -35000,
            fixedExpense = 15000
        )
    }
}