package abcdatoz.code.daggerhiltshippuden.ui.firebase

import abcdatoz.code.daggerhiltshippuden.firebase.FirestoreManager
import abcdatoz.code.daggerhiltshippuden.firebase.RealtimeManager
import abcdatoz.code.daggerhiltshippuden.firebase.model.Note
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun NotesScreen(modifier: Modifier = Modifier) {

    var showAddNoteDialog by remember {
        mutableStateOf(false)
    }


    val firestore = FirestoreManager()

    val notes by firestore.getNotesFlow().collectAsState(emptyList())

    val scope = rememberCoroutineScope()



    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { showAddNoteDialog = true }) {
                Text(text = "Add...")
            }

            Button(onClick = { /*TODO*/ }) {
                Text("<-- back")

            }
        }

        if (showAddNoteDialog) {
            AddNoteDialog(onNoteAdded = { note ->
                scope.launch {
                    firestore.addNote(note)
                }
                showAddNoteDialog = false
            }, onDialogDismissed = { showAddNoteDialog = false })
        }




        if (!notes.isNullOrEmpty()) {


            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2), contentPadding = PaddingValues(4.dp)
            ) {

                notes.forEach {

                    item {
                        NoteItem(note = it, firestore = firestore)
                    }
                }
            }

        } else {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(Icons.Default.List, null, modifier.size(100.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "no se encontraron notas en BD",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Thin,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun AddNoteDialog(
    onNoteAdded: (Note) -> Unit, onDialogDismissed: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    AlertDialog(onDismissRequest = { /*TODO*/ },
        title = { Text("Agregar una nota!!!") },
        confirmButton = {
            Button(onClick = {

                val newNote = Note(titulo = title, contenido = content)

                onNoteAdded(newNote)

                title = ""
                content = ""


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
                TextField(value = title,
                    onValueChange = { title = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("Titulo") })

                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = content,
                    onValueChange = { content = it },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    label = { Text("Contenido") })
            }
        })


}

@Composable
fun NoteItem(note: Note, firestore: FirestoreManager) {

    var showDeleteDialog by remember { mutableStateOf(false) }

    val onDeleteNoteConfirmed: () -> Unit = {
        CoroutineScope(Dispatchers.Default).launch {
            firestore?.deleteNote(note.id ?: "")
        }
    }

    if (showDeleteDialog) {
        DeleteNoteDialog(
            onConfirmDelete = {
                onDeleteNoteConfirmed()
                showDeleteDialog = false
            },
            onDismiss = { showDeleteDialog = false }
        )
    }

    Card(modifier = Modifier.padding(6.dp)) {
        Column(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth())
        {

            Text(note.titulo, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(note.contenido, fontWeight = FontWeight.Thin, fontSize = 13.sp)
            IconButton(onClick = { showDeleteDialog = true }) {
                Icon(imageVector = Icons.Default.Delete, "Delete note")
            }

        }
    }

}


@Composable
fun DeleteNoteDialog(onConfirmDelete: () -> Unit, onDismiss: () -> Unit) {

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Eliminar Nota") },
        text = { Text("are you sure?") },
        confirmButton = {
            Button(onClick = onConfirmDelete) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss }) {
                Text(text = "Cancelar")
            }
        }
    )
}