package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product

import androidx.lifecycle.ViewModel
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
   private val repository: ProductRepository,
):ViewModel(){

    fun getProductPagination(category:String): Flow<PagingData<String>> {
        return Pager(PagingConfig(pageSize = 10)) {
            ProductPagingSource(repository,category)
        }.flow
    }
}



