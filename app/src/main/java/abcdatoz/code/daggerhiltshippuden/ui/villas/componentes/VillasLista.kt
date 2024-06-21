package abcdatoz.code.daggerhiltshippuden.ui.villas.componentes


import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.data.model.Village
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("ResourceAsColor")
@Composable
fun VillasLista(
    lista: List<Village>,
    modifier: Modifier = Modifier
) {


    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(lista) {
            Box(
                modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(20.dp))

            ) {

                Column(
                    modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.teal_200)),
                    verticalArrangement = Arrangement.SpaceAround
                ) {

                    Row(
                        modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text("#${it.id + 1}")
                    }
                    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(
                            "${it.villita}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row(
                        modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            "Characters: ${it.characters.size}",
                            fontSize = 8.sp,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Thin
                        )
                    }


                }


            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun VillasListaPreview() {
    VillasLista(emptyList())
}