package abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.components

import abcdatoz.code.daggerhiltshippuden.firestore.models.Categoria
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CategoriaNueva(
    onCategoryAdded: (Categoria) -> Unit,
    onDialogDismissed: () -> Unit,
    selectedRestaurant: MutableState<String>
){
    var clave by remember { mutableStateOf("")    }
    var nombre by remember { mutableStateOf("")    }
    var imagen by remember { mutableStateOf("")    }

    AlertDialog(
        onDismissRequest = { /*TODO*/ } ,
        title = {Text("Agregar categoria")},
        confirmButton = {
                        Button(onClick = {

                            val newCategory = Categoria(
                                clave = clave,
                                nombre = nombre,
                                imagen = imagen,
                                idRestaurant = selectedRestaurant.value
                            )

                            onCategoryAdded(newCategory)

                            clave = ""
                            nombre = ""
                            imagen = ""

                        }) {
                            Text("Aceptar")
                        }
        },
        dismissButton = {
            Button(onClick = { onDialogDismissed ()}) {
                Text("Cancelar")
            }
        },
        text = {
            Column{
                TextField(value = clave, onValueChange = { clave = it }, label = {Text("clave")})
                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = nombre, onValueChange = { nombre = it }, label = {Text("nombre")})
                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = imagen, onValueChange = { imagen = it }, label = {Text("imagen")})


            }
        }
    )
}