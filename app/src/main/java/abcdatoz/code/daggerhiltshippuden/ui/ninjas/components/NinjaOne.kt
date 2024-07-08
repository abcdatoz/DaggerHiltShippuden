package abcdatoz.code.daggerhiltshippuden.ui.ninjas.components

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.CharacterViewModel
import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NinjaOne(
    ninja: String?,
    navigation: NavController,
    viewmodel: CharacterViewModel = viewModel(),
    modifier: Modifier = Modifier
) {


    var state by remember {
        mutableStateOf<Character?>(null)
    }

    LaunchedEffect(Unit) {

        try {

            val obj = ninja?.let { viewmodel.getOne(it) }
            Log.d("nojutsu", obj.toString())
            state = obj

        } catch (e: Exception) {
        }

    }
    Column(modifier = Modifier.fillMaxSize()) {
        state?.let { it ->
            NinjaHeader(ninja = it, navigation = navigation)
        }


        LazyColumn(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {

            state?.let { chunnin ->

                item {


                }

                if (chunnin.jutsu.size > 0) {
                    item {
                        JutsusList(lista = chunnin.jutsu)
                    }
                }

                if (chunnin.natureType.size > 0) {
                    item {
                        NatureTypeList(lista = chunnin.natureType)
                    }
                }

            }


        }

    }


}

@Composable
@Preview(showBackground = true)
fun NinjaOnePreview() {


}


@Composable
fun NinjaHeader(ninja: Character, navigation: NavController, modifier: Modifier = Modifier) {

    Column(
        modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier
                .fillMaxWidth()
                .background(color = Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {

            IconButton(onClick = {
                navigation.popBackStack()
            }, colors = IconButtonDefaults.iconButtonColors(Color.Green)) {
                Icon(Icons.Filled.Close, "", Modifier.size(20.dp))
            }

            Text(ninja.name, fontSize = 20.sp, color = Color.White)

            Text(text = "# ${ninja.id}", color = Color.LightGray)
        }

    }

    Row(
        modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        if (ninja.images.size > 0) {

            Box(
                modifier = modifier.size(120.dp), contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(ninja.images[0])
                        .crossfade(true)
                        .build(),
                    contentDescription = "image 1"
                )
            }
        }

        if (ninja.images.size > 1) {

            Box(
                modifier = modifier
                    .background(color = Color.Black)
                    .size(120.dp), contentAlignment = Alignment.Center

            ) {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(ninja.images[1])
                        .crossfade(true)
                        .build(),
                    contentDescription = "image 2",
                    modifier = Modifier.clip(CircleShape)



                )
            }
        }

    }
}


@Composable
fun JutsusList(lista: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text("Jutsus: ", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        lista.forEach { jut ->
            Text(
                jut,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }


    }
}

@Composable
fun NatureTypeList(lista: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Nature Types: ", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))

        lista.forEach { item ->
            Text(
                item,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}