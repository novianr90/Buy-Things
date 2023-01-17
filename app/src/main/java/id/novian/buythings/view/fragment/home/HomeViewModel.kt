package id.novian.buythings.view.fragment.home

import android.view.View
import androidx.lifecycle.ViewModel
import id.novian.buythings.R
import id.novian.buythings.model.data.repository.ProductRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    fun cardClicked(view: View) {
        when (view.id) {
            R.id.cv_electronic -> {
                productRepository.fetchMenProducts()
            }
            R.id.cv_jewelery -> {
                productRepository.fetchJewelryProducts()
            }
            R.id.cv_men -> {
                productRepository.fetchMenProducts()
            }
            R.id.cv_women -> {
                productRepository.fetchWomenProducts()
            }
        }
    }
}