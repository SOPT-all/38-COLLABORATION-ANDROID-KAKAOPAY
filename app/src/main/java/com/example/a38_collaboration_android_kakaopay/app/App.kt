package com.example.a38_collaboration_android_kakaopay.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.a38_collaboration_android_kakaopay.app.navigation.AppNaviHost

@Composable
fun App(){
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        innerPadding ->
        AppNaviHost(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}
