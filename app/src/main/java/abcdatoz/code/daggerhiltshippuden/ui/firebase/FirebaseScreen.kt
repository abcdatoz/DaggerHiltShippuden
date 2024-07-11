package abcdatoz.code.daggerhiltshippuden.ui.firebase

import abcdatoz.code.daggerhiltshippuden.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter

@Composable
fun FirebaseScreen(modifier: Modifier = Modifier) {

    val painter = rememberImagePainter(R.drawable.ic_firebase)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painter, contentDescription = "")
    }
}


@Composable
@Preview(showBackground = true)
fun FirebaseScreenPreview() {
    FirebaseScreen()
}
