package br.com.soluevo.financialmodulelibrary.financial.financialDetail.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.databinding.FinancialDetailItemBinding
import br.com.soluevo.financialmodulelibrary.databinding.FinancialItemBinding
import br.com.soluevo.financialmodulelibrary.databinding.FinancialSummaryItemBinding

class FinancialDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: FinancialDetailItemBinding? = DataBindingUtil.bind(view)
}