package com.sultandev.feature_product.data.repositroy

import com.sultandev.core_database.dao.ProductDao
import com.sultandev.core_database.entity.ProductEntity
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.data.model.Products
import com.sultandev.feature_product.data.netowork.ListProduct
import com.sultandev.feature_product.domain.repository.ProductRepository
import retrofit2.Response

internal class ProductRepositoryImpl(
    private val listProduct: ListProduct,
    private val productDao: ProductDao,
) : ProductRepository {
    override suspend fun getAllProducts(): Response<Products> = listProduct.getAllProducts()

    override suspend fun getProductsByTag(tag: String): Response<List<Product>>{
        val products = listProduct.getAllProducts()
        val list: MutableList<Product> = mutableListOf()
        if(products.isSuccessful) {
            products.body()?.dishes?.onEach { product ->
                product.tegs.forEach { t ->
                    if(tag == t) {
                        list.add(product)
                    }
                }
            }
        }
        return Response.success(list)
    }

    override suspend fun getAllTags(): Set<String> {
        val products = listProduct.getAllProducts()
        val tags: MutableSet<String> = mutableSetOf()
        if (products.isSuccessful) {
            products.body().apply {
                this?.dishes?.forEach { product ->
                    product.tegs.forEach { tag ->
                        tags.add(tag)
                    }
                }
            }
        }
        return tags
    }

    override suspend fun addBasket(product: Product) {
        val productBasket = productDao.getProductById(product.id)
        val productEntity = ProductEntity(
            product.id,
            product.description,
            product.image_url,
            product.name,
            product.price,
            product.weight,
            count = if (productBasket != null) productBasket.count + 1 else 1
        )
        productDao.insert(productEntity)
    }
}