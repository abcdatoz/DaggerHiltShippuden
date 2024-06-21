package abcdatoz.code.daggerhiltshippuden.ui.screens

import abcdatoz.code.daggerhiltshippuden.data.model.Clan
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.ClanViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ScreenA(clanViewModel: ClanViewModel = viewModel(),  modifier : Modifier = Modifier){

    var state by remember { mutableStateOf<List<Clan>>(emptyList())    }

    LaunchedEffect (Unit){
        try{
            val clanes = clanViewModel.getData().clans
            state = clanes

        }catch (e:Exception){}
    }


    Column(modifier.fillMaxSize()) {
        Text("Clanes")

        LazyColumn (modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween){

            state?.let {
                items(it) {klan ->
                    Text(klan.name)
                }
            }
        }

    }

}