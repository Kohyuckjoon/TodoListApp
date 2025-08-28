package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.databinding.ItemContentBinding
import com.example.myapplication.model.ContentEntity

class ListAdapter(private val handler: MainActivity.Handler) : androidx.recyclerview.widget.ListAdapter<ContentEntity, ContentViewholder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewholder {
        return ContentViewholder(
            ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            handler
        )
    }

    override fun onBindViewHolder(holder: ContentViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object :DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}