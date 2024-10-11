package cz.regiojet.regiopokemons.di

import cz.regiojet.regiopokemons.BuildConfig
import cz.regiojet.regiopokemons.data.network.PokeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://pokeapi.co/api/v2/"

val retrofitModule = module {

    val interceptor = HttpLoggingInterceptor()

    if (BuildConfig.DEBUG) {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    } else {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun provideApi(retrofit: Retrofit): PokeApiService =
        retrofit.create(PokeApiService::class.java)

    single {
        provideApi(getRetrofit())
    }
}