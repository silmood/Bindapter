package com.silmood.bindapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class Bindapter<MODEL>(private val viewItemResId: Int,
                       private val itemVariableId: Int) : RecyclerView.Adapter<BindapterHolder<MODEL>>() {

    private var handler: Any?
    private var handlerId: Int?
    private val items: MutableList<MODEL> = mutableListOf()

    init {
        handler = null
        handlerId = null
    }

    constructor(viewItemResId: Int,
                itemVariableId: Int,
                handler: Any,
                handlerId: Int): this(viewItemResId, itemVariableId) {
        this.handler =  handler
        this.handlerId = handlerId
    }

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

        handler?.let {
            holder.bindVariable(handlerId!!, handler!!)
        }
    }

    fun addItem(item: MODEL) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItems(items: List<MODEL>) {
        val previousSize = this.items.size - 1

        this.items.addAll(items)
        notifyItemRangeInserted(previousSize, items.size)
    }

    fun replaceItems(items: List<MODEL>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        this.items.removeAt(position)
        notifyItemRemoved(position)
    }

}