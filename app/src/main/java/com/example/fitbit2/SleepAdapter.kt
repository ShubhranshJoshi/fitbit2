package com.example.fitbit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter(private val sleepEntries: List<SleepEntry>) :
    RecyclerView.Adapter<SleepAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate: TextView = view.findViewById(R.id.textViewDate)
        val textViewHours: TextView = view.findViewById(R.id.textViewHours)
        val textViewQuality: TextView = view.findViewById(R.id.textViewQuality)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sleep_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = sleepEntries[position]
        holder.textViewDate.text = "Date: ${entry.date}"
        holder.textViewHours.text = "Hours: ${entry.hours}"
        holder.textViewQuality.text = "Quality: ${entry.quality}"
    }

    override fun getItemCount() = sleepEntries.size
}
