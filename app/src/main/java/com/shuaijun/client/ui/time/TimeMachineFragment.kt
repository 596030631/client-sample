package com.shuaijun.client.ui.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shuaijun.client.databinding.FragmentTimeMachineBinding
import com.shuaijun.client.databinding.ItemFragmentTimeMachineBinding
import com.shuaijun.client.ui.BaseFragment
import com.shuaijun.client.ui.util.MyAdapter
import com.shuaijun.client.ui.util.VH

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TimeMachineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TimeMachineFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentTimeMachineBinding
    private lateinit var viewModel: TimeViewModel

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
        FragmentTimeMachineBinding.inflate(inflater, container, false).apply {
            binding = this
            return binding.root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainModel.titleMessage.postValue("设备工时管理")
        viewModel = ViewModelProvider(requireActivity()).get(TimeViewModel::class.java)
        mainModel.showMenu.postValue(booleanArrayOf(false, true, false, true))

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = MyAdapter(
            viewModel.dataMachineList,
            { parent, _ ->
                VH(
                    ItemFragmentTimeMachineBinding.inflate(
                        LayoutInflater.from(requireContext()),
                        parent,
                        false
                    )
                )
            },
            { holder, position ->
                holder.binding.labelOrderId.text = viewModel.dataMachineList[position].orderId
                holder.binding.imgOrder.text = "$position"
                holder.binding.labelRoomName.text = viewModel.dataMachineList[position].roomName
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
         * @return A new instance of fragment TimeMachineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TimeMachineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}