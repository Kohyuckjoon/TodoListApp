package com.example.myapplication

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemContentBinding
import com.example.myapplication.model.ContentEntity

class ContentViewholder (
    private val binding: ItemContentBinding,
) : RecyclerView.ViewHolder(binding.root){
    fun bind(item : ContentEntity) {
        binding.item = item

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}