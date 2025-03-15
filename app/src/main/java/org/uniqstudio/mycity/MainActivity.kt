package org.uniqstudio.mycity

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import org.uniqstudio.mycity.model.RestaurantViewModel
import org.uniqstudio.mycity.ui.RestaurantScreen
import org.uniqstudio.mycity.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface{
                    val windowSize = calculateWindowSizeClass(this)
                    RestaurantScreen(
                        restaurantViewModel = RestaurantViewModel(),
                        windowSize = windowSize
                    )
                }
            }
        }
    }
}