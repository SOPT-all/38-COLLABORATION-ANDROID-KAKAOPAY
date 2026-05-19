package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingSummaryModel

@Composable
fun SpendingSummaryCard(
    summaryInfo: SpendingSummaryModel,
    onToggleChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        DetailBaseRow(
            title = stringResource(R.string.spending_detail_split_amount)
        ) {
            Text(
                text = summaryInfo.splitAmount.toWonFormat(),
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyB16
            )
        }

        DetailBaseRow(
            title = stringResource(R.string.spending_detail_settlement_info),
            titleContent = {
                if (summaryInfo.isSettlementComplete) {
                    Spacer(modifier = Modifier.width(10.dp))
                    SettlementBadge()
                }
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                repeat(summaryInfo.participantCount) {
                    Image(
                        painter = painterResource(id = R.drawable.img_profile_placeholder),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }
        }

        DetailBaseRow(
            title = stringResource(R.string.spending_detail_memo)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = summaryInfo.memo.ifEmpty { stringResource(R.string.spending_detail_memo_placeholder) },
                    color = KakaoTheme.colors.highlightPrimaryBlue,
                    style = KakaoTheme.typography.bodyB16
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_right_blue_16px),
                    contentDescription = null,
                    tint = KakaoTheme.colors.highlightPrimaryBlue                )
            }
        }

        DetailBaseRow(
            title = stringResource(R.string.spending_detail_include_total)
        ) {
            KakaoPayToggle(
                checked = summaryInfo.isIncludedInTotal,
                onCheckedChange = onToggleChange
            )
        }
    }
}

@Composable
private fun SettlementBadge() {
    Box(
        modifier = Modifier
            .background(
                color = KakaoTheme.colors.brandPrimaryYellow,
                shape = RoundedCornerShape(999.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = stringResource(R.string.spending_detail_settlement_complete),
            color = KakaoTheme.colors.black,
            style = KakaoTheme.typography.labelM12
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingSummaryCardPreview() {
    KakaoPayTheme {
        SpendingSummaryCard(
            summaryInfo = SpendingSummaryModel(
                splitAmount = 11800L,
                memo = "",
                isIncludedInTotal = true,
                isSettlementComplete = true,
                participantCount = 3
            ),
            onToggleChange = {},
        )
    }
}