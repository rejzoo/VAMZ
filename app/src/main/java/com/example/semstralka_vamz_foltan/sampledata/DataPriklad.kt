package com.example.semstralka_vamz_foltan.sampledata

import android.content.Context


data class DataPriklad(val topicNumber: Int? , val context: Context) {
    val textPriklad: String = getTextFromRes()

    val idObrazku: Int = getIdObrazkuFromRes()

    private fun getTextFromRes(): String {
        val resourceId = context.resources.getIdentifier(
            "Priklad_${topicNumber}",
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
            "priklad_${topicNumber}",
            "drawable",
            context.packageName)
        return if (idObrazku != 0) {
            idObrazku
        } else {
            0
        }
    }
}
