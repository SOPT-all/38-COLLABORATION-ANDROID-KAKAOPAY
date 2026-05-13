package com.example.a38_collaboration_android_kakaopay.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a38_collaboration_android_kakaopay.core.designsystem.theme.KakaoPayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KakaoPayTheme {
                App()
            }
        }
    }
}
