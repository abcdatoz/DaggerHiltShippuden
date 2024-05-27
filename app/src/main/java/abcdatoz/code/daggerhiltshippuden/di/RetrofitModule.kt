package abcdatoz.code.daggerhiltshippuden.di

import abcdatoz.code.daggerhiltshippuden.data.network.ClansApi
import abcdatoz.code.daggerhiltshippuden.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)
object RetrofitModule{

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideClansApi(retrofit: Retrofit): ClansApi{
        return retrofit.create(ClansApi::class.java)
    }
}