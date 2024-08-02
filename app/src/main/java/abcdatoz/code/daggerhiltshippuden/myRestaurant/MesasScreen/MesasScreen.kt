package abcdatoz.code.daggerhiltshippuden.myRestaurant.MesasScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MesasScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mesas")

        Column (modifier = Modifier.fillMaxWidth()){
            Text("Mesa 1")
            Text("Mesa 2")
            Text("Mesa 3")
        }

    }

}

@Composable
@Preview(showBackground = true)
fun MesasScreenPreview() {
    MesasScreen()
}