package com.shuaijun.client.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.shuaijun.client.MainViewModel
import com.shuaijun.client.R
import com.shuaijun.client.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var mainModel: MainViewModel
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentHomeBinding.inflate(inflater, container, false).apply {
            binding = this
            return this.root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mainModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainModel.titleMessage.postValue("管理平台")

        binding.btnOrderAdd.setOnClickListener {
            HomeFragmentDirections.mainNavigationOrderAdd().apply {
                Navigation.findNavController(requireActivity(), R.id.container).navigate(this)
            }
        }

        binding.btnOrderPredict.setOnClickListener {
            HomeFragmentDirections.mainNavigationOrderPredict().apply {
                Navigation.findNavController(requireActivity(), R.id.container).navigate(this)
            }
        }
        binding.btnOrderManager.setOnClickListener {
            HomeFragmentDirections.mainNavigationOrderManager().apply {
                Navigation.findNavController(requireActivity(), R.id.container).navigate(this)
            }
        }
        binding.btnTimePerson.setOnClickListener {
            HomeFragmentDirections.mainNavigationTimePerson().apply {
                Navigation.findNavController(requireActivity(), R.id.container).navigate(this)
            }
        }
        binding.btnTimeMachine.setOnClickListener {
            HomeFragmentDirections.mainNavigationTimeMachine().apply {
                Navigation.findNavController(requireActivity(), R.id.container).navigate(this)
            }
        }
    }
}