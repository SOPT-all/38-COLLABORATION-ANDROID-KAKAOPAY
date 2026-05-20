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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.card.KakaoPayBasicCard
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
    KakaoPayBasicCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
                            .aspectRatio(146/166f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(21.dp))

            FinanceMenuGrid(
                items = items,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@Composable
private fun FinanceMenuGrid(
    items: ImmutableList<FinanceMenuItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items.chunked(4).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(21.dp),
                verticalAlignment = Alignment.Top
            ) {
                rowItems.forEach { item ->
                    FinanceMenuGridItem(
                        item = item,
                        modifier = Modifier.weight(1f)
                    )
                }

                repeat(4 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
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
                horizontal = 20.dp,
                vertical = 14.dp
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
                color = KakaoTheme.colors.black,
                style = KakaoTheme.typography.bodyB16,
                maxLines = 2
            )


        }

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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.iconRes),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(id = item.titleRes),
            color = KakaoTheme.colors.grey500,
            style = KakaoTheme.typography.labelM12,
            textAlign = TextAlign.Center,
            maxLines = 2,
            minLines = 2
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
