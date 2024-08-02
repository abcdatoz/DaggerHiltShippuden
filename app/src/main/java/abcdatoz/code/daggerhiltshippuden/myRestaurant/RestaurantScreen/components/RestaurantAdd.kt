package abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.components

import abcdatoz.code.daggerhiltshippuden.firestore.models.Restaurant
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantAdd(
    onRestaurantAdded: (Restaurant) -> Unit,
    onDialogDismissed: () -> Unit
) {

    var nombre by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var logoUrl by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Agregar Restaurant") },
        confirmButton = {
            Button(onClick = {
                val newRestaurant =
                    Restaurant(nombre = nombre, direccion = direccion, urlLogo = logoUrl)
                onRestaurantAdded(newRestaurant)

                nombre = ""
                direccion = ""
                logoUrl = ""


            }) {
                Text("Agregar")
            }
        },
        dismissButton = {
            Button(onClick = { onDialogDismissed() }) {
                Text("Cancelar")
            }
        },
        text = {

            Column {
                TextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("Nombre") }
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = direccion,
                    onValueChange = { direccion = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("Direccion") }
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = logoUrl,
                    onValueChange = { logoUrl = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("url Logo") }
                )

            }
        }
    )
}