package abcdatoz.code.daggerhiltshippuden.ui.characters

import abcdatoz.code.daggerhiltshippuden.ui.characters.CharactersViewModel
import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.ui.clanes.ClanesViewModel
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharactersScreen(modifier: Modifier = Modifier){
        val vm = viewModel (modelClass = CharactersViewModel::class.java)


    val registros by vm.personajes.collectAsState()

    Log.d("qwe", registros.toString())

    LazyColumn {
        items (registros) { xx ->
            LeCard(item = xx)
        }
    }
}



@Composable
fun LeCard(item: Character){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxSize()
    ){
        Column{
            Text("image")
            Column  (modifier = Modifier.padding(10.dp)){
                Text(item.name)
                Text("contiene :${ item.jutsu.size } jutsus")
                Text("contiene :${ item.tools.size } tools")
                Text("contiene :${ item.images.size } imagenes")

            }
        }
    }
}