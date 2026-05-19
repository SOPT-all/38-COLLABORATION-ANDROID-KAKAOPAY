package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingInfoModel

@Composable
fun SpendingInfoCard(
    info: SpendingInfoModel,
    modifier: Modifier = Modifier,
) {
    val infoItems = listOf(
        stringResource(R.string.spending_detail_info_order_amount) to info.orderAmount.toWonFormat(),
        stringResource(R.string.spending_detail_info_payment_method) to info.paymentAmount.toWonFormat(),
        stringResource(R.string.spending_detail_info_order_number) to info.orderNumber,
        stringResource(R.string.spending_detail_info_date_time) to info.dateTime
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        infoItems.forEach { (title, content) ->
            DetailBaseRow(title = title) {
                Text(
                    text = content,
                    color = KakaoTheme.colors.black,
                    style = KakaoTheme.typography.bodyB16
                )
            }
        }

        DetailBaseRow(
            title = stringResource(R.string.spending_detail_info_category)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = info.category,
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

        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = stringResource(R.string.spending_detail_info_footer_notice),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyR14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingInfoCardPreview() {
    KakaoPayTheme {
        SpendingInfoCard(
            info = SpendingInfoModel(
                orderAmount = 11800L,
                paymentAmount = 11800L,
                orderNumber = "202604270L7M2W06J",
                dateTime = "2026. 04. 27.(월) 21:39",
                category = "배달"
            )
        )
    }
}