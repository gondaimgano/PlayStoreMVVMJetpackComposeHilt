package gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.category

import javax.inject.Inject

class CategoryRepositoryImpl
    @Inject constructor(): CategoryRepository {
    override suspend fun fetchAll(): List<String> =listOf("Category","Category 3","Category 4","Category2","Category3","Category","Category 3","Category 4","Category2","Category3")
}