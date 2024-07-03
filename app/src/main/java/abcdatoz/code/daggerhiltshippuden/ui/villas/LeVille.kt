package abcdatoz.code.daggerhiltshippuden.ui.villas

import abcdatoz.code.daggerhiltshippuden.R
import abcdatoz.code.daggerhiltshippuden.data.model.Village
import abcdatoz.code.daggerhiltshippuden.data.model.VillagesModel
import abcdatoz.code.daggerhiltshippuden.data.viewmodels.VillageViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LeVille(
    viewmodel: VillageViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    var localstate by remember {
        mutableStateOf<List<Village>>(emptyList())
    }


    LaunchedEffect (Unit){
        try{

            val registros = viewmodel.getData().villages
            localstate = registros

        }catch(e:Exception){}
    }

    LazyColumn {

        localstate?.let { lista ->

            items(lista){vil->

                Box(
                    modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(120.dp)
                        .clip(RoundedCornerShape(20.dp))

                ) {

                    Column(
                        modifier
                            .fillMaxSize()
                            .background(color = colorResource(id = R.color.teal_200)),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {

                        Row(
                            modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, start = 10.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text("#${vil.id + 1}")
                        }
                        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text(
                                "${vil.villita}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Row(
                            modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                "Characters: ${vil.characters.size}",
                                fontSize = 8.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Thin
                            )
                        }


                    }


                }

            }
        }
    }


}