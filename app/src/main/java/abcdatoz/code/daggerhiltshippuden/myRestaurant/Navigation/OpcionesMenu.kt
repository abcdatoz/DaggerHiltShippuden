package abcdatoz.code.daggerhiltshippuden.myRestaurant.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class OpcionesMenu (
    val route: String,
    val icon: ImageVector
) {

    object Restaurant: OpcionesMenu( "Restaurant", Icons.Default.Home)
    object Categorias: OpcionesMenu("Categorias", Icons.Default.Menu)
    object Productos: OpcionesMenu("Productos",Icons.Default.List)
    object Mesas: OpcionesMenu("Mesas", Icons.Default.AccountCircle)
}