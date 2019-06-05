package br.com.soluevo.financialmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.soluevo.financialmodule.databinding.FinancialActivityBinding
import br.com.soluevo.financialmodulelibrary.financial.financial.Financial
import br.com.soluevo.financialmodulelibrary.financial.financial.handler.FinancialHandler
import br.com.soluevo.financialmodulelibrary.model.FinancialType

class FinancialActivity : AppCompatActivity(),
    FinancialHandler {

    private lateinit var binding: FinancialActivityBinding
    private lateinit var financesView: Financial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.financial_activity)

        financesView = binding.financialView
        financesView.handler = this
        financesView.getFinances("Cookie id", this)
    }

    override fun onDestroy() {
        super.onDestroy()
        financesView.clearDisposable()
    }

    override fun setFinancialType(financialType: FinancialType) {
        val intent = Intent(this, FinancialSummaryActivity::class.java)
        intent.putExtra("idFinancial", title)
        startActivity(intent)
    }

    override fun error(error: String) {

    }

}
