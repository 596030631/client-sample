package com.shuaijun.client.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.databinding.FragmentOrderAddBinding
import com.shuaijun.client.databinding.ItemFragmentOrderAddBinding
import com.shuaijun.client.ui.BaseFragment
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

class OrderAddFragment : BaseFragment() {

    companion object {
        fun newInstance() = OrderAddFragment()
    }

    private lateinit var viewModel: OrderViewModel
    private lateinit var binding: FragmentOrderAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentOrderAddBinding.inflate(layoutInflater).apply {
            binding = this
            return binding.root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        mainModel.titleMessage.postValue("订单新增")
        mainModel.showMenu.postValue(booleanArrayOf(false,true,true, false))

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.orderDetailList,
            { parent, viewType ->
                VH(ItemFragmentOrderAddBinding.inflate(layoutInflater, parent, false))
            },
            { holder, position ->
                holder.binding.labelIndex .text= String.format("%d",position+1)
                holder.binding.labelName.text= viewModel.orderDetailList[position].name
            }
        )
    }

}