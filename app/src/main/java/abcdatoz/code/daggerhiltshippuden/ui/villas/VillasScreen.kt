package abcdatoz.code.daggerhiltshippuden.ui.villas

import abcdatoz.code.daggerhiltshippuden.ui.villas.componentes.VillasLista
import abcdatoz.code.daggerhiltshippuden.ui.villas.componentes.VillasResume
import abcdatoz.code.daggerhiltshippuden.ui.villas.componentes.VillasTitulo
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun VillasScreen(modifier: Modifier = Modifier) {

    val villasVM =  viewModel (modelClass = VillasViewModel::class.java)

    val villas by villasVM.villages.collectAsState()

    Log.e("qwe", villas.toString())



    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            VillasTitulo(modifier)

            VillasLista(lista = villas, modifier)

            VillasResume(villas, modifier)
        }

    }


}


@Composable
@Preview(showBackground = true)
fun VillasScreenPreview() {
    VillasScreen()
}