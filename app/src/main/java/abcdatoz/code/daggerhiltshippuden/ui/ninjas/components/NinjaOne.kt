package abcdatoz.code.daggerhiltshippuden.ui.ninjas.components

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.model.Family
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
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

    var tabId by remember {
        mutableStateOf(0)
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

        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { tabId = 0 }) {
                Text("Jutsus")
            }
            Button(onClick = { tabId = 1 }) {
                Text("Nature Types")
            }

            Button(onClick = { tabId = 2 }) {
                Text("Tools")
            }

            Button(onClick = { tabId = 3 }) {
                Text("Family")
            }


        }

        LazyColumn(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {

            state?.let { chunnin ->


                if (chunnin.jutsu.size > 0 && tabId == 0) {
                    item {
                        JutsusList(lista = chunnin.jutsu)
                    }
                }

                if (chunnin.natureType.size > 0 && tabId == 1) {
                    item {
                        NatureTypeList(lista = chunnin.natureType)
                    }
                }

                if (chunnin.tools.size > 0 && tabId == 2) {
                    item {
                        ToolsList(lista = chunnin.tools)
                    }
                }


                if (tabId == 3) {
                    chunnin.family?.let { fam ->
                        item {
                            GenealogicTree(chunnin.name, fam)
                        }
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


@Composable
fun ToolsList(lista: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Tools", fontSize = 25.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))

        lista.forEach { tool ->
            Text(
                tool,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }
}


@Composable
fun GenealogicTree(me: String, family: Family) {


    var lineA = listOf("", "", "", "greatGrandfather", "")
    var lineB = listOf("", "", "grandfather", "", "grandmother")
    var lineC = listOf("", "mother", "", "", "")
    var lineD = listOf("", "", "brother", "sister", "")
    var lineE = listOf("", "father", "", "uncle", "aunt")
    var lineF = listOf("me", "", "", "", "nephew")
    var lineG = listOf("lover", "wife", "", "", "niece")
    var lineH = listOf("", "", "daughter", "", "")
    var lineI = listOf("pet", "", "", "grandson", "granddaughter")
    var lineJ = listOf("", "", "son", "", "")


    var greats = listOf("greatGrandfather")
    var grandpas = listOf("grandfather", "grandmother")
    var parents = listOf("father", "mother")
    var sibblings = listOf("brother", "sister")

    var lovers = listOf("wife", "lover")
    var child = listOf("daughter", "son")
    var grandchild = listOf("granddaughter", "grandson")

    var auntanduncle = listOf("uncle", "aunt")
    var primos = listOf("niece", "nephew")
    var pet = listOf("pet")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {


        AddLine(header = "Greats", elements = greats, family = family)
        AddLine(header = "GrandParents", elements = grandpas, family = family)
        AddLine(header = "Parents", elements = parents, family = family)
        AddLine(header = "Sibblings", elements = sibblings, family = family)
        AddLine(header = "Lovers", elements = lovers, family = family)
        AddLine(header = "Child", elements = child, family = family)
        AddLine(header = "GrandChild", elements = grandchild, family = family)
        AddLine(header = "uncles", elements = auntanduncle, family = family)
        AddLine(header = "primos", elements = primos, family = family)


    }
}

@Composable
fun AddLine(header: String, elements: List<String>, family: Family) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(50.dp)
                .padding(10.dp)
                .background(color = Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {

            Text(header, fontSize = 13.sp)
        }

        elements.forEach { element ->


            val valor = family::class.java
                .getDeclaredField(element)
                .apply { isAccessible = true }
                .get(family)

            Box(contentAlignment = Alignment.Center) {
                valor?.let {
                    Column(
                        verticalArrangement = Arrangement.Top
                    ) {

                        Text(it.toString(), fontSize = 16.sp)
                        Text("( ${element} )", color = Color.Gray, fontSize = 13.sp)

                    }

                }
            }

        }
    }
}

@Composable
fun AddRow(lista: List<String>, family: Family, me: String = "") {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        lista.forEach { element ->

            if (element == "") {
                Box(modifier = Modifier.size(50.dp)) {
                    Text("")
                }
            } else if (element == "me") {
                Box(modifier = Modifier.size(50.dp)) {
                    Text(me, color = Color.Green)
                }
            } else {
                val valor =
                    family::class.java.getDeclaredField(element).apply { isAccessible = true }
                        .get(family)

                Box(modifier = Modifier.size(50.dp)) {
                    valor?.let {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Top
                        ) {

                            Text(it.toString().length.toString(), fontSize = 12.sp)

                            Text("( ${element} )", fontSize = 12.sp, color = Color.Gray)
                        }

                    }
                }
            }

        }

    }
}