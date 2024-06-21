package abcdatoz.code.daggerhiltshippuden.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScreenABC(abcViewModel: ABCviewModel= viewModel(), modifier: Modifier = Modifier){
    val clanes by abcViewModel.clanes.observeAsState()
    val personajes by abcViewModel.personajes.observeAsState()
    val villas by abcViewModel.villas.observeAsState()


    LaunchedEffect (Unit) {
        abcViewModel.fetchData()

    }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween){
        personajes?.let{
            Text( "total de personajes ${it.characters.size}")
        }

        clanes?.let {
            Text( "total de clanes ${it.clans.size}")
        }

        villas?.let{
            Text( "total de villas ${it.villages.size}")
        }
        Text("CLanes teams and personajes")
    }
}
