package com.jiban.goodday.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.ItemMonthBinding


class InfoAdapter :
    ListAdapter<Info, InfoHolder>(InfosComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
        return InfoHolder(
            ItemMonthBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }

        holder.itemView.setOnClickListener {
            if (item != null) {
                //
            }
        }
    }
}

class InfoHolder(private val binding: ItemMonthBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(info: Info) = with(binding) {
        dayTv.text = info.day.toString()
        dayOfTheWeekTv.text = info.dayOfTheWeek
        koreaTv.text = info.korea.toString()
        seoulTv.text = info.seoul.toString()
        jejueTv.text = info.jejue.toString()
        gangwonTv.text = info.gangwon.toString()
        thedaywithoutSohnTv.text = info.theDayWithoutSohn
    }
}


object InfosComparator : DiffUtil.ItemCallback<Info>() {
    override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
        return oldItem == newItem
    }

}


