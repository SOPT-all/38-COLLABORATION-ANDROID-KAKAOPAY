package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.selection.KakaoPayToggle
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun SpendingDetailInteractionCard(
    splitAmount: Long,
    memo: String,
    isIncludedInTotal: Boolean,
    onToggleChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        InteractionBaseRow(
            title = stringResource(R.string.spending_detail_split_amount)
        ) {
            Text(
                text = splitAmount.toWonFormat(),
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyB16
            )
        }

        InteractionBaseRow(
            title = stringResource(R.string.spending_detail_settlement_info),
            titleContent = {
                Spacer(modifier = Modifier.width(10.dp))
                SettlementBadge()
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_profile_placeholder),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        InteractionBaseRow(
            title = stringResource(R.string.spending_detail_memo)
        ) {
            val memoContent = memo.ifEmpty {
                stringResource(R.string.spending_detail_memo_placeholder)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = memoContent,
                    color = KakaoTheme.colors.highlightPrimaryBlue,
                    style = KakaoTheme.typography.bodyB16
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_right_blue_16px),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }

        InteractionBaseRow(
            title = stringResource(R.string.spending_detail_include_total)
        ) {
            KakaoPayToggle(
                checked = isIncludedInTotal,
                onCheckedChange = onToggleChange
            )
        }
    }
}

@Composable
private fun InteractionBaseRow(
    title: String,
    modifier: Modifier = Modifier,
    titleContent: @Composable () -> Unit = {},
    trailingContent: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyM16
            )
            titleContent()
        }
        trailingContent()
    }
}

@Composable
private fun SettlementBadge() {
    Box(
        modifier = Modifier
            .size(width = 60.dp, height = 25.dp)
            .background(
                color = KakaoTheme.colors.brandPrimaryYellow,
                shape = RoundedCornerShape(999.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.spending_detail_settlement_complete),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.labelM12
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailInteractionCardPreview() {
    KakaoPayTheme {
        SpendingDetailInteractionCard(
            splitAmount = 11800L,
            memo = "",
            isIncludedInTotal = true,
            onToggleChange = {}
        )
    }
}