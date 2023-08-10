package com.example.islami.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding

class ChapterNamesAdapter(private val items: List<String>) :
    RecyclerView.Adapter<ChapterNamesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.chapterName.text = items[position]
        holder.itemView.setOnClickListener {
            onChapterClick.invoke(items[position], position)
        }
    }

    class ViewHolder(val binding: ItemChapterNameBinding) : RecyclerView.ViewHolder(binding.root)

    lateinit var onChapterClick: ((String, Int) -> Unit)

}