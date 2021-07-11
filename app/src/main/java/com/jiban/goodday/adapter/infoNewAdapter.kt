package com.jiban.goodday.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.ItemGooddayBinding


class InfoNewAdapter :
    ListAdapter<Info, InfoNewHolder>(InfoNewsComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoNewHolder {
        return InfoNewHolder(
            ItemGooddayBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: InfoNewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }

        holder.itemView.setOnClickListener {
            if (item != null) {
                //
            }
        }
    }
}

class InfoNewHolder(private val binding: ItemGooddayBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(info: Info) = with(binding) {
        dayTv.text = info.day.toString()
        dayOfTheWeekTv.text = info.dayOfTheWeek
    }
}


object InfoNewsComparator : DiffUtil.ItemCallback<Info>() {
    override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem == newItem
    }

}


