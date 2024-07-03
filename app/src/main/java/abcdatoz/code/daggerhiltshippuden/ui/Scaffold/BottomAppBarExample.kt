package abcdatoz.code.daggerhiltshippuden.ui.Scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomAppBarExample() {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Check, "check")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Delete, "check")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Person, "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.List,"")
                    }


                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                        Icon(Icons.Filled.Add,"adding")
                    }
                }
            )

        }

    ) {

            Text(text = "lets have a toast for a good dayas...")

    }

}


@Preview(showBackground = true)
@Composable
fun BottomAppBarExamplePreview() {
    BottomAppBarExample()
}