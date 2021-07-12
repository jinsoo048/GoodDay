package com.jiban.goodday.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiban.goodday.CellClickListener
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.ItemGooddayBinding


private var _binding: ItemGooddayBinding? = null
private val binding get() = _binding !!

class InfoNewAdapter(private val cellClickListener: CellClickListener) :
    ListAdapter<Info, InfoNewViewHolder>(InfoNewsComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoNewViewHolder {
        _binding = ItemGooddayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InfoNewViewHolder(_binding !!)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: InfoNewViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }

        holder.binding.itemCard.setOnClickListener {
            if (item != null) {
                binding.itemCard.isChecked = binding.itemCard.isChecked
                cellClickListener.onCellClickListener(item)
            }
        }
    }
}

class InfoNewViewHolder(internal val binding: ItemGooddayBinding) :
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


