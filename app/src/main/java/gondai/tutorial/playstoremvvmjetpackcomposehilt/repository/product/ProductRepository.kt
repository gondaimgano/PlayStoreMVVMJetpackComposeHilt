package gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product

interface ProductRepository {
   suspend fun fetchByProduct(name:String):List<String>
}