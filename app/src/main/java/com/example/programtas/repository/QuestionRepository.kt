package com.example.programtas.repository

import com.example.programtas.model.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestionRepository(private val retrofitConfig: RetrofitConfig) {

    suspend fun getQuestions(): List<Question> {
        return withContext(Dispatchers.IO) {
            retrofitConfig.call.getQuestions()
        }
    }

}