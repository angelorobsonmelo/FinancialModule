package br.com.soluevo.financialmodulelibrary.financial.financial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.financial.financial.viewholder.FinancialViewHolder
import br.com.soluevo.financialmodulelibrary.model.FinancialType

class FinancialAdapter(private val finances: MutableList<FinancialType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FinancialViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.financial_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FinancialViewHolder).binding
        binding?.financialType = finances[position]
        binding?.executePendingBindings()
    }

    override fun getItemCount() = finances.size

    fun updateItems(it: MutableList<FinancialType>) {
        this.finances.clear()
        this.finances.addAll(it)
        notifyDataSetChanged()
    }

}