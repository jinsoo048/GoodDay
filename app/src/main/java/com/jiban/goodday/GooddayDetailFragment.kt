package com.jiban.goodday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.FragmentGooddayDetailBinding

class GooddayDetailFragment(
    var data: Info,
    var myMonth: Int,
    var myDo: String?,
    var myGo: String?
) : Fragment() {

    private var _binding: FragmentGooddayDetailBinding? = null
    private val binding get() = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGooddayDetailBinding.inflate(inflater, container, false)
        binding.monthTv.text = myMonth.toString()
        val view = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
