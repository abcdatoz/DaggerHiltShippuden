package abcdatoz.code.daggerhiltshippuden.ui.Navigation

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.ui.clanes.ClanesScreen
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.NinjasScreen
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.components.NinjaList
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.components.NinjaOne
import abcdatoz.code.daggerhiltshippuden.ui.villas.LeVille
import abcdatoz.code.daggerhiltshippuden.ui.villas.VillasScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(
    navController: NavController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController as NavHostController, startDestination = Routes.Clanes.route ){

        composable((Routes.Clanes.route)){
            ClanesScreen()
        }

        composable(route = Routes.Villas.route){
            LeVille()
        }

        composable(route = Routes.Ninjas.route){
            NinjaList()
        }




    }
}