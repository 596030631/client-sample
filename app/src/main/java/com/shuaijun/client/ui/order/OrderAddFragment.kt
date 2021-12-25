package com.shuaijun.client.ui.order

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shuaijun.client.MainViewModel
import com.shuaijun.client.R

class OrderAddFragment : Fragment() {

    companion object {
        fun newInstance() = OrderAddFragment()
    }

    private lateinit var viewModel: OrderAddViewModel
    private lateinit var mainModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderAddViewModel::class.java)
        // TODO: Use the ViewModel
        mainModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainModel.titleMessage.postValue("订单新增")
    }

}