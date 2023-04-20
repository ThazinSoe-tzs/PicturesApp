package com.tzs.picturesapp.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.tzs.picturesapp.R
import com.tzs.picturesapp.databinding.ItemPictureBinding
import com.tzs.picturesapp.model.data.model.Photo
import javax.inject.Inject

class PhotoAdapter @Inject() constructor() :
    PagingDataAdapter<Photo, PhotoAdapter.ViewHolder>(differCallback) {

    private lateinit var binding: ItemPictureBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemPictureBinding.inflate(inflater, parent, false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.setIsRecyclable(false)
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Photo) {
            binding.apply {
                tvAuthorName.text = item.author
                ivPic.load(item.downloadUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_image_24)
                    scale(Scale.FILL)
                }

                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((Photo) -> Unit)? = null

    fun setOnItemClickListener(listener: (Photo) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        val differCallback = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }

}