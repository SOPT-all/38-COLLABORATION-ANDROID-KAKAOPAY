package com.example.a38_collaboration_android_kakaopay.core.common.state

sealed interface UiState<out T> {
    data object Empty: UiState<Nothing> // 바뀌는 상황 보여줄 예정

    data object Loading : UiState<Nothing>

    data class Success<T>(
        val data : T
    ): UiState<T>

    data class Failure(
        val message: String,
    ) : UiState<Nothing>
}
