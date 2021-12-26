package com.shuaijun.client.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.databinding.FragmentOrderManagerBinding
import com.shuaijun.client.databinding.ItemFragmentOrderManagerBinding
import com.shuaijun.client.ui.BaseFragment
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderManagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderManagerFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentOrderManagerBinding
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
        FragmentOrderManagerBinding.inflate(inflater, container, false).apply {
            binding = this
            return binding.root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(OrderViewModel::class.java)
        mainModel.titleMessage.postValue("订单管理")
        mainModel.showMenu.postValue(booleanArrayOf(false, true, false))

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.orderList,
            { parent, viewType ->
                VH(ItemFragmentOrderManagerBinding.inflate(layoutInflater, parent, false))
            },
            { holder, position->
                holder.binding.imgOrder.text = String.format("%d", position + 1)
                holder.binding.labelOrderId.text = viewModel.orderList[position].id
                holder.binding.labelOrderName.text = viewModel.orderList[position].name
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
         * @return A new instance of fragment OrderManagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderManagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}