package com.example.semstralka_vamz_foltan.ui.theme


import com.example.semstralka_vamz_foltan.R
import android.content.Context

data class DataTema(val topicNumber: Int? , val context: Context) {
    val topicName: String = getTopicName(topicNumber)


    private fun getTopicName(number: Int?): String {

        return when (number) {
            1 -> context.getString(R.string.Tema_1)
            2 -> context.getString(R.string.Tema_2)
            3 -> context.getString(R.string.Tema_3)
            4 -> context.getString(R.string.Tema_4)
            5 -> context.getString(R.string.Tema_5)
            6 -> context.getString(R.string.Tema_6)
            7 -> context.getString(R.string.Tema_7)
            8 -> context.getString(R.string.Tema_8)
            else -> ""
        }
    }
}
