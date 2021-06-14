package com.gopal.bigstepapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gopal.bigstepapp.data.entities.Results
import com.gopal.bigstepapp.databinding.ItemsListBinding

class HistoryAdapter() :
    RecyclerView.Adapter<HistoryViewHolder>() {

    private val items = ArrayList<Results>()

    fun setItems(items: ArrayList<Results>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding: ItemsListBinding =
            ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) =
        holder.bind(items[position])
}

class HistoryViewHolder(
    private val itemBinding: ItemsListBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var items: Results


    fun bind(item: Results) {
        this.items = item
        itemBinding.tvName.text = item.trackName
        itemBinding.tvSubName.text = item.artistName

    }


}

