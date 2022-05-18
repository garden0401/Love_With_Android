package com.example.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemStickerListBinding

class StickerAdapter : RecyclerView.Adapter<StickerAdapter.StickerViewHolder>() {
    private var stickerList : MutableList<StickerData> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StickerViewHolder {
        val binding = ItemStickerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return StickerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StickerViewHolder, position: Int) {
        holder.onBind(stickerList[position])
    }

    override fun getItemCount(): Int = stickerList.size

    fun setItem(items: MutableList<StickerData>) {
        if(!items.isNullOrEmpty()) {
            stickerList = items
            notifyDataSetChanged()
        }
    }

    class StickerViewHolder(private val binding: ItemStickerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data: StickerData) {
                binding.tvStickerSenderName.text = data.name
            }
        }
}