package com.example.programtas.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private fun retrofitConfig(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://demo4403877.mockable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val call: QuestionInterface = retrofitConfig().create(QuestionInterface::class.java)

}