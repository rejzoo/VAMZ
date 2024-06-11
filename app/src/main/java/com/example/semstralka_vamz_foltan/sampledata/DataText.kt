package com.example.semstralka_vamz_foltan.sampledata

import android.content.Context


data class DataText(val topicNumber: Int?, val textNumber: Number, val context: Context) {


    val text: String = getTextFromRes()
    val idObrazku: Int = getIdObrazkuFromRes()

    private fun getTextFromRes(): String {
        val resourceId = context.resources.getIdentifier(
            "Text_${topicNumber}${textNumber}",
            "string",
            context.packageName
        )
        return if (resourceId != 0) {
            context.getString(resourceId)
        } else {
            ""
        }
    }

    private fun getIdObrazkuFromRes(): Int {
        val idObrazku = context.resources.getIdentifier(
            "obrazok_${topicNumber}${textNumber}",
            "drawable",
            context.packageName)
        return if (idObrazku != 0) {
            idObrazku
        } else {
            0
        }
    }
}





