package abcdatoz.code.daggerhiltshippuden.ui.screens

import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.VillageViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ScreenB(villageViewModel:VillageViewModel = viewModel(), modifier: Modifier = Modifier){

    var state by remember {
        mutableStateOf<VillagesModel?>(null)
    }

    LaunchedEffect(Unit) {
        try{

            val registros = villageViewModel.getData()
            state = registros

        }catch (e:Exception){}
    }

    Column(modifier.fillMaxWidth()){
        Text("La villta")

        LazyColumn(modifier.fillMaxSize()){
            state?.let{

                items(it.villages){ vil ->
                    Text("la villa ${ vil.id } se llama ${vil.villita} y tiene ${vil.characters.size} ninjas")
                }
            }
        }
    }

}

