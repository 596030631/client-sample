package com.shuaijun.client.ui.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.MainViewModel
import com.shuaijun.client.databinding.FragmentTimePersonBinding
import com.shuaijun.client.databinding.ItemFragmentTimePersonBinding
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

class TimePersonFragment : Fragment() {

    companion object {
        fun newInstance() = TimePersonFragment()
    }

    private lateinit var viewModel: TimePersonViewModel
    private lateinit var mainModel: MainViewModel
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
        viewModel = ViewModelProvider(this).get(TimePersonViewModel::class.java)
        mainModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainModel.titleMessage.postValue("人工工时管理")
        binding.recyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.dataList,
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
                holder.binding.labelOrderId.text = viewModel.dataList[position].orderId
            }
        )
    }
}