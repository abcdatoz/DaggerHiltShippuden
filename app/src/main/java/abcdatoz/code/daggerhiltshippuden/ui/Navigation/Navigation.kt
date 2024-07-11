package abcdatoz.code.daggerhiltshippuden.ui.Navigation

import abcdatoz.code.daggerhiltshippuden.ui.clanes.ClanesScreen
import abcdatoz.code.daggerhiltshippuden.ui.firebase.FirebaseScreen
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.components.NinjaList
import abcdatoz.code.daggerhiltshippuden.ui.ninjas.components.NinjaOne
import abcdatoz.code.daggerhiltshippuden.ui.villas.LeVille
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun Navigation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.Clanes.route
    ) {

        composable((Routes.Clanes.route)) {
            ClanesScreen()
        }

        composable(route = Routes.Villas.route) {
            LeVille()
        }

        composable(route = Routes.Ninjas.route) {
            NinjaList(navController)
        }

        composable(
            route = Routes.NinjaOne.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })

        ) {
            NinjaOne(
                ninja = it.arguments?.getString("id"),
                navController
            )
        }

        composable( route = Routes.Firebase.route ){
            FirebaseScreen()
        }


    }
}