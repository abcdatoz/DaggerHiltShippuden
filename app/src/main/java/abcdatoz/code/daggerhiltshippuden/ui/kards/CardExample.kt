package abcdatoz.code.daggerhiltshippuden.ui.kards


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun CardExample(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

        StandardCard(
            elevation = 20.dp,
            background = configBackgroundColor(backgroundSelecction = "Amarillo"),
            shape = configShape(selection = "Redondeada")
        )
    }

}

@Composable
@Preview(showBackground = true)
fun CardExamplePreview() {
    CardExample()
}

@Composable
private fun configBackgroundColor(backgroundSelecction: String) =
    when (backgroundSelecction) {
        "Amarillo" -> Color(0xFFFFF176)
        "Azul" -> Color(0xFF64B5F6)
        "Rojo" -> Color(0xFFE57373)
        else -> Color.White
    }


@Composable
private fun configContentColor(contentColorSelection: String) = when (contentColorSelection) {
    "Gris Azulado" -> Color(0xFF263238)
    "Indigo" -> Color(0xFF1A237E)
    "Marron" -> Color(0xFF3e2723)
    else -> Color.Black
}


@Composable
private fun configShape(selection: String): Shape {
    val cornerSize = 30.dp

    return if (selection == "Redondeada")
        RoundedCornerShape(cornerSize)
    else
        CutCornerShape(cornerSize)
}

@Composable
fun StandardCard(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    background: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = MaterialTheme.shapes.medium
) {

    Card(
        elevation = CardDefaults.cardElevation(elevation),
        shape = shape,
        border = border,
        modifier = modifier.background(background),

        ) {
        Column(modifier = Modifier.background(configBackgroundColor(backgroundSelecction = "Rojo"))) {
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

                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data("https://static.wikia.nocookie.net/naruto/images/1/13/Sasuke_Part_2.png")
                            .crossfade(true)
                            .build(),
                        contentDescription = ""
                    )

                }

                Spacer(modifier = Modifier.width(32.dp))

                Column(Modifier.fillMaxWidth()) {
                    Text("Titulo", style = MaterialTheme.typography.headlineMedium)

                    Text("Textp secundario", style = MaterialTheme.typography.bodySmall)
                }

            }

            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data("https://static.wikia.nocookie.net/naruto/images/7/7d/Naruto_Part_II.png")
                    .crossfade(true)
                    .build(),
                contentDescription = "Multimedia de tarjeta",
                Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(194.dp)

            )

            Row(
                Modifier
                    .padding(start = 16.dp, end = 24.dp, top = 16.dp)
            ) {
                Text(
                    text = LoremIpsum(50).values.take(10).joinToString(separator = " "),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(Modifier.height(24.dp))

            Box(
                Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.align(Alignment.CenterStart)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Action A")

                    }
                    Spacer(Modifier.width(8.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Action B")
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


