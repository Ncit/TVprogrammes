package com.test.tvprogramepg.api.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.test.tvprogramepg.R
import com.test.tvprogramepg.api.models.ChannelModel
import com.test.tvprogramepg.databinding.ChannelLayoutBinding


class ChannelViewHolder(private val binding: ChannelLayoutBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(model: ChannelModel)
    {
        binding.name.text = model.name
        Glide.with(binding.root.context)
            .load(model.icon?.src ?: "")
            .placeholder(R.drawable.tv)
            .priority(Priority.LOW)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(binding.logo)
    }

    fun setListener(block: (() -> Unit))
    {
        binding.cardHolder.setOnClickListener {
            block.invoke()
        }
    }
}
