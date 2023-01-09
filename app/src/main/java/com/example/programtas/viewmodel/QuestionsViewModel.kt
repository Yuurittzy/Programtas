package com.example.programtas.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.example.programtas.R
import com.example.programtas.model.Question
import com.example.programtas.repository.QuestionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionsViewModel(private val questionRepository: QuestionRepository) {

    private val questions = mutableListOf<Question>()

    val question = MutableLiveData<String>()
    val answer1 = MutableLiveData<String>()
    val answer2 = MutableLiveData<String>()
    val answer3 = MutableLiveData<String>()
    val resetColor = MutableLiveData<Boolean>()
    val answerButton = MutableLiveData<Int>()
    val openResultActivity = MutableLiveData<Boolean>()

    private var indexAnswer = 0
    var counter = 0

    fun getQuestions() {
        CoroutineScope(Dispatchers.IO).launch {
            questions.addAll(questionRepository.getQuestions())
            manageQuestions()
        }
    }

    private fun manageQuestions() {
        if(questions.isNullOrEmpty()) return

        val item = questions.random()

        indexAnswer = item.result?.toInt()?: 0
        question.postValue(item.question)
        answer1.postValue(item.answer1)
        answer2.postValue(item.answer2)
        answer3.postValue(item.answer3)
        resetColor.postValue(true)

        questions.remove(item)
    }

    fun play(numberAnswer: Int) {
        if (indexAnswer == numberAnswer) {
            answerButton.postValue(R.drawable.answer_correct_bg)
            counter++
            if (counter == NUMBER_QUESTIONS) {
                Handler().postDelayed({ openResultActivity.postValue(true) }, 300)
            }
            Handler().postDelayed({ manageQuestions() }, 300)
        } else {
            answerButton.postValue(R.drawable.answer_incorrect_bg)
            Handler().postDelayed({ openResultActivity.postValue(false) }, 300)
        }
    }

    companion object {
        const val NUMBER_QUESTIONS = 5
    }

}