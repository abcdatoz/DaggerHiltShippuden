package abcdatoz.code.daggerhiltshippuden.ui.ninjas.components

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.CharacterViewModel
import abcdatoz.code.daggerhiltshippuden.ui.Navigation.Routes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun NinjaList(
    navController: NavController,
    vm: CharacterViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    var state by remember { mutableStateOf<List<Character>>(emptyList()) }

    LaunchedEffect (Unit) {
        try{

            val registros = vm.getData().characters
            state = registros

        }catch (e:Exception){}
    }

    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){

        state?.let{ lista ->
            items(lista){
                NinjaCard(item = it,
                    onCardClick = {
                        navController.navigate(route =  Routes.NinjaOne.route + "/" + it.id.toString())
                    }

                )
            }

        }
    }


}



@Composable
@Preview(showBackground = true)
fun NinjaListPreview() {
    //NinjaList()
}