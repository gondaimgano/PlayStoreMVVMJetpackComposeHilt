package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.playstore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product.ProductViewModel

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
                         val productModel:ProductViewModel= hiltViewModel()
                         val products = productModel.getProductPagination(item).collectAsLazyPagingItems()

                         Column {
                             Text(item)
                             Spacer(modifier = Modifier.padding(8.dp))
                             LazyRow{
                                 items(products){
                                         product->
                                     Text(product?:"Empty",
                                         modifier = Modifier
                                             .padding(8.dp)
                                             .fillMaxWidth(0.18f))
                                 }
                             }

                         }
                     }
                 }
             }
         }
     }
}


