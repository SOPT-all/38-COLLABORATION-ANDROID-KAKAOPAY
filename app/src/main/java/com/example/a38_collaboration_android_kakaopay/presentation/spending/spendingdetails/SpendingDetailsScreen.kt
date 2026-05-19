package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingDetailAmountInfo
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingDetailBanner
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingDetailButtonGroup
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingDetailStoreInfo
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingInfoCard
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component.SpendingSummaryCard
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailGroupModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingDetailPaymentModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingInfoModel
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.model.SpendingSummaryModel

@Composable
fun SpendingDetailsRoute(
    paddingValues: PaddingValues,
    navController: NavController
) {

}

@Composable
fun SpendingDetailsScreen(
    paddingValues: PaddingValues,
    paymentInfo: SpendingDetailPaymentModel,
    summaryInfo: SpendingSummaryModel,
    detailInfo: SpendingInfoModel,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onToggleChange: (Boolean) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.white)
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        KakaoPaySubTopBar(
            onBackClick = onBackClick,
            title = {
                Text(
                    text = "상세내역",
                    style = KakaoTheme.typography.bodyB16,
                    color = KakaoTheme.colors.black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(29.dp))

            SpendingDetailStoreInfo(paymentInfo = paymentInfo)

            Spacer(modifier = Modifier.height(40.dp))

            SpendingDetailAmountInfo(paymentInfo = paymentInfo)

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = KakaoTheme.colors.grey200, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            SpendingSummaryCard(
                summaryInfo = summaryInfo,
                onToggleChange = onToggleChange
            )

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = KakaoTheme.colors.grey200, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            SpendingInfoCard(info = detailInfo)

            Spacer(modifier = Modifier.height(30.dp))

            SpendingDetailButtonGroup()

            Spacer(modifier = Modifier.height(30.dp))

            SpendingDetailBanner()

            Spacer(modifier = Modifier.height(31.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailsScreenPreview() {
    KakaoPayTheme {
        SpendingDetailsScreen(
            paddingValues = PaddingValues(),
            paymentInfo = SpendingDetailPaymentModel(
                mainInfo = SpendingDetailGroupModel(
                    title = "마라로제 떡볶이X튀2 콤보 1개",
                    label = "페이머니",
                    value = "결제"
                ),
                amountInfo = SpendingDetailGroupModel(
                    title = 11800L.toWonFormat(),
                    label = "총 결제",
                    value = 11800L.toWonFormat()
                ),
                icon = R.drawable.img_baemin_logo_48px
            ),
            summaryInfo = SpendingSummaryModel(
                splitAmount = 11800L,
                memo = "",
                isIncludedInTotal = true,
                isSettlementComplete = true
            ),
            detailInfo = SpendingInfoModel(
                orderAmount = 11800L,
                paymentAmount = 11800L,
                orderNumber = "202604270L7M2W06J",
                dateTime = "2026. 04. 27.(월) 21:39",
                category = "배달"
            ),
            onBackClick= {},
            onToggleChange = {},
        )
    }
}