package br.com.soluevo.financialmodulelibrary.financial.financialsummary.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.databinding.FinancialItemBinding
import br.com.soluevo.financialmodulelibrary.databinding.FinancialSummaryItemBinding

class FinancialSummaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: FinancialSummaryItemBinding? = DataBindingUtil.bind(view)
}