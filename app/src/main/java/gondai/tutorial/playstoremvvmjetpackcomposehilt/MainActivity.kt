package gondai.tutorial.playstoremvvmjetpackcomposehilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.playstore.PlayStoreScreen
import gondai.tutorial.playstoremvvmjetpackcomposehilt.ui.theme.PlayStoreMVVMJetpackComposeHiltTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayStoreMVVMJetpackComposeHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    PlayStoreScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlayStoreMVVMJetpackComposeHiltTheme {
        Greeting("Android")
    }
}