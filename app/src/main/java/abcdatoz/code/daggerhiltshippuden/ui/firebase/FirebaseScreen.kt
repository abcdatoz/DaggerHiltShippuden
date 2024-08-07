package abcdatoz.code.daggerhiltshippuden.ui.firebase

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.firebase.RealtimeManager
import abcdatoz.code.daggerhiltshippuden.firebase.model.Contact
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun FirebaseScreen(modifier: Modifier = Modifier) {

    val painter = rememberImagePainter(R.drawable.ic_firebase)


    val realtime = RealtimeManager()

    var showAddContactDialog by remember {
        mutableStateOf(false)
    }
    val contactos by realtime.getContactsFlow().collectAsState(emptyList())

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        IconButton(onClick = {
            showAddContactDialog = true
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
        }

        if (showAddContactDialog) {
            AddContactDialog(onContactAdded = { contact ->
                realtime.addContact(contact)
                showAddContactDialog = false
            },
                onDialogDismissed = { showAddContactDialog = false }
            )
        }

        Image(painter = painter, contentDescription = "", modifier = Modifier.size(100.dp))

        LazyColumn {
            contactos.forEach { contacto ->
                item {
                    ContactItem(contact = contacto, realtime = realtime)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun FirebaseScreenPreview() {
    FirebaseScreen()
}


@Composable
fun ContactItem(contact: Contact, realtime: RealtimeManager) {
    var showDeletedContactDialog by remember { mutableStateOf(false) }

    val onDeleteContactConfirmed: () -> Unit = {
        realtime.deleteContact(contact.key ?: "")
    }

    if (showDeletedContactDialog) {
        DeleteContactDialog(
            onConfirmDelete = {
                onDeleteContactConfirmed()
                showDeletedContactDialog = false
            },
            onDismiss = {
                showDeletedContactDialog = false
            }

        )
    }


    Card(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 0.dp)
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = contact.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = contact.phoneNumber,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = contact.email,
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    showDeletedContactDialog = true
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")

                }
            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    onContactAdded: (Contact) -> Unit,
    onDialogDismissed: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var uid = "guid.newid"

    AlertDialog(
        onDismissRequest = {},
        title = { Text("Agregar contacto") },
        confirmButton = {
            Button(
                onClick = {
                    val newContact = Contact(
                        name = name,
                        phoneNumber = phoneNumber,
                        email = email,
                        uid = uid.toString()
                    )

                    onContactAdded(newContact)

                    name = ""
                    phoneNumber = ""
                    email = ""
                }
            ) {
                Text("+ Agregar")
            }
        },

        dismissButton = {
            Button(
                onClick = {
                    onDialogDismissed()
                }
            ) {
                Text(text = "Cancelar")
            }
        },

        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("Nombre") })

                Spacer(Modifier.height(8.dp))

                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                    label = { Text("Telefono") })

                Spacer(Modifier.height(8.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    label = { Text("correo") })
            }
        }
    )
}


@Composable
fun DeleteContactDialog(onConfirmDelete: () -> Unit, onDismiss: () -> Unit) {

    AlertDialog(
        onDismissRequest = { onDismiss },
        title = { Text("Eliminar Contacto") },
        text = { Text("Are you sure to delete this contact?") },
        confirmButton = {
            Button(onClick = onConfirmDelete) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}