package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.common.util.toWonFormat
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingCategoryModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ExpenseList(
    categoryExpenses: ImmutableList<CategoryExpenseItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        categoryExpenses.forEach { expenseItem ->
            ExpenseItem(
                item = expenseItem,
            )
        }
    }
}

data class CategoryExpenseItem(
    val categoryType: SpendingCategoryModel,
    val currentMonthAmount: Long,
    val previousMonthAmount: Long
)

fun calculateDiff(current: Long, previous: Long): Boolean {
    val diff = current - previous

    return when {
        diff > 0 -> true
        diff < 0 -> false
        else -> true
    }
}

@Composable
private fun ExpenseItem(
    item: CategoryExpenseItem,
    modifier: Modifier = Modifier,
) {

    val diffTextColor =
        if (calculateDiff(current = item.currentMonthAmount, item.previousMonthAmount)) {
            KakaoTheme.colors.highlightPrimaryRed
        } else {
            KakaoTheme.colors.highlightPrimaryBlue
        }

    val diffTextMessage =
        if (calculateDiff(current = item.currentMonthAmount, previous = item.previousMonthAmount)) {
            "+${kotlin.math.abs(item.currentMonthAmount - item.previousMonthAmount).toWonFormat()}"
        } else {
            "-${kotlin.math.abs(item.currentMonthAmount - item.previousMonthAmount).toWonFormat()}"
        }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = item.categoryType.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = item.categoryType.koreanName,
            style = KakaoTheme.typography.bodyR14,
            color = KakaoTheme.colors.black
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Text(
                text = item.currentMonthAmount.toWonFormat(),
                style = KakaoTheme.typography.bodyM16,
                color = KakaoTheme.colors.black
            )



            Text(
                text = "지난달보다 $diffTextMessage",
                style = KakaoTheme.typography.labelR12,
                color = diffTextColor
            )
        }

        Spacer(modifier = Modifier.width(2.dp))

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_chevron_right_grey300_16px),
            contentDescription = null,
            tint = KakaoTheme.colors.grey500
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpenseListPreview() {

    val mockExpenses = listOf(
        CategoryExpenseItem(
            categoryType = SpendingCategoryModel.TRANSPORTATION,
            currentMonthAmount = 58450,
            previousMonthAmount = 68450
        ),
        CategoryExpenseItem(
            categoryType = SpendingCategoryModel.FOOD,
            currentMonthAmount = 23900,
            previousMonthAmount = 3900
        ),
        CategoryExpenseItem(
            categoryType = SpendingCategoryModel.COFFEE_DESSERT,
            currentMonthAmount = 5000,
            previousMonthAmount = 3000
        )
    )

    KakaoPayTheme {
        ExpenseList(categoryExpenses = mockExpenses.toImmutableList())
    }
}
