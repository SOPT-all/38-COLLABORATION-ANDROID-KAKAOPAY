package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.a38_collaboration_android_kakaopay.R

@Composable
fun MultipleActionItem(
    totalExpense: Int,
    totalIncome: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_graphic_fixed_expense_24px),
        contentDescription = null,
        tint = Color.Unspecified
    )


}