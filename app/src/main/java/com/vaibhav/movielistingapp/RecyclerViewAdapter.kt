package com.vaibhav.movielistingapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    var data: MovieResponse,
    val context: Context,
    //val onItemClickListener: OnItemCLickListener?
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //var onItemClickListener : OnItemCLickListener? = null

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textview = itemView.findViewById<TextView>(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflator: LayoutInflater = LayoutInflater.from(parent.context)
        var view: View = inflator.inflate(R.layout.row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var text: String? = data!!.docs[position].name
        holder.textview.setText(text)
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                context,
                ("$text clicked!" + data.docs[position].Id + data.docs[position].name),
                Toast.LENGTH_SHORT
            ).show()

        })
    }

    override fun getItemCount(): Int {
        return data!!.total!!
    }


}

