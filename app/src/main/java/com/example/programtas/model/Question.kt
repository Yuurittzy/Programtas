package com.example.programtas.model

import com.google.gson.annotations.SerializedName

class Question (
   @SerializedName("question") val question: String?,
   @SerializedName("answer1") val answer1: String?,
   @SerializedName("answer2") val answer2: String?,
   @SerializedName("answer3") val answer3: String?,
   @SerializedName("result") val result: String?)