package gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product

class ProductRepositoryImpl :ProductRepository{
    override suspend fun fetchByProduct(name: String): List<String> =when(name){
        "Category"-> listOf("Hello","Hello","Hello")
        "Category2"-> listOf("Product2","Product1","ProductUid")
        else -> listOf("Others","Others","others")
    }
}