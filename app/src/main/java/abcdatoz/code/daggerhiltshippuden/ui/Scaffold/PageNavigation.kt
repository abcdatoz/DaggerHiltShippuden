package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun PageNavigation(navController: NavController, modifier: Modifier = Modifier){



    NavHost(navController = navController as NavHostController, startDestination = PageScreens.PageA.route ){

        composable(route = PageScreens.PageA.route){
            PageA(navController)
        }

        composable(route = PageScreens.PageB.route){
            PageB(navController)
        }

        composable(route = PageScreens.PageC.route){
            PageC(navController)
        }

        composable(route = PageScreens.PageD.route){
            PageD(navController)
        }
    }

}