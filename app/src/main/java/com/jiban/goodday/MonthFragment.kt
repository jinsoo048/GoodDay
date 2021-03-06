package com.jiban.goodday

//import androidx.fragment.app.viewModels

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jiban.goodday.adapter.InfoNewAdapter
import com.jiban.goodday.data.Info
import com.jiban.goodday.databinding.FragmentMonthBinding
import com.jiban.goodday.viewmodels.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job


@AndroidEntryPoint
class MonthFragment : Fragment(), CellClickListener {

    private val adapter = InfoNewAdapter(context, this)
    private var searchJob: Job? = null
    private val infoViewModel: InfoViewModel by viewModels()
    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding !!

    //data transaction of bundle
    private var myMonthString: String? = null
    private var myMonth: Int = 0
    private var myDo: String? = null
    private var myGo: String? = null

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMonthBinding.inflate(inflater, container, false)

        myMonthString = arguments !!.getString("myMonth")
        myDo = arguments !!.getString("myDo")
        myGo = arguments !!.getString("myGo")

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    val fragment: Fragment = InputFragment()
                    //fragment.arguments = bundle
                    val transaction: FragmentTransaction =
                        requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.myFrame, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            })

        //header Month getString
        binding.headerMonthTv.text = myMonthString

        //recyclerview adapter
        binding.frgmentRv.adapter = adapter
        binding.frgmentRv.layoutManager = GridLayoutManager(context, 3)
        myMonth = myMonthString !!.toInt()

        if (myMonth != null) {
            when (myDo) {
                "Outdoor" -> {
                    when (myGo) {
                        "Korea" -> {
                            displayInfosByMonthExcerciseAndKorea(myMonth)
                        }
                        "Seoul" -> {
                            displayInfosByMonthOutdoorAndSeoul(myMonth)
                        }
                        "Jeju" -> {
                            displayInfosByMonthOutdoorAndjejue(myMonth)
                        }
                        "Gangwon" -> {
                            displayInfosByMonthOutdoorAndGangwon(myMonth)
                        }
                    }
                }
                "Move" -> {
                    Log.d("JJS", "Move")
                    val sohn: String = "yes"
                    when (myGo) {
                        "Korea" -> {
                            displayInfosByMonthMoveAndKorea(myMonth)
                        }
                        "Seoul" -> {
                            displayInfosByMonthMoveAndSeoul(myMonth)
                        }
                        "Jeju" -> {
                            displayInfosByMonthMoveAndJejue(myMonth)
                        }
                        "Gangwon" -> {
                            displayInfosByMonthMoveAndGangwon(myMonth)
                        }
                    }
                }
                "Love" -> {
                    when (myGo) {
                        "Korea" -> {
                            //displayInfosByMonthLoveAndKorea()
                        }
                        "Seoul" -> {
                            //displayInfosByMonthLoveAndSeoul()
                        }
                        "Jeju" -> {
                            //displayInfosByMonthLoveAndJejue()
                        }
                        "Gangwon" -> {
                            //displayInfosByMonthLoveAndGangwon()
                        }
                    }
                }
                "Money" -> {
                    when (myGo) {
                        "Korea" -> {
                            //displayInfosByMonthMoneyAndKorea()
                        }
                        "Seoul" -> {
                            //displayInfosByMonthMoneyAndSeoul()
                        }
                        "Jeju" -> {
                            //displayInfosByMonthMoneyAndJejue()
                        }
                        "Gangwon" -> {
                            //displayInfosByMonthMoneyAndGangwon()
                        }
                    }
                }
            }
        }
        return binding.root
    }

    private fun displayInfosByMonth(myMonth: Int) {
        infoViewModel.getSearchMonth(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthExcerciseAndKorea(myMonth: Int) {
        infoViewModel.getSearchMonthOutdoorAndKorea(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndSeoul(myMonth: Int) {
        infoViewModel.getSearchMonthOutdoorAndSeoul(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndjejue(myMonth: Int) {
        infoViewModel.getSearchMonthOutdoorAndjejue(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthOutdoorAndGangwon(myMonth: Int) {
        infoViewModel.getSearchMonthOutdoorAndGangwon(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndKorea(myMonth: Int) {
        infoViewModel.getSearchMonthMoveAndKorea(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndSeoul(myMonth: Int) {
        infoViewModel.getSearchMonthMoveAndSeoul(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndJejue(myMonth: Int) {
        infoViewModel.getSearchMonthMoveAndJejue(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    private fun displayInfosByMonthMoveAndGangwon(myMonth: Int) {
        infoViewModel.getSearchMonthMoveAndGangwon(myMonth)
            .observe(viewLifecycleOwner, Observer<List<Info>> { infos ->
                adapter.submitList(infos)
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCellClickListener(data: Info) {
        Toast.makeText(
            activity,
            "Cell clicked, Month: ${data.month}, Day: ${data.day}",
            Toast.LENGTH_SHORT
        ).show()

        context?.let {
            MaterialAlertDialogBuilder(it)
                .setTitle(resources.getString(R.string.title))
                .setMessage(
                    "???????????? ?????? ${myMonth}??? ${data.day}??? ${data.dayOfTheWeek} ?????????.\n" +
                            "????????? ?????? ????????? ${myDo} ?????????.\n" +
                            "???????????? ${myGo}?????????.\n" +
                            "????????? ????????? ????????? ????????????.\n\n" +
                            when (myGo) {
                                "Korea" -> {
                                    "- ?????? : ${(data.korea.toDouble() / 15 * 100).toInt()}% \n\n"
                                }
                                "Seoul" -> {
                                    "- ?????? : ${(data.seoul.toDouble() / 15 * 100).toInt()}% \n\n"
                                }
                                "Jeju" -> {
                                    "- ?????? : ${(data.jejue.toDouble() / 15 * 100).toInt()}% \n\n"
                                }
                                "Gangwon" -> {
                                    "- ?????? : ${(data.gangwon.toDouble() / 15 * 10).toInt()}% \n\n"
                                }
                                else -> {
                                }
                            } +

                            if (data.theDayWithoutSohn == "yes") {
                                "?????? ?????? ????????????\n"
                            } else {
                                "?????? ?????? ????????????\n"
                            }
                )
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                   // dialog.dismiss()
                }
                .show()
        }
    }
}




