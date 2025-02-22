package ks.connecttooffice10.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import ks.connecttooffice10.ui.screen.MainScreen
import ks.connecttooffice10.ui.theme.ConnectToOffice10Theme


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConnectToOffice10Theme {
                MainScreen()
            }
        }
    }

}

