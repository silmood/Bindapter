package com.silmood.bindapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BindapterHolder<in MODEL>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(itemVariableId: Int, item: MODEL) {
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings()
    }

    fun bindVariable(variableId: Int, variable: Any) {
        binding.setVariable(variableId, variable)
        binding.executePendingBindings()
    }

}