package abcdatoz.code.daggerhiltshippuden.ui.screens

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.CharacterViewModel
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ScreenC(characterViewModel: CharacterViewModel = viewModel(), modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf<List<Character>>(emptyList()) }

    val opcionesSubmenu =
        listOf("Home", "Villas", "Personajes", "Clanes", "Jutsus", "otro", "y otro")

    LaunchedEffect(Unit) {
        try {
            val personajes = characterViewModel.getData().characters
            state = personajes
            Log.d("qwe", personajes.toString())
        } catch (e: Exception) {
        }
    }

    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Personajes Begin")


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .weight(1f)
        ) {

            state?.let { lista ->

                items(lista) {
                    LeCard(item = it)
                }

            }

        }


        SubMenu(lista = opcionesSubmenu)
    }


}


@Composable
fun LeCard(item: Character) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier
            .size(width = 240.dp, height = 240.dp).padding(5.dp)

    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = item.name)

            if (item.images.size > 0){

                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(item.images[0].toString())
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RectangleShape).size(100.dp)
                )

            }



            item.natureType?.let {nats ->
                Text(nats.toString())

            }



        }

    }
}


@Composable
fun SubMenu(lista: List<String>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = MaterialTheme.colorScheme.primary,
        shadowElevation = 8.dp
    ) {


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(lista.size) { ndx ->

                Text(text = lista[ndx], modifier = Modifier.padding(horizontal = 15.dp))

            }
        }

    }
}

