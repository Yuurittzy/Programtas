package com.example.programtas.viewmodel

import com.example.programtas.R
import com.example.programtas.model.FinalResult

class ResultViewModel {

    fun getResult(result: Boolean): FinalResult {
        return if (!result) {
            FinalResult(R.drawable.computer_sad, R.string.lose, R.color.incorrect, R.drawable.answer_incorrect_bg)
        } else {
            FinalResult(R.drawable.computer_happy, R.string.win, R.color.correct, R.drawable.answer_correct_bg)
        }
    }

}