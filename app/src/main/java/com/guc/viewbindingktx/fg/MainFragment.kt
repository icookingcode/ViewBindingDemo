package com.guc.viewbindingktx.fg

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.guc.viewbindingktx.R
import com.guc.viewbindingktx.baseVB.BindingCommonAdapter
import com.guc.viewbindingktx.baseVB.BindingViewHolder
import com.guc.viewbindingktx.baseVB.bindView
import com.guc.viewbindingktx.baseVB.newBindingViewHolder
import com.guc.viewbindingktx.databinding.FragmentMainBinding
import com.guc.viewbindingktx.databinding.ItemText2Binding
import com.guc.viewbindingktx.databinding.ItemTextBinding

private const val ARG_PARAM1 = "param1"
private const val TAG: String = "MainFragment"
/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(R.layout.fragment_main) {

    private var param1: String = "GuChao"
    private val binding: FragmentMainBinding by bindView()

    private val adapter: BindingCommonAdapter<String> = object :
        BindingCommonAdapter<String>(listOf("苹果", "香蕉", "橘子", "榴莲", "柠檬")) {
        override fun getItemViewType(position: Int): Int {
            return position%2
        }
        override fun createBindingViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BindingViewHolder<ViewBinding> {
            Log.e(TAG,"viewType $viewType")

            return  if (viewType == 0)  newBindingViewHolder<ItemTextBinding>(parent) else newBindingViewHolder<ItemText2Binding>(parent)
        }

        override fun bindData(
            viewHolder: BindingViewHolder<ViewBinding>,
            position: Int,
            data: String,
            itemType: Int
        ) {
            if (viewHolder.binding is ItemTextBinding){
                viewHolder.binding.tvText.text = data
            }else if (viewHolder.binding is ItemText2Binding){
                viewHolder.binding.tvText2.text = data
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1) ?: "GuChao"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvShow.text = "Hello $param1!"
        loadData()
    }

    private fun loadData() {
        binding.rcvContent.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = this@MainFragment.adapter
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}