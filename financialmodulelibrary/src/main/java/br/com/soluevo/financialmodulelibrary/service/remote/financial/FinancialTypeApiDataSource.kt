package br.com.soluevo.financialmodulelibrary.service.remote.financial

import br.com.soluevo.financialmodulelibrary.model.FinancialType
import io.reactivex.Observable
import retrofit2.http.GET

interface FinancialTypeApiDataSource {

    @GET("finances")
    fun getFinances(): Observable<MutableList<FinancialType>>
}