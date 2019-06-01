package br.com.soluevo.financialmodulelibrary.model

data class Financial(
    val number: String,
    val title: String,
    val clientName: String,
    val value: String,
    val status: String,
    val paymentType: String,
    val date: String
)