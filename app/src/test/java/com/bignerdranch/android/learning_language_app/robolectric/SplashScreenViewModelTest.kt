package com.bignerdranch.android.learning_language_app.robolectric
import android.os.Looper
import com.bignerdranch.android.learning_language_app.presenter.MainActivity
import com.bignerdranch.android.learning_language_app.presenter.SplashScreen
import com.bignerdranch.android.learning_language_app.viewmodel.SplashScreenViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.Shadows.shadowOf




@RunWith(RobolectricTestRunner::class)
class SplashScreenViewModelTest {

    @Test
    fun checkMainActivityDisplaysAfterThreeSeconds(){
        val controller = Robolectric.buildActivity(SplashScreen::class.java)
        val activity = controller.get()
        val viewModel = SplashScreenViewModel()

        viewModel.setTimer(activity)

        shadowOf(Looper.getMainLooper()).idle(3000)

        val intent = Shadows.shadowOf(activity).nextStartedActivity

        assertEquals(MainActivity::class.java.canonicalName, intent.component?.className)

    }

    @Test
    fun checkSplashScreenDisplaysForThreeSeconds(){
        val controller = Robolectric.buildActivity(SplashScreen::class.java)
        val activity = controller.get()
        val viewModel = SplashScreenViewModel()

        viewModel.setTimer(activity)

        shadowOf(Looper.getMainLooper()).idle(3000)

        assertTrue(activity.isFinishing)
    }

    @Test
    fun checkSplashScreenDisplaysForTwoSeconds() {
        val controller = Robolectric.buildActivity(SplashScreen::class.java)
        val activity = controller.get()
        val viewModel = SplashScreenViewModel()

        viewModel.setTimer(activity)

        shadowOf(Looper.getMainLooper()).idle(2000)

        assertFalse(activity.isFinishing)
    }





}