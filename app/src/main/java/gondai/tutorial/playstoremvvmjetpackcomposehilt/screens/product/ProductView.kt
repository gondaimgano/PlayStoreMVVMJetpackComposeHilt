package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
@Composable
fun ProductView(productModel:ProductViewModel= hiltViewModel(),item:String) {

    val products = productModel.getProductPagination(item).collectAsLazyPagingItems()

    Column(
      //  modifier = Modifier.padding(8.dp).fillMaxHeight(0.18f)
    ) {
        Text(item)
        Spacer(modifier = Modifier.padding(8.dp))
        LazyRow{
            items(products){
                    product->
               Card(modifier = Modifier.size(100.dp).clip(
                   RoundedCornerShape(20.dp)).padding(10.dp),
               backgroundColor = Color.Cyan){
                   Text(product?:"Empty",
                       modifier = Modifier
                           .padding(8.dp)
                           .fillMaxWidth(0.18f))
               }
            }
        }

    }
}