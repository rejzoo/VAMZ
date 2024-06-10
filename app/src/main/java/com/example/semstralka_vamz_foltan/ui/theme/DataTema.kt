package com.example.semstralka_vamz_foltan.ui.theme


import com.example.semstralka_vamz_foltan.R
import android.content.Context

data class DataTema(val topicNumber: Int? , val context: Context) {
    val topicName: String = getTopicName(topicNumber)

    val topicText: String = getTopicText(topicNumber)

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

    private fun getTopicText(number: Int?): String {
        return when (number) {
            1 -> context.getString(R.string.Text_1)
            2 -> "Jednorozmerná deskriptívna štatistika"
            3 -> "Náhodná premenná"
            4 -> "Rozdelenia pravdepodobnosti náhodnej premennej"
            5 -> "Odhady parametrov"
            6 -> "Testovanie štatistických hypotéz"
            7 -> "Korelačná a regresná analýza"
            8 -> "Analýza kvalitatýcnych znakov"
            else -> ""
        }
    }
}
