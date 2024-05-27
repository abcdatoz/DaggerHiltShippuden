package abcdatoz.code.daggerhiltshippuden


import abcdatoz.code.daggerhiltshippuden.ui.clanes.ClanesScreen
import abcdatoz.code.daggerhiltshippuden.ui.home.HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import abcdatoz.code.daggerhiltshippuden.ui.theme.DaggerHiltShippudenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltShippudenTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //HomeScreen()
                    ClanesScreen()


                }
            }
        }
    }
}

