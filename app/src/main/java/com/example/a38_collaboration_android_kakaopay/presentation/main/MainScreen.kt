package com.example.a38_collaboration_android_kakaopay.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.app.navigation.Benefits
import com.example.a38_collaboration_android_kakaopay.app.navigation.FinancialOverview
import com.example.a38_collaboration_android_kakaopay.app.navigation.Home
import com.example.a38_collaboration_android_kakaopay.app.navigation.Invest
import com.example.a38_collaboration_android_kakaopay.app.navigation.Pay
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingAnalysis
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingDetails
import com.example.a38_collaboration_android_kakaopay.app.navigation.SpendingOverview
import com.example.a38_collaboration_android_kakaopay.app.navigation.Splash

@Composable
fun MainScreen(modifier: Modifier = Modifier)  {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination : Route? = navBackStackEntry?.destination?.route?.let {
        route ->
        when {
            route.contains("Home") -> Home
            route.contains("FinancialOverview") -> FinancialOverview
            route.contains("SpendingAnalysis") -> SpendingAnalysis
            route.contains("SpendingDetails") -> SpendingDetails
            route.contains("SpendingOverview") -> SpendingOverview
            route.contains("Benefits") -> Benefits
            route.contains("Pay") -> Pay
            route.contains("Invest") -> Invest
            route.contains("Splash") -> Splash
            else -> null
         }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    KakaoPayTheme {
        MainScreen()
    }
}
