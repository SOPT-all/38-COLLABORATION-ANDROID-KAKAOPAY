package com.example.a38_collaboration_android_kakaopay.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.a38_collaboration_android_kakaopay.R
import com.example.a38_collaboration_android_kakaopay.app.navigation.Asset
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoTheme
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    paddingValues: PaddingValues,
    navController: NavController,
) {
    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate(Asset)
    }
    SplashScreen(
        paddingValues = paddingValues,
    )
}

@Composable()
fun SplashScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(KakaoTheme.colors.brandPrimaryYellow)
            .padding(paddingValues)

    ){
        Image(
            painter = painterResource(R.drawable.img_kakaopay_logo),
            contentDescription = null
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview(){
    KakaoPayTheme {
        SplashScreen(paddingValues = PaddingValues())
    }
}
