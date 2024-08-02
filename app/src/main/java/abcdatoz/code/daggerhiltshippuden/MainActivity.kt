package abcdatoz.code.daggerhiltshippuden

import abcdatoz.code.daggerhiltshippuden.myRestaurant.Navigation.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import abcdatoz.code.daggerhiltshippuden.ui.theme.DaggerHiltShippudenTheme
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private lateinit var analytics:FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        analytics = Firebase.analytics

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


                    //ScaffoldA(analytics)
                    //ScreenD()

                    MainScreen()


                }
            }
        }
    }
}

