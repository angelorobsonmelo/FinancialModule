package br.com.soluevo.financialmodulelibrary.financial.financialDetail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.databinding.FinancialDetailBinding
import br.com.soluevo.financialmodulelibrary.financial.financialDetail.adapter.FinancialDetailAdapter
import br.com.soluevo.financialmodulelibrary.financial.financialDetail.handler.FinancialDetailHandler
import br.com.soluevo.financialmodulelibrary.model.Financial
import com.angelomelo.alternative.application.modules.events.events.commons.RecyclerItemClickListener

class FinancialDetail(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var handler: FinancialDetailHandler? = null

    private lateinit var binding: FinancialDetailBinding
    private lateinit var attrs: AttributeSet

    private val financesDetail = mutableListOf(
        Financial(
            "123",
            "Cabify",
            "Ângelo Melo",
            "R$ 65,00",
            "Finalizando - Aguardando Gestor",
            "Dinheiro",
            "02/05/2019 08:33"
        ),
        Financial(
            "1234",
            "Cabify",
            "José da Silva",
            "R$ 100,00",
            "Finalinzado - Aguardando Gestor",
            "Dinheiro",
            "03/04/2019 08:00"
        )
    )

    private var financialAdapter = FinancialDetailAdapter(
        financesDetail
    )

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.financial_detail, this, true
        )
        this.attrs = attrs
        setupRecyclerView()
        initRecyclerItemClickListener()
    }

    fun getFinancesDetail(idFinancialSummary: String, token: String) {

    }

    private fun setupRecyclerView() {
        val recyclerView = binding.financialDetailRecyclerView
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = financialAdapter
    }

    private fun initRecyclerItemClickListener() {
        val recyclerView = binding.financialDetailRecyclerView
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                context!!,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        handler?.setFinancialDetail(financesDetail[position])
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