package br.com.soluevo.financialmodule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.soluevo.financialmodule.databinding.FinancialSummaryActivityBinding
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.FinancialSummary
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.handler.FinancialSummaryHandler
import br.com.soluevo.spinnerdatelibrary.domain.MonthResponse
import br.com.soluevo.spinnerdatelibrary.months.MonthCustomView
import br.com.soluevo.spinnerdatelibrary.months.handler.MonthHandler

class FinancialSummaryActivity : AppCompatActivity(),
    FinancialSummaryHandler, MonthHandler {

    private lateinit var binding: FinancialSummaryActivityBinding
    private lateinit var mFinancialSummaryView: FinancialSummary
    private lateinit var mMonthView: MonthCustomView
    private lateinit var mFinancialId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.financial_summary_activity)
        mFinancialId = intent.getStringExtra("idFinancial")

        mFinancialSummaryView = binding.financialSummaryView
        mFinancialSummaryView.handler = this

        mMonthView = binding.monthCustomView
        mMonthView.handler = this

        binding.monthCustomView.handler = this
        binding.monthCustomView.getMonthsFromActivity("_session_id=OqBRjNjX89fV4wjh-ecvgfCWNPE; path=/; HttpOnly", this)
    }

    override fun setFinancialSummary(finalSummary: String) {
        val intent = Intent(this, FinancialDetailActivity::class.java)
        intent.putExtra("idFinancialSummary", title)
        startActivity(intent)
    }

    override fun setError(error: String) {
    }

    override fun setMonsths(months: MutableList<MonthResponse>) {
    }

    override fun setMonth(monthResponse: MonthResponse) {
        mFinancialSummaryView.getFinancesSummaryFromActivity(
            mFinancialId,
            "_session_id=OqBRjNjX89fV4wjh-ecvgfCWNPE; path=/; HttpOnly",
            this,
            monthResponse.id
        )
    }


}
