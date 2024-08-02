package abcdatoz.code.daggerhiltshippuden.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.hsl
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenD(modifier: Modifier = Modifier){

    var isVisible by remember {
        mutableStateOf(true)
    }


    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){

        Button(onClick = { isVisible = !isVisible}){
            Text("Togglea")
        }

        if (isVisible){
            Box(modifier.size(100.dp).background(color = Color.DarkGray)){
                Text("componente Gris")
            }
        }

        if (!isVisible){
            Box(modifier.size(100.dp).background(color = Color.Blue )){
                Text("componente no gris")
            }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun ScreenDPreview(){
    ScreenD()
}