package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun FinancialCtaButton(
    modifier: Modifier = Modifier
){
    KakaoPayBasicCard(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        enabled = true,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)

        ) {
            Spacer(Modifier.height(20.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24px),
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.finance_cta_button),
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyB16
            )
        }

    }
}
