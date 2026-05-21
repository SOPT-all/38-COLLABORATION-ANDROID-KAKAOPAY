package com.example.a38_collaboration_android_kakaopay.presentation.splash

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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
    HideNavigationBarDuringSplash()

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

@Composable
private fun HideNavigationBarDuringSplash() {
    val context = LocalContext.current

    DisposableEffect(context) {
        val activity = context.findActivity()

        activity?.hideNavigationBar()

        onDispose {
            activity?.showNavigationBar()
        }
    }
}

private fun Activity.hideNavigationBar() {
    val controller = WindowCompat.getInsetsController(
        window,
        window.decorView
    )

    controller.hide(WindowInsetsCompat.Type.navigationBars())
    controller.systemBarsBehavior =
        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}

private fun Activity.showNavigationBar() {
    val controller = WindowCompat.getInsetsController(
        window,
        window.decorView
    )

    controller.show(WindowInsetsCompat.Type.navigationBars())
}

private tailrec fun Context.findActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview(){
    KakaoPayTheme {
        SplashScreen(paddingValues = PaddingValues())
    }
}
