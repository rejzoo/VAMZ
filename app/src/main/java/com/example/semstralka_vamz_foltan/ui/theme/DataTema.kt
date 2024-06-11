package com.example.semstralka_vamz_foltan.ui.theme


import com.example.semstralka_vamz_foltan.R
import android.content.Context

data class DataTema(val topicNumber: Int? , val context: Context) {
    val topicName: String = getTextFromRes()


    private fun getTextFromRes(): String {
        val resourceId = context.resources.getIdentifier(
            "Tema_${topicNumber}",
            "string",
            context.packageName
        )
        return if (resourceId != 0) {
            context.getString(resourceId)
        } else {
            ""
        }
    }
}
