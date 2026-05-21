package com.example.a38_collaboration_android_kakaopay.app.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.edgecase.EdgeCaseType
import com.example.a38_collaboration_android_kakaopay.presentation.edgecase.EdgeCaseScreen
import com.example.a38_collaboration_android_kakaopay.presentation.financialoverview.FinancialOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendinganalysis.SpendingAnalysisRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingdetails.SpendingDetailsRoute
import com.example.a38_collaboration_android_kakaopay.presentation.spending.spendingoverview.SpendingOverviewRoute
import com.example.a38_collaboration_android_kakaopay.presentation.splash.SplashRoute
import com.example.a38_collaboration_android_kakaopay.presentation.splash.SplashScreen

@Composable
fun AppNaviHost(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues(),
) {
    NavHost(
        navController = navController,
        startDestination = Splash::class,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        modifier = Modifier.fillMaxSize()
    ) {
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

        composable<SpendingOverview> {
            SpendingOverviewRoute(
                paddingValues = innerPadding,
                navController = navController,
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
            EdgeCaseScreen(EdgeCaseType.Empty)
        }

        composable<Benefits> {
            EdgeCaseScreen(EdgeCaseType.General)
        }

        composable<Pay> {
            EdgeCaseScreen(EdgeCaseType.Error404)
        }

        composable<Invest> {
            EdgeCaseScreen(EdgeCaseType.Empty)
        }

    }
}
