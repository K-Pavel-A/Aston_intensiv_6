package ru.aston.astonintensiv5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.aston.astonintensiv5.R
import ru.aston.astonintensiv5.databinding.ContactBinding

class ContactListAdapter(
    private val onContactClicked: (Contacts) -> Unit
) : ListAdapter<Contacts, ContactListAdapter.ContactViewHolder>(DiffCallback) {

    class ContactViewHolder(val binding: ContactBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contacts: Contacts) {
            with(binding) {
                nameTextview.text = contacts.name
                secondnameTextview.text = contacts.secondName
                phonenumberTextview.text = contacts.phoneNumber

                Picasso.get().load(contacts.pictureUri)
                    .placeholder(R.drawable.ic_android_black_70dp)
                    .error(R.drawable.ic_android_black_70dp)
                    .into(pictureView)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
        holder.binding.root.setOnClickListener {
            onContactClicked(contact)
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<Contacts>() {
        override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts) =
            oldItem == newItem
    }

}
