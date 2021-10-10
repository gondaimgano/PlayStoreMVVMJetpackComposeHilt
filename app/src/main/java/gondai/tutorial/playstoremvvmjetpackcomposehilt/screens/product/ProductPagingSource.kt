package gondai.tutorial.playstoremvvmjetpackcomposehilt.screens.product

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product.ProductRepository

class ProductPagingSource  constructor(private val repository: ProductRepository, val name:String) : PagingSource<Int, String>() {
    override val keyReuseSupported: Boolean
        get() = true
    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = repository.fetchByProduct(name = name)

            LoadResult.Page(
                data = movieListResponse,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}