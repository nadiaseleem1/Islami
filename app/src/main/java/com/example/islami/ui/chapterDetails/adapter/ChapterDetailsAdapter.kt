package com.example.islami.ui.chapterDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemVerseBinding

class ChapterDetailsAdapter(private val items: List<String>) :
    RecyclerView.Adapter<ChapterDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.verse.text = items[position]
    }

    class ViewHolder(val binding: ItemVerseBinding) : RecyclerView.ViewHolder(binding.root)


}

