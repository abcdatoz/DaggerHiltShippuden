package abcdatoz.code.daggerhiltshippuden.ui.clanes


import abcdatoz.code.daggerhiltshippuden.data.model.Clan
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.ClanViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClanesScreen(
     vm: ClanViewModel = viewModel(),
    modifier: Modifier = Modifier
){

    var state  by remember {
        mutableStateOf<List<Clan>>(emptyList())
    }

    LaunchedEffect (Unit){
        try{
            val registros = vm.getData().clans

            state = registros

        }catch (e:Exception){}
    }

    LazyColumn ()
    {
        state?.let { lista ->
            items(lista){klan ->
                LeCard(klan)

            }
        }
    }


//this way have so many error at loadindg, even crash tehe app
//    val clanVM = viewModel (modelClass = ClanesViewModel::class.java)//
//    val clanes by clanVM.clans.collectAsState()//
//    LazyColumn {
//        clanes?.let {lista ->
//            items (lista) { klan ->
//                LeCard(item = klan)
//            }
//        }
//    }



}


@Composable
@Preview(showBackground = true)
fun ClanesScreenPreview(){
    ClanesScreen()
}

@Composable
fun LeCard(item: Clan){
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
                Text("contiene :${ item.characters.count() } personajes")
                Text(item.id.toString())
            }
        }
    }
}