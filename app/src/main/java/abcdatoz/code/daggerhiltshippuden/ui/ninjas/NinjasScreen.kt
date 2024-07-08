package abcdatoz.code.daggerhiltshippuden.ui.ninjas

import abcdatoz.code.daggerhiltshippuden.ui.ninjas.components.NinjaList
import abcdatoz.code.daggerhiltshippuden.ui.screens.SubMenu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NinjasScreen(modifier: Modifier = Modifier) {
    val opcionesSubmenu =
        listOf("Home", "Villas", "Personajes", "Clanes", "Jutsus")

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Header")

        //NinjaList(modifier = Modifier.weight(1f))

//        SubMenu(lista = opcionesSubmenu)
    }
}

@Composable
@Preview(showBackground = true)
fun NinjasScreenPreview() {
    NinjasScreen()
}
