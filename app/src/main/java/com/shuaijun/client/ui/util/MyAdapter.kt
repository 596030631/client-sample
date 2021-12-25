package com.shuaijun.client.ui.util

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class MyAdapter<T : ViewBinding, M : Any>(
    val data: MutableList<M>,
    val view: (parent: ViewGroup, viewType: Int) -> VH<T>,
    val bindView: (holder: VH<T>, position: Int) -> Unit,
) : RecyclerView.Adapter<VH<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<T> =
        view(parent, viewType)

    override fun onBindViewHolder(holder: VH<T>, position: Int) {
        bindView(holder, position)
    }
    override fun getItemCount(): Int = data.size
}
class VH<T : ViewBinding>(var binding: T) : RecyclerView.ViewHolder(binding.root)