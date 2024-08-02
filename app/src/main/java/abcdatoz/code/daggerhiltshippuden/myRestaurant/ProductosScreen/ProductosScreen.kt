package abcdatoz.code.daggerhiltshippuden.myRestaurant.ProductosScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductosScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lista de Productos")

        Column (modifier = Modifier.fillMaxSize().background(color = Color.Yellow)){
            Text("* aa")
            Text("* BB")
            Text("* cc")
        }

    }

}

@Composable
@Preview(showBackground = true)
fun ProductosScreenPreview() {
    ProductosScreen()
}