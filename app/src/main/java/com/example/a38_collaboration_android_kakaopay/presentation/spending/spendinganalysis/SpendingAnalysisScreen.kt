package com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.monthcontrol.MonthControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.KakaoPaySegmentControl
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.segmentcontrol.SegmentTab
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.topbar.KakaoPaySubTopBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.AssetAction
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.CategoryExpenseItem
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.ExpenseList
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.component.ExpenseSummary
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.model.SpendingCategoryModel
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SpendingAnalysisRoute(
    paddingValues : PaddingValues,
    navController: NavController
){
    SpendingAnalysisScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun SpendingAnalysisScreen(
    paddingValues : PaddingValues,
    modifier: Modifier = Modifier
) {
    var currentTab by remember { mutableStateOf(SegmentTab.SUMMARY) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        KakaoPaySubTopBar(
            title = {
                Text(
                    text = "소비분석",
                    style = KakaoTheme.typography.bodyM16,
                    color = KakaoTheme.colors.black
                )
            },
            onBackClick = {},
            modifier = Modifier
                .padding(horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        KakaoPaySegmentControl(
            selectedTab = currentTab,
            onTabSelected = { selected ->
                currentTab = selected
            },
            modifier = Modifier
                .padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(35.dp))

        MonthControl(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 6.dp)
                .size(width = 128.dp, height = 24.dp),
        )

        ExpenseSummary(
            currentMonthTotal = 11800L,
            previousMonthTotal = 64500L,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.img_chart_may),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(179.dp),
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.height(27.dp))

        AssetAction(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(62.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        ExpenseList(
            categoryExpenses = listOf(
                CategoryExpenseItem(
                    categoryType = SpendingCategoryModel.TRANSPORTATION,
                    currentMonthAmount = 58450L,
                    previousMonthAmount = 68450L
                ),
                CategoryExpenseItem(
                    categoryType = SpendingCategoryModel.FOOD,
                    currentMonthAmount = 23900L,
                    previousMonthAmount = 13900L
                ),
                CategoryExpenseItem(
                    categoryType = SpendingCategoryModel.COFFEE_DESERT,
                    currentMonthAmount = 5000L,
                    previousMonthAmount = -5000L
                )
            ).toImmutableList(),
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )

    }

}

//@Composable
//fun Column(modifier: Modifier, content: @Composable () -> Unit) {
//    TODO("Not yet implemented")
//}


@Preview(showBackground = true)
@Composable
private fun SpendingAnalysisScreenPreview(){
    KakaoPayTheme {
        SpendingAnalysisScreen(
            paddingValues = PaddingValues()
        )
    }
}
