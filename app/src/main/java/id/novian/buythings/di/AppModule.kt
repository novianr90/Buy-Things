package id.novian.buythings.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import id.novian.buythings.model.data.remote.ProductCategory
import id.novian.buythings.model.data.repository.ProductRepository
import id.novian.buythings.model.data.repository.ProductRepositoryImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL = "https://fakestoreapi.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductCategory {
        return retrofit.create(ProductCategory::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideRepository(productApi: ProductCategory): ProductRepository {
        return ProductRepositoryImpl(productApi)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGSONConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRxJavaAdapter(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: GsonConverterFactory,
        adapter: RxJava3CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(gson)
            .addCallAdapterFactory(adapter)
            .build()
    }
}