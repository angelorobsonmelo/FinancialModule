package br.com.soluevo.financialmodulelibrary.financial.financialsummary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.financial.financial.viewholder.FinancialViewHolder
import br.com.soluevo.financialmodulelibrary.financial.financialsummary.viewholder.FinancialSummaryViewHolder

class FinancialSummaryAdapter(private val financesSummary: Map<Int, String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FinancialSummaryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.financial_summary_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FinancialSummaryViewHolder).binding
        binding?.financialTitle = financesSummary[position]
        binding?.financialValue = "R$ 1000,00"
        binding?.executePendingBindings()
    }

    override fun getItemCount() = financesSummary.size

}