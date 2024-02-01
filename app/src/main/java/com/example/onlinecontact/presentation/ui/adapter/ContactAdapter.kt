package com.example.onlinecontact.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecontact.data.global.response.ContactResponse
import com.example.onlinecontact.databinding.ItemContactBinding

class ContactAdapter : ListAdapter<ContactResponse, ContactAdapter.ContactViewHolder>(MyDiffUtl) {

    object MyDiffUtl : DiffUtil.ItemCallback<ContactResponse>() {
        override fun areItemsTheSame(oldItem: ContactResponse, newItem: ContactResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ContactResponse,
            newItem: ContactResponse
        ): Boolean {
            return oldItem.firstName == newItem.lastName
        }

    }

    inner class ContactViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            Log.d("TTT", "adapter ${currentList[0].phone}")
            binding.textName.text = getItem(absoluteAdapterPosition).firstName
            binding.textNumber.text = getItem(absoluteAdapterPosition).phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder =
        ContactViewHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind()
    }
}