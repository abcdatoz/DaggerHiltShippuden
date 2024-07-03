package abcdatoz.code.daggerhiltshippuden

import abcdatoz.code.daggerhiltshippuden.ui.Scaffold.ScaffoldA
import abcdatoz.code.daggerhiltshippuden.ui.characters.CharactersScreen
import abcdatoz.code.daggerhiltshippuden.ui.clanes.ClanesScreen
import abcdatoz.code.daggerhiltshippuden.ui.home.HomeScreen
import abcdatoz.code.daggerhiltshippuden.ui.kards.CardExample
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.NinjasScreen
import abcdatoz.code.daggerhiltshippuden.ui.screens.ScreenA
import abcdatoz.code.daggerhiltshippuden.ui.screens.ScreenABC
import abcdatoz.code.daggerhiltshippuden.ui.screens.ScreenB
import abcdatoz.code.daggerhiltshippuden.ui.screens.ScreenC
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import abcdatoz.code.daggerhiltshippuden.ui.theme.DaggerHiltShippudenTheme
import abcdatoz.code.daggerhiltshippuden.ui.villas.VillasScreen

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
                    //ClanesScreen()
                    //VillasScreen()

                    //CharactersScreen()
                    //ScreenC()
                    //CardExample()

                    //NinjasScreen()


                    ScaffoldA()


                }
            }
        }
    }
}

