package br.com.soluevo.financialmodulelibrary.financial.financialDetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.financial.financialDetail.viewholder.FinancialDetailViewHolder
import br.com.soluevo.financialmodulelibrary.model.Financial

class FinancialDetailAdapter(private val finances: MutableList<Financial>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FinancialDetailViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.financial_detail_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FinancialDetailViewHolder).binding
        binding?.financial = finances[position]
        binding?.executePendingBindings()
    }

    override fun getItemCount() = finances.size

}