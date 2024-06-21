package abcdatoz.code.daggerhiltshippuden.ui.ninjas.components

import abcdatoz.code.daggerhiltshippuden.data.model.Character
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NinjaCard(
    item: Character ,
    modifier: Modifier = Modifier
){


    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier.padding(horizontal = 16.dp)
        ) {
        Column(modifier = Modifier.background(Color(0xFFE57373))) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp)
            ) {

                //Miniature
                Box(
                    modifier = Modifier
                        .background(color = Color.LightGray, shape = CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {


                    if (item.images.size > 0){

                        AsyncImage(
                            model = ImageRequest
                                .Builder(LocalContext.current)
                                .data(item.images[0])
                                .crossfade(true)
                                .build(),
                            contentDescription = ""
                        )
                    }


                }

                Spacer(modifier = Modifier.width(32.dp))

                Column(Modifier.fillMaxWidth()) {
                    Text(item.name, style = MaterialTheme.typography.headlineMedium)

                    item.natureType?.let {nats ->
                        Text(nats.toString())
                    }

                }

            }

            if (item.images.size > 0) {


                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(item.images[item.images.size - 1])
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    Modifier
                        .background(color = Color.LightGray)
                        .fillMaxWidth()
                        .height(194.dp)
                )

            }
            Row(
                Modifier
                    .padding(start = 16.dp, end = 24.dp, top = 16.dp)
            ) {

                item.tools?.let {toolss ->
                    Text(
                        text = toolss.toString(),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


            }

            Spacer(Modifier.height(24.dp))

            Box(
                Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.align(Alignment.CenterStart)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Jutsus")

                    }
                    Spacer(Modifier.width(8.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Naturaleza")
                    }
                }

                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Favorite, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Share, contentDescription = null)
                    }
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun NinjaCardPreview(){
    //NinjaCard()
}