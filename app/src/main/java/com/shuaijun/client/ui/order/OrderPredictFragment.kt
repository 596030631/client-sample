package com.shuaijun.client.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.databinding.FragmentOrderPredictBinding
import com.shuaijun.client.databinding.ItemFragmentOrderPredictBinding
import com.shuaijun.client.ui.BaseFragment
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderPredictFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderPredictFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentOrderPredictBinding
    private lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        FragmentOrderPredictBinding.inflate(inflater, container, false).apply {
            binding = this
            return root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainModel.titleMessage.postValue("订单预测管理")
        mainModel.showMenu.postValue(booleanArrayOf(false, true, false, true))
        viewModel = ViewModelProvider(requireActivity()).get(OrderViewModel::class.java)

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.orderPredict,
            { parent, viewType ->
                VH(ItemFragmentOrderPredictBinding.inflate(layoutInflater, parent, false))
            },
            { holder, position ->
                holder.binding.imgOrder.text = String.format("%d", position + 1)
                holder.binding.labelOrderId.text = viewModel.orderPredict[position].id
                holder.binding.labelOrderName.text = viewModel.orderPredict[position].name
            }
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderPredictFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderPredictFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}