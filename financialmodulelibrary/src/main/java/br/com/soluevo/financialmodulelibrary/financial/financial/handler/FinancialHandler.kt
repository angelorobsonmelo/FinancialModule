package br.com.soluevo.financialmodulelibrary.financial.financial.handler

import br.com.soluevo.financialmodulelibrary.model.FinancialType

interface FinancialHandler {

    fun setFinancialTitle(financialType: FinancialType)
    fun error(error: String)
}