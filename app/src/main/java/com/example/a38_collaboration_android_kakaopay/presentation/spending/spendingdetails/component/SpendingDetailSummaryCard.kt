package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailGroupModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailPaymentModel

@Composable
fun SpendingDetailStoreInfo(
    paymentInfo: SpendingDetailPaymentModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        SpendingDetailGroup(
            groupData = paymentInfo.mainInfo,
            titleStyle = KakaoTheme.typography.titleB20,
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(id = paymentInfo.icon),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(18.dp))
        )
    }
}

@Composable
fun SpendingDetailAmountInfo(
    paymentInfo: SpendingDetailPaymentModel,
    modifier: Modifier = Modifier,
) {
    SpendingDetailGroup(
        groupData = paymentInfo.amountInfo,
        titleStyle = KakaoTheme.typography.titleB26,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
private fun SpendingDetailGroup(
    groupData: SpendingDetailGroupModel,
    titleStyle: TextStyle,
    modifier: Modifier = Modifier,
    titleColor: Color = KakaoTheme.colors.black,
) {
    Column(modifier = modifier) {
        Text(
            text = groupData.title,
            color = titleColor,
            style = titleStyle,
        )

        Spacer(modifier = Modifier.height(6.dp))

        SpendingInfoRow(label = groupData.label, value = groupData.value)
    }
}

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
        Text(
            text = label,
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyR14
        )
        Text(
            text = stringResource(id = R.string.word_divider),
            modifier = Modifier
                .padding(horizontal = 8.dp),
            color = KakaoTheme.colors.grey200,
            style = KakaoTheme.typography.labelR12
        )
        Text(
            text = value,
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.bodyR14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailSummaryCardsPreview() {
    KakaoPayTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val mockData = SpendingDetailPaymentModel(
                mainInfo = SpendingDetailGroupModel(
                    title = "마라로제 떡볶이X튀2 콤보 1개",
                    label = "페이머니",
                    value = "결제"
                ),
                amountInfo = SpendingDetailGroupModel(
                    title = 11800L.toWonFormat(),
                    label = "총 결제",
                    value = 30000L.toWonFormat()
                ),
                icon = R.drawable.img_baemin_logo_48px
            )

            SpendingDetailStoreInfo(paymentInfo = mockData)
            Spacer(modifier = Modifier.height(32.dp))
            SpendingDetailAmountInfo(paymentInfo = mockData)
        }
    }
}