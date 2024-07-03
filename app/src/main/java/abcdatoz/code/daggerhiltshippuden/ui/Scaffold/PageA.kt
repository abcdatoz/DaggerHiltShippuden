package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun PageA(navController: NavController, modifier: Modifier = Modifier) {

    Column(
        modifier.fillMaxSize().background(color = Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text("Villas")
    }
}

@Composable
@Preview(showBackground = true)
fun PageAPreview() {
    val nav = rememberNavController()
    PageA(nav)
}