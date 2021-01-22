package com.guc.gviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by guc on 2021/1/21.
 * Description：使用ViewBinding的列表适配器
 */
class BindingViewHolder<VB:ViewBinding>(val binding:VB): RecyclerView.ViewHolder(binding.root){
}

inline fun <reified T : ViewBinding> newBindingViewHolder(parent: ViewGroup): BindingViewHolder<ViewBinding> {
    val method = T::class.java.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
    val binding = method.invoke(null, LayoutInflater.from(parent.context), parent, false) as T
    return BindingViewHolder(binding)
}