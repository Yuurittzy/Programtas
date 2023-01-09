package com.example.programtas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.programtas.R
import com.example.programtas.databinding.ActivityQuestionsBinding
import com.example.programtas.repository.QuestionRepository
import com.example.programtas.repository.RetrofitConfig
import com.example.programtas.viewmodel.QuestionsViewModel

class QuestionsActivity : AppCompatActivity() {

    private val viewModel = QuestionsViewModel(QuestionRepository(RetrofitConfig))
    private lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getQuestions()
        resetColor()
        openResultActivity()
        onClickButton(binding.btn1, 1)
        onClickButton(binding.btn2, 2)
        onClickButton(binding.btn3, 3)
    }

    private fun getQuestions() {
        viewModel.getQuestions()

        viewModel.question.observe(this) { binding.tvQuestion.text = it }
        viewModel.answer1.observe(this) { binding.btn1.text = it }
        viewModel.answer2.observe(this) { binding.btn2.text = it }
        viewModel.answer3.observe(this) { binding.btn3.text = it }
    }

    private fun onClickButton(button: Button, answerNumber: Int) {
        button.setOnClickListener {
            viewModel.play(answerNumber)
            viewModel.answerButton.observe(this) {
                button.setBackgroundDrawable(ContextCompat.getDrawable(this, it))
            }
        }
    }

    private fun resetColor() {
        viewModel.resetColor.observe(this) {
            binding.btn1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.question_box_bg))
            binding.btn2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.question_box_bg))
            binding.btn3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.question_box_bg))
        }
    }

    private fun openResultActivity() {
        viewModel.openResultActivity.observe(this) {
            val intent = Intent(this@QuestionsActivity, ResultActivity::class.java)
            intent.putExtra("Result", it)
            startActivity(intent)
            finish()
        }
    }

}