package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.button.KakaoPayOutlineButton
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme

@Composable
fun SpendingDetailButtonGroup(
    modifier: Modifier = Modifier
) {
    val buttonLabels = listOf(
        stringResource(R.string.spending_detail_footer_receipt),
        stringResource(R.string.spending_detail_footer_settlement),
        stringResource(R.string.spending_detail_footer_split_payment)
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        buttonLabels.forEach { label ->
            KakaoPayOutlineButton(
                text = label,
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SpendingDetailButtonGroupPreview() {
    KakaoPayTheme {
        SpendingDetailButtonGroup()
    }
}