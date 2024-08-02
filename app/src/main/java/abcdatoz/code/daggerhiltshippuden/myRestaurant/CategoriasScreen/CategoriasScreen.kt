package abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.R.color.fondo
import abcdatoz.code.daggerhiltshippuden.firestore.FirestoreManagerX
import abcdatoz.code.daggerhiltshippuden.firestore.models.Categoria
import abcdatoz.code.daggerhiltshippuden.firestore.repos.CategoriaRepository
import abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.components.CategoriaLista
import abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.components.CategoriaNueva
import abcdatoz.code.daggerhiltshippuden.myRestaurant.Generics.RestaurantSelector
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun CategoriasScreen(modifier: Modifier = Modifier) {

    val firestore = FirestoreManagerX()
    val categoryRepo = CategoriaRepository()

    val restaurantes by firestore.getRestaurants().collectAsState(emptyList())
    var selectedRestaurant = remember { mutableStateOf("") }

    var showAddDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    fun handleOnClick(registro: Categoria) {
        scope.launch {
            categoryRepo.addCategoria(registro)
        }
        showAddDialog = false
    }

    Column(modifier.fillMaxSize().background(Color.Black), verticalArrangement = Arrangement.SpaceBetween) {

        Box(
            modifier = Modifier
                .padding(10.dp)


        ) {
            RestaurantSelector(restaurantes, selectedRestaurant)
        }




        if (selectedRestaurant.value != "") {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { showAddDialog = true }) {
                    Text("+ Categoria")
                }
            }

        }



        CategoriaLista(categoryRepo, selectedRestaurant, modifier = Modifier.weight(1f))



        if (showAddDialog) {
            CategoriaNueva(
                onCategoryAdded = { handleOnClick(it) },
                onDialogDismissed = { showAddDialog = false },
                selectedRestaurant
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CategoriasScreenPreview() {
    CategoriasScreen()
}