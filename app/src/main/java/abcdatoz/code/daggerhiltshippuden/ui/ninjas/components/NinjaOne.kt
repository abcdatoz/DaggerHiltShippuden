package abcdatoz.code.daggerhiltshippuden.ui.ninjas.components

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NinjaOne(
    ninja: Character,
    modifier:Modifier = Modifier){

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Text(ninja.id.toString())
        Text(ninja.name)
        Text(ninja.tools.toString())
    }
}

@Composable
@Preview(showBackground = true)
fun NinjaOnePreview(){


}
