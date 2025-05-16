package br.com.projeto01.projetocep.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ModuloConectividade {

    inline fun <reified T> getRetrofitService(baseUrl: String): T {

        //LOG
        val log = HttpLoggingInterceptor()
        log.level = HttpLoggingInterceptor.Level.BODY

        //CLIENT
        val client = OkHttpClient
                .Builder()
                .addInterceptor{ chain ->

                    //INTERCEPTOR PARA ACRESCENTAR API KEY, TOKEN, ETC
                    chain.proceed(
                            chain.request()
                                    .newBuilder()
                                    .build()
                    )

                }
                .addInterceptor(log)
                .build()

        //RETROFITBUILDER
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        //CRIAÇÃO DE SERVIÇO
        return retrofit.create(T::class.java)
    }
}