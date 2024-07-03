package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PageC(navController: NavController, modifier: Modifier = Modifier) {


    Column(
        modifier
            .fillMaxSize()
            .background(color = Color.Cyan),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            "CLANS",
            modifier
                .fillMaxWidth()
                .background(color = Color.Green),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        Text("PQR")
        Text("xyz")
        Text("123")
        Text("lalalang")
    }
}

@Composable
@Preview(showBackground = true)
fun PageCPreview() {
    val nav = rememberNavController()
    PageC(nav)
}