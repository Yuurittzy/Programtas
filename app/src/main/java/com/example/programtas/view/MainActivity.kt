package com.example.programtas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.programtas.databinding.ActivityMainBinding
import com.example.programtas.repository.QuestionRepository
import com.example.programtas.repository.RetrofitConfig
import com.example.programtas.viewmodel.QuestionsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getQuestions()
    }

    private fun getQuestions(){
        binding.btnPlay.setOnClickListener {
            startActivity(Intent(this, QuestionsActivity::class.java))
        }
    }

}