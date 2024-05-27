package abcdatoz.code.daggerhiltshippuden.ui.home

import abcdatoz.code.daggerhiltshippuden.data.model.Clan

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel




@Composable
fun HomeScreen(){

    val homeVM = viewModel (modelClass = HomeViewModel::class.java)

    val clans by homeVM.clans.collectAsState()
    //Log.e("qwe", clans.toString())

    LazyColumn {
        items (clans){clan ->
            LeCard(clan)
        }
    }



    
}




@Composable
fun LeCard(item: Clan){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
    ){
        Column{
            Text("image")
            Column  (modifier = Modifier.padding(10.dp)){
                Text(item.name)
                Text("contiene :${ item.characters.count() } personajes")
                Text(item.id.toString())
            }
        }
    }
}