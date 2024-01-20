package com.example.demo_06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
//  イベント（休暇種、日付、休暇内容）
data class Event(val type: String, val date: LocalDate, val content: String)

class EventAdapter : ListAdapter<Event, EventAdapter.EventViewHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item_event, parent, false)
        return EventViewHolder(view)
    }


    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventTypeTextView: TextView = itemView.findViewById(R.id.eventTypeTextView)
        private val eventDateTextView: TextView = itemView.findViewById(R.id.eventDateTextView)
        private val eventContentTextView: TextView = itemView.findViewById(R.id.eventContentTextView)

        fun bind(event: Event) {
            eventTypeTextView.text = event.type
            eventDateTextView.text = event.date.toString()
            eventContentTextView.text = event.content
        }
    }

    class EventDiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }
}
