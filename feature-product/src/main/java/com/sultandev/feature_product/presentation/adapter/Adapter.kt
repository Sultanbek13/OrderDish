package com.sultandev.feature_product.presentation.adapter


import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val delegates: List<AdapterDelegate<*>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<Any> = mutableListOf()

    private var onItemClickListener: ((Any) -> Unit)? = null

    fun setOnItemClickListener(listener: (Any) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val delegate = delegates[viewType]
        return delegate.onCreateViewHolder(parent)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        val delegate = delegates.find { it.isForItemType(item) }
        @Suppress("UNCHECKED_CAST")
        (delegate as? AdapterDelegate<Any>)?.onBindViewHolder(item, holder)

        if(holder is TagItemViewHolder) {
            holder.setOnItemClickListener { t, currentPos, prevPos ->
                onItemClickListener?.invoke(t)
                notifyItemChanged(prevPos)
                notifyItemChanged(currentPos)
            }
        }

        if(holder is ProductItemViewHolder) {
            holder.setOnItemClickListener {
                onItemClickListener?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        val delegateIndex = delegates.indexOfFirst { it.isForItemType(item) }
        return if (delegateIndex != -1) delegateIndex else throw IllegalArgumentException("No delegate found for item at position: $position")
    }

    fun setItems(newItems: List<Any>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}