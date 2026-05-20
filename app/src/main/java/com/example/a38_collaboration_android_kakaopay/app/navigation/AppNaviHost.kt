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

    innerPadding: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        startDestination = Asset::class,
        modifier = Modifier.fillMaxSize()
    ) {
        composable<FinancialOverview> {
            FinancialOverviewRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<SpendingAnalysis> {
            SpendingAnalysisRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<SpendingDetails> {
            SpendingDetailsRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Asset> {
            FinancialOverviewRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }


        composable<Splash> {
            SplashRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Home> {
            SpendingAnalysisRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Benefits> {
            SpendingDetailsRoute(
                paddingValues = innerPadding,
                navController = navController
            )
        }

        composable<Pay> {
            SpendingOverviewRoute(
                paddingValues = innerPadding,
                navController = navController,
                onCategoryAnalysisClick = {}
            )
        }

//        composable<Asset> {}

        composable<Invest> {}

    }
}
