package com.bignerdranch.android.learning_language_app.viewmodel

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.learning_language_app.presenter.MainActivity

class SplashScreenViewModel : ViewModel() {
    internal fun hideStatusBar(activity: Activity) {
        WindowCompat.getInsetsController(activity.window, activity.window.decorView).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.statusBars())
        }
    }

    internal fun setTimer(activity: Activity){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
           activity.finish()
        }, DELAY_MILS)
    }

    companion object{
        private const val DELAY_MILS = 3000L
    }
}


