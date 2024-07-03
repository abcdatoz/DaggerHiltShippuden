package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PageB(navController: NavController, modifier: Modifier = Modifier) {

    Row(
        modifier.fillMaxWidth().background(color = Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("Personajes")
    }
}


@Composable
@Preview(showBackground = true)
fun PageBPreview() {
    val nav = rememberNavController()
    PageB(nav)
}