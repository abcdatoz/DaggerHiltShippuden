package abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen

import abcdatoz.code.daggerhiltshippuden.firestore.FirestoreManagerX
import abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.components.RestaurantAdd
import abcdatoz.code.daggerhiltshippuden.myRestaurant.RestaurantScreen.components.RestaurantLista
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RestaurantScreen(modifier: Modifier = Modifier) {
    val firestore = FirestoreManagerX()

    var showAddDialog by remember { mutableStateOf(false) }
    val scope =  rememberCoroutineScope()

    Column(modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .height(70.dp)
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text("Lista de Restaurantes")




            Button(onClick = { showAddDialog = true }) {
                Text("+ add")
            }


            if(showAddDialog){
                RestaurantAdd(
                    onRestaurantAdded = { registro ->
                        scope.launch {
                            firestore.addRestaurant(registro)
                        }
                        showAddDialog = false
                    },
                    onDialogDismissed = { showAddDialog = false}
                )
            }



        }


        RestaurantLista(firestore)
    }
}


@Composable
@Preview(showBackground = true)
fun RestaurantScreenPreview() {
    RestaurantScreen()
}