package com.jiban.goodday

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jiban.goodday.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Opening Fragment
        val fragment: Fragment = OpenFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.myFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        //month menu
        val thisMonth: Int = Calendar.getInstance().get(Calendar.MONTH)

        //Year setting to the UI
        val thisYear: Int = Calendar.getInstance().get(Calendar.YEAR)
        binding.yearTv.text = thisYear.toString()

        var intList: ArrayList<Int> = arrayListOf()
        var intMonth: Int = 0
        var intBuf = thisMonth

        for (i in 0 until 12 - (thisMonth)) {
            intBuf ++
            intList.add(intBuf)
        }
        val adapter = ArrayAdapter(this, R.layout.item_monthmenu, intList)
        binding.monthAutoComplete.setAdapter(adapter)
        binding.monthAutoComplete.setOnItemClickListener { _, _, position, _ ->
            intMonth = ((adapter.getItem(position) ?: "") as Int)
            Toast.makeText(this, intMonth.toString() + "월을 선택하셨습니다!", Toast.LENGTH_SHORT).show()
        }

        // button processing
        binding.getBtn.setOnClickListener {
            Toast.makeText(this, intMonth.toString() + "월의 Good Day를 검색합니다.", Toast.LENGTH_SHORT)
                .show()
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    Log.d("JJS", "Search some Good Days")
                }
            }, 5000)

            val id1: Int = binding.radioGroup1.checkedRadioButtonId
            val id2: Int = binding.radioGroup2.checkedRadioButtonId
            val radio1: RadioButton = findViewById(id1)
            val radio2: RadioButton = findViewById(id2)

            //get the data
            val bundle = Bundle()

            if (intMonth == 0) {
                Toast.makeText(this, "원하시는 월을 선택해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val myMonth = intMonth
            val myDo = radio1.text
            val myGo = radio2.text

            bundle.putString("myMonth", myMonth.toString())
            bundle.putString("myDo", myDo.toString())
            bundle.putString("myGo", myGo.toString())

            val fragment: Fragment = MonthFragment()
            fragment.arguments = bundle
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.myFrame, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_button1_3 ->
                    if (checked) {
                        Toast.makeText(
                            this,
                            "Under Construction by Based on statistical data and the study of Yin-Yang and Five Elements ",
                            LENGTH_LONG
                        ).show()
                        view.isChecked = false
                    }
                R.id.radio_button1_4 ->
                    if (checked) {
                        Toast.makeText(
                            this,
                            "Under Construction by Based on statistical data and the study of Yin-Yang and Five Elements ",
                            LENGTH_LONG
                        ).show()
                        view.isChecked = false
                    }
            }
        }
    }
}



