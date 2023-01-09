package com.example.programtas.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.programtas.databinding.ActivityResultBinding
import com.example.programtas.viewmodel.ResultViewModel

class ResultActivity : AppCompatActivity() {

    private val viewModel = ResultViewModel()

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showResult()
        finishActivity()
    }

    private fun showResult() {
        val result = viewModel.getResult(intent.extras?.getBoolean("Result")?: false)

        result.let {
            binding.ivComputer.setImageDrawable(AppCompatResources.getDrawable(this, it.image))
            binding.tvWinOrNot.text = getString(it.text)
            binding.tvWinOrNot.setTextColor(resources.getColor(it.textColor))
            binding.btnComeBack.setBackgroundDrawable(AppCompatResources.getDrawable(this, it.colorButton))
        }
    }

    private fun finishActivity() {
        binding.btnComeBack.setOnClickListener { finish() }
    }

}