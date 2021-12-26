package com.shuaijun.client.ui.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.databinding.FragmentTimePersonBinding
import com.shuaijun.client.databinding.ItemFragmentTimePersonBinding
import com.shuaijun.client.ui.BaseFragment
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

class TimePersonFragment : BaseFragment() {

    companion object {
        fun newInstance() = TimePersonFragment()
    }

    private lateinit var viewModel: TimeViewModel
    private lateinit var binding: FragmentTimePersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentTimePersonBinding.inflate(inflater, container, false).apply {
            binding = this
            return root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TimeViewModel::class.java)
        mainModel.titleMessage.postValue("人工工时管理")
        mainModel.showMenu.postValue(booleanArrayOf(false, true, false, true))


        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.dataPersonList,
            { parent, _ ->
                VH(
                    ItemFragmentTimePersonBinding.inflate(
                        LayoutInflater.from(requireContext()),
                        parent,
                        false
                    )
                )
            },
            { holder, position ->
                holder.binding.imgOrder.text = String.format("%d", position + 1)
                holder.binding.labelOrderId.text = viewModel.dataPersonList[position].orderId
                holder.binding.labelOperator.text = viewModel.dataPersonList[position].operator
            }
        )
    }
}