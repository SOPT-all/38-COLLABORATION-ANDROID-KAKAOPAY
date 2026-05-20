package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinanceMenuItem
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinanceTopCardItem
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinanceTopCardStyle
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.financeMenuItems
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.financeTopCardItems
import kotlinx.collections.immutable.ImmutableList

@Composable
fun FinanceMenuSection(
    modifier: Modifier = Modifier,
    topItems: ImmutableList<FinanceTopCardItem> = financeTopCardItems,
    items: ImmutableList<FinanceMenuItem> = financeMenuItems,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(KakaoTheme.colors.white)
            .padding(
                start = 14.dp,
                top = 14.dp,
                end = 14.dp,
                bottom = 20.dp
            )

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            topItems.take(2).forEach { item ->
                FinanceTopCard(
                    item = item,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(21.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier,
            userScrollEnabled = false,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(
                items = items,
                key = { it.titleRes }
            ) { item ->
                FinanceMenuGridItem(
                    item = item,
                    modifier = Modifier

                )
            }
        }
    }
}

@Composable
private fun FinanceTopCard(
    item: FinanceTopCardItem,
    modifier: Modifier = Modifier,
) {
    val labelColor = when (item.style) {
        FinanceTopCardStyle.NEW -> KakaoTheme.colors.highlightPrimaryBlue
        FinanceTopCardStyle.RECOMMEND -> KakaoTheme.colors.grey400
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(KakaoTheme.colors.grey100)
            .padding(
               horizontal = 20.dp, vertical = 14.dp
            )
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(
                text = stringResource(id = item.labelRes),
                color = labelColor,
                style = KakaoTheme.typography.bodyM14
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(id = item.titleRes),
                color =KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyB16
            )
        }

//        Spacer(Modifier.weight(1f))

        Image(
            painter = painterResource(id = item.iconRes),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(48.dp)
        )
    }
}

@Composable
private fun FinanceMenuGridItem(
    item: FinanceMenuItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = item.iconRes),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = item.titleRes),
            color =KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.labelM12
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FinanceMenuSectionPreview() {
    KakaoPayTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(KakaoTheme.colors.grey100)
                .padding(horizontal = 14.dp, vertical = 14.dp)
        ) {
            FinanceMenuSection(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}
