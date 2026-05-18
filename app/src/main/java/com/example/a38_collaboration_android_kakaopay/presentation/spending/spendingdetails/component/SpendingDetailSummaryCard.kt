package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
private fun SpendingInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, color = KakaoTheme.colors.grey500, style = KakaoTheme.typography.bodyR14)
        Text(
            text = stringResource(id = R.string.word_divider),
            modifier = Modifier.padding(horizontal = 8.dp),
            color = KakaoTheme.colors.grey200,
            style = KakaoTheme.typography.bodyR14
        )
        Text(text = value, color = KakaoTheme.colors.grey500, style = KakaoTheme.typography.bodyR14)
    }
}
@Composable
private fun SpendingDetailGroup(
    title: String,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    titleColor: androidx.compose.ui.graphics.Color = KakaoTheme.colors.black,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            color = titleColor,
            style = KakaoTheme.typography.titleB18,
        )

        Spacer(modifier = Modifier.height(6.dp))

        SpendingInfoRow(label = label, value = value)
    }
}

@Composable
fun SpendingDetailSummaryCard(
    productName: String,
    paymentMethod: String,
    paymentType: String,
    paymentAmount: Long,
    totalPaymentAmount: Long,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            SpendingDetailGroup(
                title = productName,
                label = paymentMethod,
                value = paymentType,
                modifier = Modifier.weight(1f)
            )

            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(18.dp))
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        SpendingDetailGroup(
            title = paymentAmount.toWonFormat(),
            label = "총 결제",
            value = totalPaymentAmount.toWonFormat()
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun SpendingDetailSummaryCardPreview() {
    KakaoPayTheme {
        SpendingDetailSummaryCard(
            productName = "마라로제 떡볶이X튀2 콤보 1개",
            paymentMethod = "페이머니",
            paymentType = "결제",
            paymentAmount = 11800L,
            totalPaymentAmount = 30000L,
            icon = R.drawable.img_baemin_logo_48px,
        )
    }
}