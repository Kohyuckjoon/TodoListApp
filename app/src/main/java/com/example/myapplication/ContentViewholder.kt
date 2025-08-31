package com.example.myapplication

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemContentBinding
import com.example.myapplication.model.ContentEntity

class ContentViewholder (
    private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root){
    fun bind(item : ContentEntity) {
        binding.item = item
        binding.handler = handler

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}