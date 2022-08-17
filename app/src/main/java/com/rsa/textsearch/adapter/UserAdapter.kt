package com.rsa.textsearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rsa.textsearch.R
import com.rsa.textsearch.model.UserModel

class UserAdapter(
    private val context: Context,
    private val userList: List<UserModel>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.name)
        val userId: TextView = itemView.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_adapter_layout, parent, false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = userList[position].name
        holder.userId.text = userList[position].id.toString()

    }

    private fun showMessage(s: String) {
        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}