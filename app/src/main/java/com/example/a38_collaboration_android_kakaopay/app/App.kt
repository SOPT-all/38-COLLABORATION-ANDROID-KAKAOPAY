package com.example.a38_collaboration_android_kakaopay.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a38_collaboration_android_kakaopay.app.navigation.AppNaviHost
import com.example.a38_collaboration_android_kakaopay.app.navigation.Asset
import com.example.a38_collaboration_android_kakaopay.app.navigation.Benefits
import com.example.a38_collaboration_android_kakaopay.app.navigation.Home
import com.example.a38_collaboration_android_kakaopay.app.navigation.Invest
import com.example.a38_collaboration_android_kakaopay.app.navigation.Pay
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.KakaoPayNavigatorBar
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.MainTab

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = MainTab.entries
        .firstOrNull { tab ->
            currentDestination?.route == tab.route::class.qualifiedName
        }
        ?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            KakaoPayNavigatorBar(
                currentRoute = currentRoute,
                onTabSelected = { tab ->
                    val route = when (tab) {
                        MainTab.HOME -> Home
                        MainTab.BENEFITS -> Benefits
                        MainTab.PAY -> Pay
                        MainTab.ASSET -> Asset
                        MainTab.INVEST -> Invest
                    }
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }) { innerPadding ->
        AppNaviHost(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}
