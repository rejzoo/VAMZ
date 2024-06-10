package com.example.semstralka_vamz_foltan.ui.theme

import android.content.Context
import com.example.semstralka_vamz_foltan.R

data class DataText(val topicNumber: Int?, val textNumber: Number, val context: Context) {

    val text: String = getTextFromRes()
    val idObrazku: Int = getIdObrazku(topicNumber)

    private fun getTextFromRes(): String {
        val resourceId = context.resources.getIdentifier("Text_${topicNumber}${textNumber}", "string", context.packageName)
        return if (resourceId != 0) {
            context.getString(resourceId)
        } else {
            "Text nenájdený"
        }
    }

    private fun getIdObrazku(number: Int?): Int {
        return when (number) {
            1 -> R.drawable.obrazok_1
            2 -> R.drawable.obrazok_2
            3 -> R.drawable.obrazok_3
            4 -> R.drawable.obrazok_4
            //5 -> R.drawable.obrazok_5
            6 -> R.drawable.obrazok_6
            7 -> R.drawable.obrazok_1
            8 -> R.drawable.obrazok_1
            else -> 0
        }
    }
}



