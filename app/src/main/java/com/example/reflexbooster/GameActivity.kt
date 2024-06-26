package com.example.reflexbooster

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.reflexbooster.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityGameBinding
    private  var score : Int = 0
    private  var usedIx: Int? = null
    var imageList = ArrayList<ImageView>()
    var runnable =  Runnable{}
    var handler = Handler(Looper.getMainLooper())
    private  var intentedNo:Int? = null

    private var  imageSpeed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageList.add(binding.imageView)
        imageList.add(binding.imageView2)
        imageList.add(binding.imageView3)
        imageList.add(binding.imageView4)
        imageList.add(binding.imageView19)
        imageList.add(binding.imageView18)
        imageList.add(binding.imageView17)
        imageList.add(binding.imageView16)
        imageList.add(binding.imageView15)
        imageList.add(binding.imageView22)
        imageList.add(binding.imageView24)
        imageList.add(binding.imageView25)
        imageList.add(binding.imageView26)
        imageList.add(binding.imageView27)
        imageList.add(binding.imageView28)
        imageList.add(binding.imageView14)
        imageList.add(binding.imageView13)
        imageList.add(binding.imageView12)
        imageList.add(binding.imageView11)
        imageList.add(binding.imageView10)
        imageList.add(binding.imageView35)
        imageList.add(binding.imageView34)
        imageList.add(binding.imageView33)
        imageList.add(binding.imageView32)
        imageList.add(binding.imageView31)


        hideImages()


        intent = intent
         intentedNo = intent.getIntExtra("info",3)

        if(intentedNo == 0){
            imageSpeed = 600
        }else if(intentedNo == 1){
            imageSpeed = 400
        }else{
            imageSpeed = 300
        }

        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time: ${millisUntilFinished/1000}"
            }
            override fun onFinish() {
                for(image in imageList){
                    image.visibility = View.INVISIBLE
                }
                handler.removeCallbacks(runnable)


                val alert = AlertDialog.Builder(this@GameActivity)
                alert.setTitle("Oyun Bitti")
                alert.setMessage("Skorunuz ${score}")

                alert.setNeutralButton("Menüye Dön",DialogInterface.OnClickListener { dialog, it ->
                    val intent = Intent(this@GameActivity,MainActivity::class.java)
                    finish()
                    startActivity(intent)

                }).show()

            }
        }.start()

    }


    fun hideImages() {

        runnable = object  : Runnable{
            override fun run() {

                for(image in imageList){
                    image.visibility =View.INVISIBLE
                }
                val random = java.util.Random()
                val randomIndex = random.nextInt(imageList.size)
                imageList[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable,imageSpeed)

            }

        }
        handler.post(runnable)

    }

    fun increaseScore(view: View){
        score = score + 1
        binding.scoreText.text = "Score: $score"

    }
}