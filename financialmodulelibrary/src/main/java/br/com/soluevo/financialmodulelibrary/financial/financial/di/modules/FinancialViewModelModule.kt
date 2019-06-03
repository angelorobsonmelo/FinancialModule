package br.com.soluevo.financialmodulelibrary.financial.financial.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.soluevo.financialmodulelibrary.commom.ViewModelFactory
import br.com.soluevo.financialmodulelibrary.commom.ViewModelKey
import br.com.soluevo.financialmodulelibrary.financial.financial.FinancialViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FinancialViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FinancialViewModel::class)
    internal abstract fun financialViewModel(financialViewModel: FinancialViewModel): ViewModel

}