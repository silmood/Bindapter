package com.silmood.bindapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Main component to be used instead of any simple adapter
 */
class Bindapter<MODEL>(private val viewItemResId: Int,
                       private val itemVariableId: Int) : RecyclerView.Adapter<BindapterHolder<MODEL>>() {

    val items: MutableList<MODEL> = mutableListOf()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindapterHolder<MODEL> {
        val binding: ViewDataBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.context),
                        viewItemResId,
                        parent,
                        false)

        return BindapterHolder(binding)
    }

    override fun onBindViewHolder(holder: BindapterHolder<MODEL>, position: Int) {
        val item = items[position]
        holder.bindItem(itemVariableId, item)
    }
}