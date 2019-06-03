package br.com.soluevo.financialmodulelibrary.financial.financial.di.component

import br.com.soluevo.financialmodulelibrary.commom.di.ContextModule
import br.com.soluevo.financialmodulelibrary.financial.financial.Financial
import br.com.soluevo.financialmodulelibrary.financial.financial.di.modules.FinancialModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FinancialModule::class, ContextModule::class])
interface FinancialComponent {

    fun inject(financial: Financial)
}