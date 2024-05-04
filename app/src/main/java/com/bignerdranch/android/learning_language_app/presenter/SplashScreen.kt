package com.bignerdranch.android.learning_language_app.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.learning_language_app.R
import com.bignerdranch.android.learning_language_app.viewmodel.SplashScreenViewModel

class SplashScreen : AppCompatActivity() {

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewModel = ViewModelProvider(this)[SplashScreenViewModel::class.java]

        viewModel.hideStatusBar(activity = this)

        viewModel.setTimer(activity = this)
    }
}