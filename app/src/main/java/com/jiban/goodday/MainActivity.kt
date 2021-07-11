package com.jiban.goodday

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.jiban.goodday.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private val viewModel: WeatherAndSohnViewModel by viewModels()

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

        // Returns View.NO_ID if nothing is checked.
        binding.radioGroup1.setOnCheckedChangeListener { group, checkedId ->
            val radio1: RadioButton = findViewById(checkedId)
            Toast.makeText(
                applicationContext,
                "On checked change : ${radio1.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.radioGroup2.setOnCheckedChangeListener { group, checkedId ->
            val radio2: RadioButton = findViewById(checkedId)
            Toast.makeText(
                applicationContext,
                "On checked change : ${radio2.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
//test
        binding.getBtn.setOnClickListener {

            var id1: Int = binding.radioGroup1.checkedRadioButtonId
            var id2: Int = binding.radioGroup2.checkedRadioButtonId

            val radio1: RadioButton = findViewById(id1)
            val radio2: RadioButton = findViewById(id2)

            if (id1 != - 1 && id2 != - 1) {
                Toast.makeText(
                    applicationContext, "On button click : ${radio1.text} and ${radio2.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (id1 == - 1 && id2 == - 1) {
                Toast.makeText(
                    applicationContext, "On button click : ${radio1.text} and ${radio2.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (id1 != - 1 || id2 != - 1) {
                if (id1 != - 1) {
                    Toast.makeText(
                        applicationContext, "On button click : ${radio1.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext, "On button click : ${radio2.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            //get the data
            val bundle = Bundle()
            val myMonth = binding.monthEt.text
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
}

