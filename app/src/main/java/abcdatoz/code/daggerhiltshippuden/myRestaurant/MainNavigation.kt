package abcdatoz.code.daggerhiltshippuden.myRestaurant

import abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.CategoriasScreen
import abcdatoz.code.daggerhiltshippuden.myRestaurant.MesasScreen.MesasScreen
import abcdatoz.code.daggerhiltshippuden.myRestaurant.Navigation.OpcionesMenu
import abcdatoz.code.daggerhiltshippuden.myRestaurant.ProductosScreen.ProductosScreen
import abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.RestaurantScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigation(
    navController:NavController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController as NavHostController, startDestination = OpcionesMenu.Restaurant.route){

        composable(OpcionesMenu.Restaurant.route){
            RestaurantScreen()
        }

        composable(OpcionesMenu.Categorias.route){
            CategoriasScreen()
        }

        composable(OpcionesMenu.Productos.route){
            ProductosScreen()
        }

        composable(OpcionesMenu.Mesas.route){
            MesasScreen()
        }
    }
}