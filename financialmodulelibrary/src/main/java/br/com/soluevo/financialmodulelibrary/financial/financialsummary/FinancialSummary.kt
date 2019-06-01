package br.com.soluevo.financialmodulelibrary.financial.financialsummary

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.databinding.FinancialSummaryBinding
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.adapter.FinancialSummaryAdapter
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.handler.FinancialSummaryHandler
import com.angelomelo.alternative.application.modules.events.events.commons.RecyclerItemClickListener

class FinancialSummary(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var handler: FinancialSummaryHandler? = null

    private lateinit var binding: FinancialSummaryBinding
    private lateinit var attrs: AttributeSet

    private val financesSummary = mapOf(
        0 to "Aguardando Gestor",
        1 to "Pagamento Aprovado",
        2 to "Pagamento Recusado",
        3 to "Aguardando Pagamento"
    )

    private var financialAdapter = FinancialSummaryAdapter(
        financesSummary
    )

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.financial_summary, this, true
        )
        this.attrs = attrs
        setupRecyclerView()
        initRecyclerItemClickListener()
    }

    fun getFinancesSummary(idFinancial: String, token: String) {

    }

    private fun setupRecyclerView() {
        val recyclerView = binding.financialSummaryRecyclerView
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = financialAdapter
    }

    private fun initRecyclerItemClickListener() {
        val recyclerView = binding.financialSummaryRecyclerView
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                context!!,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        handler?.setFinancialSummary(financesSummary[position] ?: error("posição não encontrada"))
                    }

                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }

                }
            )
        )
    }


}