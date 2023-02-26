package com.example.myandroidapplication

// Here import Some important packages and Libraries etc
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidapplication.databinding.ActivityMainBinding

// MainActivity is Main Class Which Inherit AppCompatActivity Class And Implements View Interface Which Have OnClickListener function
class MainActivity : AppCompatActivity(), View.OnClickListener {

    //binding is ViewBinding Class Reference Variable
    // We will initialize Our All View Which Contain activity main xml file with the help of binding at one time
    private lateinit var binding:ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        // this override function Create Our Activity
        super.onCreate(savedInstanceState)
        // Here initialize our All View at one Time
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       Log.d(TAG, "onCreate()")
        // Here I will set click listener on Button and in which pass our object means this keyword
        binding.btnCalculate.setOnClickListener(this)

    }
    // this override function Start Our Activity
   @RequiresApi(Build.VERSION_CODES.R)
   override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }
    // this override function Resume our Activity to interact with User
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }
    // this override function  will be Call before  when our Application will be go in Backward
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }
    // this override function will be call when our Application will be go in Backward
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }
    // this override function will be call when Our Application Again Call
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }
    // this override function will be call when our application will Final Remove from Stack Memory
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    @SuppressLint(/* ...value = */ "SetTextI18n")
    // This is Button Click Event  function to perform Click when you will Click on Button
    override fun onClick(view: View?) {
        // Here I get Input from User By EditText This input will be User Weight and store this in weightkg
        val weightkg = binding.etInputKg.text.toString().toDouble()
        // Here I get Input from User By EditText This input will be User Height and store this in heightcm
        val heightcm = binding.etInputCm.text.toString().toDouble()
        // This is function to calculate BMI  and this is Call our function
        val showresult = calculatebmi(weightkg, heightcm)
        // this is Format Our Output like that 3.14 two step after point
        val ninFormate = "%.2f".format(showresult)
        // this statement is Set to input Our TextView to View Our Output
        binding.tvShowValue.text = "BMI Value is - $ninFormate"
        // this Statement is Switch Case it is used to select one result from Multiple Choices
        when (ninFormate.toDouble()) {
            in 14.00..16.00 -> {
                binding.messageForUser.text = " You are Severely Underweight "
                Toast.makeText(
                    this,
                    " Suggestion For You - You Need to Gain Good Weight For Your Health to Fit ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 16.00..18.40 -> {
                binding.messageForUser.text = " You are Underweight "
                Toast.makeText(
                    this,
                    " Suggestion For You - You Need to Gain Weight For Your Health ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 18.50..24.90 -> {
                binding.messageForUser.text = " You are Normal "
                Toast.makeText(
                    this,
                    " Good News - You are Fit and Healthy. and Keep Your Health Well ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 25.00..29.90 -> {
                binding.messageForUser.text = " You are Overweight "
                Toast.makeText(
                    this,
                    " Advise For You - You Need to Loose Your Weight to get Your Good Health ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 30.00..34.90 -> {
                binding.messageForUser.text = " You are Moderately Obese "
                Toast.makeText(
                    this,
                    " Suggestion For You - You Need to Lose Your Weight a Large Scale to get Good Health ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 35.00..39.90 -> {
                binding.messageForUser.text = " You are Severely Obese "
                Toast.makeText(
                    this,
                    " Suggestion For You - You Have to Loose Your Weight a Large Scale  ",
                    Toast.LENGTH_LONG
                ).show()
            }
            in 40.00..50.00 -> {
                binding.messageForUser.text = " You are Morbidly Obese "
                Toast.makeText(
                    this,
                    " Suggestion For You - You Have to Loose Your Weight to get Health and Fitness ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        // Here i Clear EditText one and two
       // binding.etInputKg.setText("")
       // binding.etInputCm.setText("")
    }
}
// this is function to calculate BMI and this function definition
fun calculatebmi(wk: Double, hcm: Double): Double {
    val cmtom = hcm / 100
    return wk / (cmtom * cmtom)
}

