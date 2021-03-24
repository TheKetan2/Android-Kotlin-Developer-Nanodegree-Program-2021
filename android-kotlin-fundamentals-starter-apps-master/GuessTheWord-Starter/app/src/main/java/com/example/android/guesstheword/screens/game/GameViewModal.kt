package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModal: ViewModel() {
    init{
        Log.i("GameViewMpdel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameVIewModelDestroyed!")
    }
}