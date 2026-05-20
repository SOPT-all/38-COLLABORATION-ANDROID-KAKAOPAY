package com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.FinanceMenuItem
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.model.financeMenuItems
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview
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
            modifier = Modifier.size(44.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = item.titleRes),
            color = Color(0xFF74777D),
            fontSize = 14.sp,
            lineHeight = 19.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

@Composable
fun FinanceMenuSection(
    modifier: Modifier = Modifier,
    items: List<FinanceMenuItem> = financeMenuItems,
) {
    val columnCount = 4
    val itemHeight = 92.dp

    val horizontalPadding = 21.dp
    val verticalPadding = 18.dp

    val horizontalSpacing = 21.dp
    val verticalSpacing = 18.dp

    val rowCount = remember(items.size) {
        (items.size + columnCount - 1) / columnCount
    }

    val gridHeight =
        itemHeight * rowCount.toFloat() +
                verticalSpacing * (rowCount - 1).coerceAtLeast(0).toFloat() +
                verticalPadding * 2f

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columnCount),
            modifier = Modifier
                .fillMaxWidth()
                .height(gridHeight),
            userScrollEnabled = false,
            contentPadding = PaddingValues(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing),
            verticalArrangement = Arrangement.spacedBy(verticalSpacing)
        ) {
            items(
                items = items,
                key = { it.titleRes }
            ) { item ->
                FinanceMenuGridItem(
                    item = item,
                    modifier = Modifier.height(itemHeight)
                )
            }
        }
    }
}

@Preview(
    name = "FinanceMenuSection Preview",
    showBackground = true,
    backgroundColor = 0xFFF3F4F6,
    widthDp = 360
)
@Composable
private fun FinanceMenuSectionPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF3F4F6))
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        FinanceMenuSection(
            modifier = Modifier.fillMaxWidth()
        )
    }
}
