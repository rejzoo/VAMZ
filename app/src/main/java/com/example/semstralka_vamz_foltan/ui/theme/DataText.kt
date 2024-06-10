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
            ""
        }
    }

    private fun getIdObrazku(number: Int?): Int {
        val resourceId = context.resources.getIdentifier("obrazok_${topicNumber}${textNumber}", "string", context.packageName)
        return if (resourceId != 0) {
            context.getString(resourceId)
        } else {
            ""
        }
    }
}



