package com.gopal.bigstepapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gopal.bigstepapp.data.entities.Results
import com.gopal.bigstepapp.databinding.ItemsListBinding
import android.view.View as View1

class ListAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<ViewHolder>() {

    interface ItemListener {
        fun onClickedCharacter(id: Results)
    }

    private val items = ArrayList<Results>()

    fun setItems(items: ArrayList<Results>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemsListBinding =
            ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])
}

class ViewHolder(
    private val itemBinding: ItemsListBinding,
    private val listener: ListAdapter.ItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View1.OnClickListener {

    private lateinit var items: Results

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Results) {
        this.items = item
        itemBinding.tvName.text = item.trackName
        itemBinding.tvSubName.text = item.artistName
        Glide.with(itemBinding.root)
            .load(item.artworkUrl30)
//            .transform(CircleCrop())
            .into(itemBinding.ivThumb)
    }

    override fun onClick(v: View1?) {
        listener.onClickedCharacter(items)
    }
}

