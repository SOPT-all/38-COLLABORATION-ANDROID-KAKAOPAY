package com.example.a38_collaboration_android_kakaopay.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.a38_collaboration_android_kakaopay.app.navigation.AppNaviHost
import com.example.a38_collaboration_android_kakaopay.app.navigation.Route
import com.example.a38_collaboration_android_kakaopay.core.designsystem.component.navigation.KakaoPayNavigatorBar

@Composable
fun App(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.toRoute<Route>()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            KakaoPayNavigatorBar(
                currentRoute = currentRoute,
                onTabSelected = { tab ->
                    navController.navigate(tab.route) {
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
