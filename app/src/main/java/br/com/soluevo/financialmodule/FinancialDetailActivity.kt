package br.com.soluevo.financialmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.soluevo.financialmodule.databinding.FinancialDetailActivityBinding
import br.com.soluevo.financialmodulelibrary.financial.financialDetail.handler.FinancialDetailHandler
import br.com.soluevo.financialmodulelibrary.model.Financial

class FinancialDetailActivity : AppCompatActivity(),
    FinancialDetailHandler {

    private lateinit var binding: FinancialDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.financial_detail_activity)
        val idFinancial = intent.getStringExtra("idFinancialSummary")

        val financialSummaryView = binding.financialDetailView
        financialSummaryView.handler = this
        financialSummaryView.getFinancesDetail(idFinancial, "token jwt")
    }

    override fun setFinancialDetail(financial: Financial) {

    }

}
