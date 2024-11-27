package com.hrithikvish.krypto.presentation.xml_views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.krypto.databinding.TagItemBinding
import com.hrithikvish.krypto.presentation.xml_views.adapter.TagsRvAdapter.TagsViewHolder

class TagsRvAdapter: RecyclerView.Adapter<TagsViewHolder>() {

    private val tagList = mutableListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitTags(tagsList: List<String>) {
        tagList.clear()
        tagList.addAll(tagsList)
        notifyDataSetChanged()
    }

    inner class TagsViewHolder(val binding: TagItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val binding = TagItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        with(holder.binding) {
            tag = tagList[position]
        }
    }

    override fun getItemCount(): Int = tagList.size

}