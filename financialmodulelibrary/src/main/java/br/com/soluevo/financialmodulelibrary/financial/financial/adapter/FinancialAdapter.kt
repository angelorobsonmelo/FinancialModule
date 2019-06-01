package br.com.soluevo.financialmodulelibrary.financial.financial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.financial.financial.viewholder.FinancialViewHolder

class FinancialAdapter(private val finances: Map<Int, String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FinancialViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.financial_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FinancialViewHolder).binding
        binding?.financialTitle = finances[position]
        binding?.executePendingBindings()
    }

    override fun getItemCount() = finances.size

}