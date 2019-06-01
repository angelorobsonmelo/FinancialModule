package br.com.soluevo.financialmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.soluevo.financialmodule.databinding.FinancialActivityBinding
import br.com.soluevo.financialmodule.databinding.FinancialSummaryActivityBinding
import br.com.soluevo.financialmodulelibrary.financial.financial.handler.FinancialHandler
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.handler.FinancialSummaryHandler

class FinancialSummaryActivity : AppCompatActivity(),
    FinancialSummaryHandler {

    private lateinit var binding: FinancialSummaryActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.financial_summary_activity)
        val idFinancial = intent.getStringExtra("idFinancial")
        val financialSummaryView = binding.financialSummaryView
        financialSummaryView.handler = this
        financialSummaryView.getFinancesSummary(idFinancial, "token jwt")
    }

    override fun setFinancialSummary(finalSummary: String) {
        val intent = Intent(this, FinancialDetailActivity::class.java)
        intent.putExtra("idFinancialSummary", title)
        startActivity(intent)
    }

}
