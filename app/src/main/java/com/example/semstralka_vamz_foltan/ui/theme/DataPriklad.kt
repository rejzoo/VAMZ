package com.example.semstralka_vamz_foltan.ui.theme

import android.content.Context
import com.example.semstralka_vamz_foltan.R

data class DataPriklad(val topicNumber: Int? , val context: Context) {
    val textPriklad: String = getTextPriklad(topicNumber)

    val idObrazku: Int = getIdObrazku(topicNumber)

    private fun getTextPriklad(number: Int?): String {

        return when (number) {
            1 -> context.getString(R.string.Priklad_1)
            2 -> context.getString(R.string.Priklad_2)
            3 -> context.getString(R.string.Priklad_3)
            4 -> context.getString(R.string.Priklad_4)
            5 -> context.getString(R.string.Priklad_5)
            6 -> context.getString(R.string.Priklad_6)
            7 -> context.getString(R.string.Priklad_7)
            8 -> context.getString(R.string.Priklad_8)
            else -> ""
        }
    }

    private fun getIdObrazku(number: Int?): Int {
        return when (number) {
            1 -> R.drawable.obrazok_1
            2 -> R.drawable.obrazok_2
            3 -> R.drawable.obrazok_1
            4 -> R.drawable.obrazok_1
            5 -> R.drawable.obrazok_1
            6 -> R.drawable.obrazok_1
            7 -> R.drawable.obrazok_1
            8 -> R.drawable.obrazok_1
            else -> R.drawable.obrazok_1
        }
    }
}
