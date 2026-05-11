package com.example.a38_collaboration_android_kakaopay.app.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route

@Serializable
data object Splash : Route

@Serializable
data object FinancialOverview : Route

@Serializable
data object SpendingAnalysis : Route

@Serializable
data object SpendingDetails : Route

@Serializable
data object SpendingOverview : Route

@Serializable
data object Home : Route

@Serializable
data object Benefits : Route

@Serializable
data object Pay: Route

@Serializable
data object Invest : Route
