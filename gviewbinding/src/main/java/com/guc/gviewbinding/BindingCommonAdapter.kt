package com.guc.gviewbinding

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by guc on 2021/1/21.
 * Description：通用适配器
 */
abstract class BindingCommonAdapter<T>(val datas: List<T>) :
    RecyclerView.Adapter<BindingViewHolder<ViewBinding>>() {
    lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ViewBinding> {
        context = parent.context
        return createBindingViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: BindingViewHolder<ViewBinding>, position: Int) {
        bindData(holder, position, datas[position], getItemViewType(position))
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    abstract fun createBindingViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ViewBinding>

    //数据绑定
    abstract fun bindData(
        viewHolder: BindingViewHolder<ViewBinding>,
        position: Int,
        data: T,
        itemType: Int
    )
}


