package com.example.a38_collaboration_android_kakaopay.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.FinancialOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.SpendingAnalysisRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.SpendingDetailsRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.SpendingOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.splash.SplashRoute

@Composable
fun AppNaviHost(
    navController: NavHostController,
    innerPadding : PaddingValues
){
    NavHost(
        navController = navController,
        startDestination = FinancialOverview::class ,
        modifier = Modifier.fillMaxSize()
    ){
        composable<FinancialOverview>{ FinancialOverviewRoute(navController) }

        composable<SpendingAnalysis>{SpendingAnalysisRoute(navController) }

        composable<SpendingDetails>{ SpendingDetailsRoute(navController) }

        composable<SpendingOverview>{ SpendingOverviewRoute(navController) }

        composable<Splash>{ SplashRoute(navController) }

        composable<Home>{}

        composable<Benefits>{}

        composable<Pay>{}

        composable<Invest>{}

    }
}
