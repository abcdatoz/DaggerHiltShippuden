package abcdatoz.code.daggerhiltshippuden.myRestaurant.Generics

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.firestore.FirestoreManagerX
import abcdatoz.code.daggerhiltshippuden.firestore.models.Restaurant
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantSelector(
    restaurantes: List<Restaurant>,
    selectedRestaurant: MutableState<String>
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Seleccione un restaurant") }


    val restauranteSeleccionado = restaurantes.find { it.id == selectedRestaurant.value }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center


        ) {

            ExposedDropdownMenuBox(

                expanded = expanded,
                onExpandedChange = { expanded = !expanded }) {


                TextField(
                    value = restauranteSeleccionado?.nombre ?: "Seleccione un restaurant",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )


                ExposedDropdownMenu(expanded = expanded,
                    modifier = Modifier.background(color = Color.White),
                    onDismissRequest = { expanded = false }) {

                    restaurantes.forEach { item ->

                        DropdownMenuItem(text = { Text(item.nombre) },
                            onClick = {
                                selectedRestaurant.value = item.id.toString()
                                selectedText = item.nombre
                                expanded = false
                            })
                    }
                }
            }
        }
    }


}


