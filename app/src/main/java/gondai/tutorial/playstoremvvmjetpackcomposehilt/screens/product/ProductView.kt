package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
@Composable
fun ProductView(productModel:ProductViewModel= hiltViewModel(),item:String) {

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