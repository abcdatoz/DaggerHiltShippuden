package abcdatoz.code.daggerhiltshippuden.myRestaurant.Generics

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DeleteDialog(
    onConfirmDelete: () -> Unit,
    onDismiss: () -> Unit,
    titulo: String
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(titulo) },
        confirmButton = {
                        Button(onClick = {
                            onConfirmDelete()
                        }) {
                            Text("Aceptar")
                        }
        },
        dismissButton = {
                        Button(onClick = { onDismiss() }) {
                            Text("Cancelar")
                        }
        },
        text = { Text("Estas seguro de eliminar el registro?") }

    )
}