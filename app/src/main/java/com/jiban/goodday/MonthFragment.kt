package com.jiban.goodday

//import androidx.fragment.app.viewModels

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.jiban.goodday.adapter.InfoAdapter
import com.jiban.goodday.adapter.InfoNewAdapter
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.FragmentMonthBinding
import com.jiban.goodday.viewmodels.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class MonthFragment : Fragment() {

    private val adapter = InfoNewAdapter()
    private var searchJob: Job? = null

    private val infoViewModel: InfoViewModel by viewModels()

    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding !!

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMonthBinding.inflate(inflater, container, false)

        val myMonth = this.arguments !!.getString("myMonth")
        val myDo = this.arguments !!.getString("myDo")
        val myGo = this.arguments !!.getString("myGo")

        //header Month getString
        binding.headerMonthTv.text = myMonth

        //recyclerview adapter
        binding.frgmentRv.adapter = adapter
        binding.frgmentRv.layoutManager = GridLayoutManager(context, 2)

        //binding.frgmentRv.layoutManager = LinearLayoutManager(context)
        //displayInfo(adapter)

        //getSearchMonthOutdoorAndKorea(myMonth: String)
        if (myMonth != null) {
            when (myDo) {
                "Outdoor" -> {
                    Log.d("JJS", "Outdoor")
                    when (myGo) {
                        "Korea" -> {
                            Log.d("JJS", "Korea")
                            displayInfosByMonthExcerciseAndKorea(myMonth)
                        }
                        "Seoul" -> {
                            Log.d("JJS", "Seoul")
                            displayInfosByMonthOutdoorAndSeoul(myMonth)

                        }
                        "Jeju" -> {
                            Log.d("JJS", "Jeju")
                            displayInfosByMonthOutdoorAndjejue(myMonth)

                        }
                        "Gangwon" -> {
                            Log.d("JJS", "Gangwon")
                            displayInfosByMonthOutdoorAndGangwon(myMonth)

                        }
                    }
                }
                "Move" -> {
                    Log.d("JJS", "Move")
                    val sohn: String = "yes"
                    when (myGo) {
                        "Korea" -> {
                            Log.d("JJS", "Korea")
                            displayInfosByMonthMoveAndKorea(myMonth)

                        }
                        "Seoul" -> {
                            Log.d("JJS", "Seoul")
                            displayInfosByMonthMoveAndSeoul(myMonth)

                        }
                        "Jeju" -> {
                            Log.d("JJS", "Jeju")
                            displayInfosByMonthMoveAndJejue(myMonth)

                        }
                        "Gangwon" -> {
                            Log.d("JJS", "Gangwon")
                            displayInfosByMonthMoveAndGangwon(myMonth)

                        }
                    }

                }
                "Love" -> {
                    Log.d("JJS", "Love")
                    when (myGo) {
                        "Korea" -> {
                            Log.d("JJS", "Korea")
                            //displayInfosByMonthLoveAndKorea()

                        }
                        "Seoul" -> {
                            Log.d("JJS", "Seoul")
                            //displayInfosByMonthLoveAndSeoul()

                        }
                        "Jeju" -> {
                            Log.d("JJS", "Jeju")
                            //displayInfosByMonthLoveAndJejue()

                        }
                        "Gangwon" -> {
                            Log.d("JJS", "Gangwon")
                            //displayInfosByMonthLoveAndGangwon()

                        }
                    }

                }
                "Money" -> {
                    Log.d("JJS", "Money")
                    when (myGo) {
                        "Korea" -> {
                            Log.d("JJS", "Korea")
                            //displayInfosByMonthMoneyAndKorea()

                        }
                        "Seoul" -> {
                            Log.d("JJS", "Seoul")
                            //displayInfosByMonthMoneyAndSeoul()

                        }
                        "Jeju" -> {
                            Log.d("JJS", "Jeju")
                            //displayInfosByMonthMoneyAndJejue()

                        }
                        "Gangwon" -> {
                            Log.d("JJS", "Gangwon")
                            //displayInfosByMonthMoneyAndGangwon()

                        }
                    }

                }
            }
        }

        val view = binding.root
        return view

    }


    private fun displayInfosByMonth(myMonth: String) {
        infoViewModel.getSearchMonth(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthExcerciseAndKorea(myMonth: String) {
        infoViewModel.getSearchMonthOutdoorAndKorea(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndSeoul(myMonth: String) {
        infoViewModel.getSearchMonthOutdoorAndSeoul(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndjejue(myMonth: String) {
        infoViewModel.getSearchMonthOutdoorAndjejue(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndGangwon(myMonth: String) {
        infoViewModel.getSearchMonthOutdoorAndGangwon(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndKorea(myMonth: String) {
        infoViewModel.getSearchMonthMoveAndKorea(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndSeoul(myMonth: String) {
        infoViewModel.getSearchMonthMoveAndSeoul(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndJejue(myMonth: String) {
        infoViewModel.getSearchMonthMoveAndJejue(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndGangwon(myMonth: String) {
        infoViewModel.getSearchMonthMoveAndGangwon(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }


    private fun displayInfo(adapter: InfoAdapter) {
        infoViewModel.infos.observe(viewLifecycleOwner) { infos ->
            adapter.submitList(infos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}



