package abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.components

import abcdatoz.code.daggerhiltshippuden.firestore.models.Categoria
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CategoriaUpdate(
    category: Categoria,
    onCategoryUpdated: (Categoria) -> Unit,
    onDialogDismissed: () -> Unit,

    ){

    var clave by remember {mutableStateOf(category.clave)    }
    var nombre by remember {mutableStateOf(category.nombre)    }
    var imagen by remember {mutableStateOf(category.imagen)    }

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Actualizar categoria")},
        confirmButton ={
                       Button(onClick = {

                           category.clave = clave
                           category.nombre = nombre
                           category.imagen = imagen

                           onCategoryUpdated(category)

                           clave=""
                           nombre=""
                           imagen=""

                       }) {
                           Text("Aceptar")
                       }
        },
        dismissButton = {
                        Button(onClick = { onDialogDismissed() }) {
                            Text("Cancelar")
                        }
        },
        text = {
            Column {
                TextField(value = clave, onValueChange = { clave = it}, label = {  Text("Clave") })
                Spacer(Modifier.height(8.dp))
                TextField(value = nombre, onValueChange = { nombre = it}, label = {  Text("Nombre") })
                Spacer(Modifier.height(8.dp))
                TextField(value = imagen, onValueChange = { imagen = it}, label = {  Text("Imagen") })
            }
        }
    )
}
