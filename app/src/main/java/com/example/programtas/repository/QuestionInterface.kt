package com.example.programtas.repository

import com.example.programtas.model.Question
import retrofit2.http.GET

interface QuestionInterface {

    @GET("/programtas")
    suspend fun getQuestions() : List<Question>

}