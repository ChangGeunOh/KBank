package kr.pe.paran.kbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.pe.paran.kbank.navigation.NavGraph
import kr.pe.paran.kbank.ui.theme.KBankTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KBankTheme {
                // A surface container using the 'background' color from the theme
                val navHostController = rememberNavController()
//                enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(scrim = 10, darkScrim = 20))
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavGraph(navHostController = navHostController)
                }
            }
        }
    }
}
