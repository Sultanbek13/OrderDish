package com.sultandev.feature_product.data.netowork

import com.sultandev.feature_product.data.model.Products
import retrofit2.Response
import retrofit2.http.GET

internal interface ListProduct {

    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getAllProducts(): Response<Products>

}