package com.jiban.goodday.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.lzyzsd.randomcolor.RandomColor
import com.jiban.goodday.CellClickListener
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.ItemGooddayBinding
import java.util.*


@SuppressLint("StaticFieldLeak")
private var _binding: ItemGooddayBinding? = null
private val binding get() = _binding !!

class InfoNewAdapter(val context: Context?, private val cellClickListener: CellClickListener) :
    ListAdapter<Info, InfoNewViewHolder>(InfoNewsComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoNewViewHolder {
        _binding = ItemGooddayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InfoNewViewHolder(parent.context, _binding !!)
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

class InfoNewViewHolder(val context: Context?, internal val binding: ItemGooddayBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("RestrictedApi", "UseCompatLoadingForDrawables")
    fun bind(info: Info) = with(binding) {
        //color setting
        //val randomColor = (0x000000..0xFFFFFF).random()
        //itemCard.setCardBackgroundColor(randomColor)


        // create object of Random class
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        //itemCard.setCardForegroundColor(color)
        //println(colorCode)

        val randomColor = RandomColor()
        itemCard.setCardBackgroundColor(randomColor.randomColor())


        //image binding
        val random = (1..30).random()
        val imageName = "m$random"
        val resId: Int =
            context !!.resources.getIdentifier(imageName, "drawable", context.packageName)
        if (resId != null) {
            binding.monthIv.setImageResource(resId)
        } else {
            Toast.makeText(context, "still loading a image!", Toast.LENGTH_SHORT)
        }

        //monthIv.setImageResource(resId)
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


