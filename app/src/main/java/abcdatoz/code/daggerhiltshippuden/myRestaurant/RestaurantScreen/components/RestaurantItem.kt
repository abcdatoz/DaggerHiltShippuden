package abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.components

import abcdatoz.code.daggerhiltshippuden.firestore.FirestoreManagerX
import abcdatoz.code.daggerhiltshippuden.firestore.models.Restaurant
import abcdatoz.code.daggerhiltshippuden.myRestaurant.Generics.DeleteDialog
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RestaurantItem(item: Restaurant, firestore: FirestoreManagerX) {

    var showDeleteDialog by remember {
        mutableStateOf(false)
    }

    val onDeleteConfirmed: () -> Unit = {
        Log.d("qwe", item.toString())
        CoroutineScope(Dispatchers.Default).launch {
            firestore?.deleteRestaurant(item.id ?: "")
        }
    }


    if (showDeleteDialog) {

        DeleteDialog(
            onConfirmDelete = { onDeleteConfirmed() },
            onDismiss = { showDeleteDialog = false },
            titulo = "Eliminar Restaurant"
        )

    }

    Card(modifier = Modifier.padding(6.dp)) {

        Column(
            modifier = Modifier
                .background(color = Color.Black)
                .padding(12.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {

            Text("Nombre: ${item.nombre}", color = Color.White)

            Spacer(modifier = Modifier.height(10.dp))
            Text("Direccion: ${item.direccion}", color = Color.White)

            IconButton(onClick = { showDeleteDialog = true }) {
                Icon(Icons.Default.Delete, "Eliminar Registro")
            }
        }

    }

}

