package xyz.akshay.habittracker.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import xyz.akshay.habittracker.R
import xyz.akshay.habittracker.db.entity.Habits

/**
 * Created by
 * anandwana001 on
 * 09-08-2018 at
 * 12:07 PM.
 */
class HabitListAdapter internal constructor(context: Context) : RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {

    private val mInflater: LayoutInflater
    private var habitsList: List<Habits>? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return HabitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        if (habitsList != null) {
            val (habit) = habitsList!![position]
            holder.habitItemView.text = habit
        } else {
            holder.habitItemView.text = "No Word"
        }
    }

    override fun getItemCount(): Int {
        return if (habitsList != null)
            habitsList!!.size
        else
            0
    }

    internal fun setWords(habitsList: List<Habits>) {
        this.habitsList = habitsList
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(itemView: View) : ViewHolder(itemView) {

        val habitItemView: TextView

        init {
            habitItemView = itemView.findViewById(R.id.textView)
        }
    }
}
