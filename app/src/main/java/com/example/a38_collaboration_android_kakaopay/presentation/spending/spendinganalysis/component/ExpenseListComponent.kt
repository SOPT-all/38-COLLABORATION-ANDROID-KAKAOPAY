package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme

data class CategoryExpenseItem(
    val categoryType: SpendingCategory,
    val currentMonthAmount: Long,
    val previousMonthAmount: Long
)

enum class SpendingCategory(val Name: String, val imageResId: Int) {
    TRANSPORTATION("교통", R.drawable.img_transport),
    FOOD("음식", R.drawable.img_food),
    COFFEE_DESERT("커피/디저트", R.drawable.img_cafe),
}

fun calculateDiff(current: Long, previous: Long): String {
    val diff = current - previous
    return if (diff >= 0) "+${diff.toWonFormat()}" else diff.toWonFormat()
}

@Composable
fun ExpenseList(
    categoryExpenses: List<CategoryExpenseItem>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        categoryExpenses.forEach { expenseItem ->
            ExpenseItem(item = expenseItem)
        }
    }
}

@Composable
private fun ExpenseItem(
    modifier: Modifier = Modifier,
    item: CategoryExpenseItem,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.categoryType.imageResId),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = item.categoryType.Name,
            style = KakaoTheme.typography.bodyM14,
            color = KakaoTheme.colors.black
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.End
        ) {
            // 이번 달 지출 금액
            Text(
                text = "${item.currentMonthAmount.toWonFormat()}",
                style = KakaoTheme.typography.bodyM16,
                color = KakaoTheme.colors.black
            )

            // 지난달 대비 계산 금액 및 텍스트 문구
            val diffAmount = item.currentMonthAmount - item.previousMonthAmount
            val diffTextColor = if (diffAmount >= 0) {
                KakaoTheme.colors.highlightPrimaryBlue
            } else {
                KakaoTheme.colors.highlightPrimaryRed
            }

            Text(
                text = "지난달보다 ${calculateDiff(item.currentMonthAmount, item.previousMonthAmount)}",
                style = KakaoTheme.typography.labelR12,
                color = diffTextColor
            )

        }

        Spacer(modifier = Modifier.width(2.dp))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_chevron_right_grey300_16px),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun ExpenseListPreview() {

    val mockExpenses = listOf(
        CategoryExpenseItem(
            categoryType = SpendingCategory.TRANSPORTATION,
            currentMonthAmount = 58450,
            previousMonthAmount = 68450
        ),
        CategoryExpenseItem(
            categoryType = SpendingCategory.FOOD,
            currentMonthAmount = 23900,
            previousMonthAmount = 3900
        ),
        CategoryExpenseItem(
            categoryType = SpendingCategory.COFFEE_DESERT,
            currentMonthAmount = 5000,
            previousMonthAmount = 3000
        )
    )

    KakaoPayTheme {
        ExpenseList(categoryExpenses = mockExpenses)
    }
}