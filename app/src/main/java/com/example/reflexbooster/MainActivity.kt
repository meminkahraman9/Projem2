package com.example.reflexbooster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.reflexbooster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding
    private  var intentNo : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.infoText.visibility = View.INVISIBLE
        binding.startImage.isEnabled = false

    }

    fun start(view: View){


        val infoText = binding.infoText.text.toString()

        if (infoText == "beginner"){
            intentNo = 0
        }else if (infoText == "normal"){
            intentNo = 1
        }else {
            intentNo = 2
        }

        val intent = Intent(this@MainActivity, GameActivity::class.java)
                intent.putExtra("info", intentNo)
                finish()
                startActivity(intent)
            }

    fun beginner(view: View){

        binding.infoText.setText("beginner")
        binding.startImage.isEnabled = true

        binding.beginnerText.setTextColor(resources.getColor(R.color.white))
        binding.beginnerText.setBackgroundColor(resources.getColor(R.color.black))

        binding.normalText.setTextColor(resources.getColor(R.color.blue))
        binding.normalText.setBackgroundColor(resources.getColor(R.color.black))

        binding.expertText.setTextColor(resources.getColor(R.color.blue))
        binding.expertText.setBackgroundColor(resources.getColor(R.color.black))

    }

    fun normal(view: View){

        binding.infoText.setText("normal")
        binding.startImage.isEnabled = true

        binding.normalText.setTextColor(resources.getColor(R.color.white))
        binding.normalText.setBackgroundColor(resources.getColor(R.color.black))

        binding.beginnerText.setTextColor(resources.getColor(R.color.blue))
        binding.beginnerText.setBackgroundColor(resources.getColor(R.color.black))

        binding.expertText.setTextColor(resources.getColor(R.color.blue))
        binding.expertText.setBackgroundColor(resources.getColor(R.color.black))

    }

    fun expert(view: View){

        binding.infoText.setText("expert")
        binding.startImage.isEnabled = true

        binding.expertText.setTextColor(resources.getColor(R.color.white))
        binding.expertText.setBackgroundColor(resources.getColor(R.color.black))

        binding.beginnerText.setTextColor(resources.getColor(R.color.blue))
        binding.beginnerText.setBackgroundColor(resources.getColor(R.color.black))

        binding.normalText.setTextColor(resources.getColor(R.color.blue))
        binding.normalText.setBackgroundColor(resources.getColor(R.color.black))

    }



}
