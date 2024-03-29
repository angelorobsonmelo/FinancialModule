package br.com.soluevo.financialmodulelibrary.financial.financial

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.soluevo.financialmodulelibrary.R
import br.com.soluevo.financialmodulelibrary.commom.di.ContextModule
import br.com.soluevo.financialmodulelibrary.databinding.FinancialBinding
import br.com.soluevo.financialmodulelibrary.financial.financial.adapter.FinancialAdapter
import br.com.soluevo.financialmodulelibrary.financial.financial.di.component.DaggerFinancialComponent
import br.com.soluevo.financialmodulelibrary.financial.financial.handler.FinancialHandler
import br.com.soluevo.financialmodulelibrary.model.FinancialType
import com.angelomelo.alternative.application.modules.events.events.commons.RecyclerItemClickListener
import javax.inject.Inject


class Financial(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    var handler: FinancialHandler? = null

    private lateinit var binding: FinancialBinding
    private lateinit var attrs: AttributeSet

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: FinancialViewModel? = null
    private val finances = mutableListOf<FinancialType>()
    private var financialAdapter = FinancialAdapter(
        finances
    )

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.financial, this, true
        )
        this.attrs = attrs

        setUpElements()
    }

    private fun setUpElements() {
        injectDependencies()
        setupRecyclerView()
        initRecyclerItemClickListener()
    }

    private fun injectDependencies() {
        DaggerFinancialComponent.builder()
            .contextModule(ContextModule(context))
            .build()
            .inject(this)
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.financialRecyclerView
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = financialAdapter
    }

    private fun initRecyclerItemClickListener() {
        val recyclerView = binding.financialRecyclerView
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                context!!,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        handler?.setFinancialType(finances[position])
                    }

                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                    }

                }
            )
        )
    }

    fun getFinances(token: String, activity: AppCompatActivity) {
        viewModel = ViewModelProviders.of(activity, viewModelFactory)[FinancialViewModel::class.java]
        viewModel?.getFinances()

        binding.lifecycleOwner = activity
        binding.viewModel = viewModel

        viewModel?.successObserver?.observe(activity, Observer {
             financialAdapter.updateItems(it)
        })

        viewModel?.errorObserver?.observe(activity, Observer {
            handler?.error(it)
        })

    }

    fun clearDisposable() {
        viewModel?.disposables?.clear()
    }


}