package id.novian.buythings.model.data.remote

import id.novian.buythings.model.data.model.ProductDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ProductCategory {
    @GET("products/category/jewelery")
    fun fetchJeweleryProducts(): Observable<ArrayList<ProductDto>>

    @GET("products/category/electronics")
    fun fetchElectronicProducts(): Observable<ArrayList<ProductDto>>

    @GET("products/category/men's%20clothing")
    fun fetchMenProducts(): Observable<ArrayList<ProductDto>>

    @GET("products/category/women's%20clothing")
    fun fetchWomenProducts(): Observable<ArrayList<ProductDto>>
}