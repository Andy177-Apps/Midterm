package com.wenbin.publisher.hmoepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wenbin.publisher.data.Information
import com.wenbin.publisher.databinding.ItemInformationBinding

class HomePageAdapter : ListAdapter<Information,
        HomePageAdapter.ViewHolder>(MainDiffCallback) {


    class ViewHolder (
        private var binding : ItemInformationBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind (item : Information) {
            binding.information = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemInformationBinding.inflate(layoutInflater,
                    parent, false)
                return ViewHolder(binding)
            }
        }
    }

    object MainDiffCallback : DiffUtil.ItemCallback<Information>() {
        override fun areItemsTheSame(oldItem: Information, newItem: Information): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Information, newItem: Information): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position) as Information)

    }
}
