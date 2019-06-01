package br.com.soluevo.financialmodulelibrary.financial.financial.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.soluevo.financialmodulelibrary.databinding.FinancialItemBinding

class FinancialViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: FinancialItemBinding? = DataBindingUtil.bind(view)
}