package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.Transaction
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionMethod
import com.example.a38_collaboration_android_kakaopay.domain.model.spendingoverview.transaction.TransactionType

@Composable
fun TransactionListItem(
    transaction: Transaction,
    modifier: Modifier = Modifier,
) {
    val kakaobankKeyword = stringResource(R.string.spending_overview_kakaobank)

    val thumbnail = when {
        transaction.transactionType == TransactionType.PAYMENT -> R.drawable.img_baemin_logo_36px
        transaction.transactionMethod == TransactionMethod.PAY_MONEY && transaction.transactionName.contains(kakaobankKeyword
        ) -> R.drawable.img_kakaopay_logo
        else -> R.drawable.img_profile_placeholder
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(thumbnail),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        TransactionInfo(transaction = transaction)
    }
}

@Composable
private fun TransactionInfo(
    transaction: Transaction,
    modifier: Modifier = Modifier,
) {
    val amountColor = when {
        transaction.transactionType == TransactionType.TRANSFER_RECEIVE -> KakaoTheme.colors.highlightPrimaryBlue
        !transaction.includeInTotal -> KakaoTheme.colors.grey400
        else -> KakaoTheme.colors.black
    }

    val showPlusPrefix =
        transaction.transactionType == TransactionType.TRANSFER_RECEIVE && transaction.amount > 0

    val amountPrefix = if (showPlusPrefix) "+" else ""

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CounterPartyInfo(transaction = transaction)
        Text(
            text = "${amountPrefix}${transaction.amount.toWonFormat()}",
            color = amountColor,
            style = KakaoTheme.typography.bodyB16
        )
    }
}

@Composable
private fun CounterPartyInfo(
    transaction: Transaction,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 송금 or 받기
        if (transaction.transactionType != TransactionType.PAYMENT) {
            Text(
                text = when (transaction.transactionType) {
                    TransactionType.TRANSFER_SEND -> stringResource(R.string.spending_overview_transfer_send)
                    TransactionType.TRANSFER_RECEIVE -> stringResource(R.string.spending_overview_transfer_receive)
                    else -> ""
                },
                color = KakaoTheme.colors.grey500,
                style = KakaoTheme.typography.labelR12
            )

            Text(
                text = stringResource(R.string.word_divider),
                color = KakaoTheme.colors.grey200,
                style = KakaoTheme.typography.labelR12,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(12.dp)
                    .height(17.dp)
            )

            // 카카오페이머니
            if (transaction.transactionMethod == TransactionMethod.PAY_MONEY) {
                Text(
                    text = stringResource(R.string.spending_overview_kakaopay_money),
                    color = KakaoTheme.colors.grey500,
                    style = KakaoTheme.typography.labelR12
                )
                Text(
                    text = "→",
                    color = KakaoTheme.colors.grey500,
                    style = KakaoTheme.typography.labelR12,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }

        Text(
            text = transaction.transactionName,
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.labelR12,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun TransactionListItemPreview() {
    KakaoPayTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TransactionListItem(
                transaction = Transaction(
                    transactionId = 0,
                    transactionType = TransactionType.PAYMENT,
                    transactionMethod = TransactionMethod.PAY_MONEY,
                    transactionName = "우아한형제들·마라로제 떡볶이X튀2 콤보",
                    amount = -11800,
                    includeInTotal = true,
                )
            )
            TransactionListItem(
                transaction = Transaction(
                    transactionId = 1,
                    transactionType = TransactionType.TRANSFER_SEND,
                    transactionMethod = TransactionMethod.PAY_MONEY,
                    transactionName = "염*원(카카오뱅크1234)",
                    amount = -6525,
                    includeInTotal = true,
                )
            )
            TransactionListItem(
                transaction = Transaction(
                    transactionId = 2,
                    transactionType = TransactionType.TRANSFER_SEND,
                    transactionMethod = TransactionMethod.PAY_MONEY,
                    transactionName = "박솝트(박솝트)",
                    amount = -3475,
                    includeInTotal = false,
                )
            )
            TransactionListItem(
                transaction = Transaction(
                    transactionId = 3,
                    transactionType = TransactionType.TRANSFER_RECEIVE,
                    transactionMethod = TransactionMethod.PAY_MONEY,
                    transactionName = "김솝트(김솝트)",
                    amount = 123000,
                    includeInTotal = true,
                )
            )
        }
    }
}