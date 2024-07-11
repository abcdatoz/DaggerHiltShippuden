package abcdatoz.code.daggerhiltshippuden.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenFamily(modifier: Modifier = Modifier) {


    var properties = listOf(
        "","","","greatGrandfather","",
        "","","grandfather","","grandmother",
        "","mother","","","",
        "","","brother","sister","",
        "","father","","uncle","aunt",
        "me","","","","nephew",
        "lover","wife","","","niece",
        "","","daugther","","",
        "pet","","","grandson","granddaughter",
        "","","son","","",
        "","","","",""
    )


    var listaa = listOf("pet","","","grandson","granddaughter")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(5),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//
//
//            properties.forEachIndexed { index, item ->
//
//                item {
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(50.dp)
//                            //.background( color = if ((index / 5 + index % 5) % 2 == 0) Color.Green else Color.Yellow)
//                    ){
//                        Text(item)
//                    }
//
//                }
//
//            }
//
//        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){

            listaa.forEach {item ->
                Box(modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Green)){
                    Text(item)
                }
            }

        }
    }


//            items(42) { index ->
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(100.dp)
//                        .background(
//                            color = if ((index / 6 + index % 6) % 2 == 0) Color.Green else Color.Yellow
//                        )
//                )
//            }


}

@Composable
@Preview(showBackground = true)
fun ScreenFamilyPreview() {
    ScreenFamily()
}