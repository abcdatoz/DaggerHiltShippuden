package abcdatoz.code.daggerhiltshippuden.ui.villas.componentes

import abcdatoz.code.daggerhiltshippuden.data.model.Village
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VillasResume(
    lista: List<Village>,
    modifier: Modifier = Modifier) {

    val characters = lista.sumBy { it.characters.size}

    Row(
        modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = Color.Black)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Total Villas: ${lista.size}", color = Color.Yellow)
        Text("Characters: ${characters}", color = Color.Yellow)
    }

}

@Composable
@Preview(showBackground = true)
fun VillasResumePreview() {
    VillasResume(emptyList())
}
