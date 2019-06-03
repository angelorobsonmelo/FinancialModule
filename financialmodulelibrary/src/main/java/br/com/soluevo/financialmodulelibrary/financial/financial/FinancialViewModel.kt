package br.com.soluevo.financialmodulelibrary.financial.financial

import br.com.soluevo.financialmodulelibrary.commom.BaseViewModel
import br.com.soluevo.financialmodulelibrary.model.FinancialType
import br.com.soluevo.financialmodulelibrary.service.remote.financial.FinancialTypeApiDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable


class FinancialViewModel @Inject constructor(
    private val financesApiDataSource: FinancialTypeApiDataSource
) : BaseViewModel<MutableList<FinancialType>>() {

    private val disposables = CompositeDisposable()

     fun getFinances() {
        val disposible = financesApiDataSource.getFinances().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoadingObserver.value = true }
            .doAfterTerminate { isLoadingObserver.value = false }
            .subscribe(
                {
                    successObserver.value = it
                },
                { throwable ->
                    errorObserver.value = throwable.localizedMessage
                }
            )

        disposables.add(disposible)
    }

}