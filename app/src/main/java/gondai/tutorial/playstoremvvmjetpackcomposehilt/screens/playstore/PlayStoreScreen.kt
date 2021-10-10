package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.playstore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product.ProductView

@Composable
fun PlayStoreScreen(model:PlayStoreViewModel= hiltViewModel()){
   val state by model.uiState.collectAsState()
     Scaffold {
         innerPadding ->
         when(state)
         {
             is PlayStoreState.Failed ->Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center,
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(innerPadding)
             ) {
                 Text((state as PlayStoreState.Failed).message ?: "Unknown Error")
             }
             PlayStoreState.InProgress -> Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center,
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(innerPadding)
             ) {
                 CircularProgressIndicator()
             }
             is PlayStoreState.Success -> {
                 val stores = (state as PlayStoreState.Success).names
                 LazyColumn(modifier = Modifier.padding(innerPadding)){
                     items(stores){
                         item ->
                         ProductView(item = item)
                     }
                 }
             }
         }
     }
}


