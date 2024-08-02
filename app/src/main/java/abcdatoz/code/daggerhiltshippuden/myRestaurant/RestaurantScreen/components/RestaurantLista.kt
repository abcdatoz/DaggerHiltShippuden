package abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.components

import abcdatoz.code.daggerhiltshippuden.firestore.FirestoreManagerX
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RestaurantLista(firestore: FirestoreManagerX, modifier: Modifier = Modifier) {


    val restaurantes by firestore
        .getRestaurants()
        .collectAsState(emptyList())

    Column(modifier = modifier.fillMaxSize()) {


        if (!restaurantes.isNullOrEmpty()) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(4.dp)
            ) {

                restaurantes.forEach {
                    item{
                        RestaurantItem(item = it, firestore)
                    }
                }

            }
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(Icons.Default.List, null, modifier.size(100.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "No hay registros...",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Thin,
                    textAlign = TextAlign.Center
                )
            }
        }

    }


}


@Composable
@Preview(showBackground = true)
fun RestaurantListaPreview() {
    val firestoreManagerX = FirestoreManagerX()

    RestaurantLista(firestoreManagerX)
}

