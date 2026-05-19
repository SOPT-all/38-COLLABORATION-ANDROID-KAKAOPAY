package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

@Composable
fun AssetAction(
    modifier: Modifier = Modifier,
){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_graphic_exclamation),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(13.dp))

        AssetFinding()

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cancel_16px),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }

}

@Composable
private fun AssetFinding(){
    Column {
        Text(
            text = stringResource(id = R.string.asset_finding_1),
            style = KakaoTheme.typography.labelR12,
            color = KakaoTheme.colors.grey500
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(id = R.string.asset_finding_2),
            style = KakaoTheme.typography.bodyM14,
            color = KakaoTheme.colors.black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.asset_finding_3),
                style = KakaoTheme.typography.labelR12,
                color = KakaoTheme.colors.grey500
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right_grey300_16px),
                contentDescription = null
            )
        }
    }

}

@Preview
@Composable
private fun AssetActionPreview() {
    KakaoPayTheme {
        AssetAction()
    }
}
