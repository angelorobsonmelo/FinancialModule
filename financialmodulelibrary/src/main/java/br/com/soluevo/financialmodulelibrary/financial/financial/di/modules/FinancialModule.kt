package br.com.soluevo.financialmodulelibrary.financial.financial.di.modules

import br.com.soluevo.financialmodulelibrary.commom.di.NetWorkModule
import br.com.soluevo.financialmodulelibrary.service.remote.financial.FinancialTypeApiDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetWorkModule::class, FinancialViewModelModule::class])
class FinancialModule {

    @Provides
    @Singleton
    fun provideFinancesTypeApiDataSource(retrofit: Retrofit): FinancialTypeApiDataSource =
        retrofit.create(FinancialTypeApiDataSource::class.java)
}