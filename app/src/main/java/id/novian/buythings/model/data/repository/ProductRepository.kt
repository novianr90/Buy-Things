package id.novian.buythings.model.data.repository

import id.novian.buythings.model.data.model.ProductDto
import id.novian.buythings.model.data.remote.ProductCategory
import io.reactivex.rxjava3.core.Observable

interface ProductRepository {
    fun fetchJewelryProducts(): Observable<ArrayList<ProductDto>>
    fun fetchElectronicProducts(): Observable<ArrayList<ProductDto>>
    fun fetchMenProducts(): Observable<ArrayList<ProductDto>>
    fun fetchWomenProducts(): Observable<ArrayList<ProductDto>>
}

class ProductRepositoryImpl(
    private val api: ProductCategory
) : ProductRepository {
    override fun fetchJewelryProducts(): Observable<ArrayList<ProductDto>> {
        return api.fetchJeweleryProducts()
    }

    override fun fetchElectronicProducts(): Observable<ArrayList<ProductDto>> {
        return api.fetchElectronicProducts()
    }

    override fun fetchMenProducts(): Observable<ArrayList<ProductDto>> {
        return api.fetchMenProducts()
    }

    override fun fetchWomenProducts(): Observable<ArrayList<ProductDto>> {
        return api.fetchWomenProducts()
    }
}