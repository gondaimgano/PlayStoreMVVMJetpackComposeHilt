package gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.category

interface CategoryRepository {
    suspend fun fetchAll():List<String>
}