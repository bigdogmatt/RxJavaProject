package com.example.rxjavaproject.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavaproject.R
import com.example.rxjavaproject.data.model.User
import kotlinx.android.synthetic.main.row_user.view.*

class MyAdapter (private val userList: MutableList<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val colors : List<String> = listOf("#C0392B", "#F39C12", "#F1C40F", "#27AE60", "#3498DB", "#8E44AD")

    // Reuse adapter but refresh data used
    fun swapData(users: List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position], colors, position)
    }

    override fun getItemCount(): Int = userList.count()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User, colors: List<String>, position: Int) {
            itemView.user_gender.text = user.gender
            itemView.user_name.text = "${user.name?.first} ${user.name?.last}"
            val dob = user.dob?.date?.take(10)
            val age = user.dob?.age
            itemView.user_DOB.text = "DOB: $dob  Age: $age"
            val email = itemView.context.getString(R.string.email_label, user.email)
            itemView.user_email.text = email
            itemView.user_cell.text = "Cell: ${user.cell}"
            itemView.user_nat.text = "Nationality: ${user.nat}"

            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))
        }
    }
}