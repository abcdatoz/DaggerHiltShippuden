package abcdatoz.code.daggerhiltshippuden.myRestaurant.Navigation

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.myRestaurant.MainNavigation
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Scaffold(
        topBar = { Header() },
        bottomBar = { Footer(navController = navController) },
        floatingActionButton = {}

    ) {
        Column(modifier = modifier.padding(top = 60.dp, bottom = 66.dp)) {

            MainNavigation(navController = navController, modifier = Modifier.weight(1f))
        }
    }

}


@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    TopAppBar(
        title = { Text("Resto al pesto Prest0...") },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            titleContentColor = Color.White
        )
    )
}

@Composable
fun Footer(navController: NavHostController) {

    val bottomNavigationItems = listOf(
        OpcionesMenu.Restaurant,
        OpcionesMenu.Categorias,
        OpcionesMenu.Productos,
        OpcionesMenu.Mesas,
        OpcionesMenu.Categorias,
        OpcionesMenu.Productos,
        OpcionesMenu.Mesas,
        OpcionesMenu.Categorias,
        OpcionesMenu.Productos,
        OpcionesMenu.Mesas
    )

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
        contentColor = Color.White
    ) {
        LazyRow {
            items(bottomNavigationItems) {
                Button(
                    onClick = { navController.navigate(it.route) },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.fondo) )

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(it.icon, it.route)
                        Text(it.route)
                    }

                }
            }
        }
    }
}
