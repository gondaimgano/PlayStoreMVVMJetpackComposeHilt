package gondai.tutorial.playstoremvvmjetpackcomposehilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.category.CategoryRepository
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.category.CategoryRepositoryImpl
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product.ProductRepository
import gondai.tutorial.playstoremvvmjetpackcomposehilt.repository.product.ProductRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providesCategory():CategoryRepository=CategoryRepositoryImpl()
    @Provides
    fun providesProduct():ProductRepository=ProductRepositoryImpl()
}