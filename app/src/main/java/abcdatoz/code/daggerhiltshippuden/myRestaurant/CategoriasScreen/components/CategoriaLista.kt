package abcdatoz.code.daggerhiltshippuden.myRestaurant.CategoriasScreen.components

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.firestore.repos.CategoriaRepository
import abcdatoz.code.daggerhiltshippuden.myRestaurant.Generics.DeleteDialog
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CategoriaLista(
    repo: CategoriaRepository,
    selectedRestaurant: MutableState<String>,
    modifier: Modifier = Modifier
) {

    val categorias by repo
        .getCategorias()
        .collectAsState(emptyList())

    val categoriasByRestaurant = categorias.filter { it.idRestaurant == selectedRestaurant.value }

    val backgroundImage: Painter = painterResource(id = R.drawable.ic_firebase)
    val scope = rememberCoroutineScope()
    var idCategory by remember { mutableStateOf("") }


    var showUpdateDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    val onUpdateConfirmed: (id: String) -> Unit = { id ->

        var cat = categoriasByRestaurant.find { it.id == id }

        scope.launch {
            cat?.let {
                repo.updateCategoria(it)
            }
        }
        showUpdateDialog = false
    }

    val onDeleteConfirmed: (id: String) -> Unit = { id ->

        scope.launch {
            repo.deleteCategoria(id)
        }

        showDeleteDialog = false
    }

    if (showUpdateDialog) {
        var cat = categoriasByRestaurant.find { it.id == idCategory }

        cat?.let {
            CategoriaUpdate(
                category = cat,
                onCategoryUpdated = { onUpdateConfirmed(idCategory) },
                onDialogDismissed = { showUpdateDialog = false })


        }
    }

    if (showDeleteDialog) {
        DeleteDialog(
            onConfirmDelete = { onDeleteConfirmed(idCategory) },
            onDismiss = { showDeleteDialog = false },
            titulo = "Eliminar categoria"
        )
    }







    Column(
        modifier.fillMaxWidth()
    ) {

        if (categorias.isNullOrEmpty()) {

            NoCategories()

        } else {

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                contentPadding = PaddingValues(4.dp)
            ) {

                categoriasByRestaurant.forEach { cat ->
                    item {
                        Card(modifier = Modifier.padding(4.dp)) {
                            Box(modifier = Modifier.fillMaxSize()) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(colorResource(id = R.color.fondo))
                                        .padding(10.dp)
                                        .height(170.dp),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .background(Color.White, shape = CircleShape)
                                            .padding(5.dp)
                                    )
                                    {
                                        Text(cat.clave, color = Color.Red)
                                    }

                                    Spacer(modifier = Modifier.height(5.dp))



                                    Text(
                                        cat.nombre,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        fontSize = 22.sp,
                                        fontStyle = FontStyle.Italic,
                                        color = Color.White
                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {


                                        IconButton(onClick = {

                                            idCategory = cat.id.toString()
                                            showUpdateDialog = true

                                        }) {
                                            Icon(
                                                Icons.Default.Edit,
                                                contentDescription = "Editar",
                                                tint = Color.White
                                            )
                                        }

                                        Spacer(modifier = Modifier.size(5.dp))

                                        IconButton(onClick = {

                                            idCategory = cat.id.toString()
                                            showDeleteDialog = true

                                        }) {
                                            Icon(
                                                Icons.Default.Delete,
                                                contentDescription = "Eliminar",
                                                tint = Color.White
                                            )
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

    }
}


@Composable
fun NoCategories() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.List, null, modifier = Modifier.size(100.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text("No hay categorias...", fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}