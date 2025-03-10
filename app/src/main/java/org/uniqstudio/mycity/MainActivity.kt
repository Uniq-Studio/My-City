package org.uniqstudio.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.uniqstudio.mycity.data.RestaurantDataSource
import org.uniqstudio.mycity.ui.RestaurantList
import org.uniqstudio.mycity.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                    RestaurantList(RestaurantDataSource().loadRestaurants(), {})
            }
        }
    }
}