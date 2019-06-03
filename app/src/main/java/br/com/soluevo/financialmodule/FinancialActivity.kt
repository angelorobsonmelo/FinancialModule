package br.com.soluevo.financialmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.soluevo.financialmodule.databinding.FinancialActivityBinding
import br.com.soluevo.financialmodulelibrary.financial.financial.handler.FinancialHandler
import br.com.soluevo.financialmodulelibrary.model.FinancialType

class FinancialActivity : AppCompatActivity(),
    FinancialHandler {

    private lateinit var binding: FinancialActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.financial_activity)
        val financesView = binding.financialView
        financesView.handler = this
        financesView.getFinances("jtw programmatty", this)
    }

    override fun setFinancialTitle(financialType: FinancialType) {
        val intent = Intent(this, FinancialSummaryActivity::class.java)
        intent.putExtra("idFinancial", title)
        startActivity(intent)
    }

    override fun error(error: String) {

    }
}
