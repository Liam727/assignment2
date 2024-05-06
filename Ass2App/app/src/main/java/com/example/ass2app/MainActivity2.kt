package com.example.ass2app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
   private lateinit var handler: Handler
   private lateinit var progressBar1:ProgressBar
   private lateinit var progressBar2:ProgressBar
   private lateinit var progressBar3:ProgressBar
   private lateinit var resetButton1:Button
   private lateinit var resetButton2:Button
   private lateinit var resetButton3:Button

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.activity_main2)

       progressBar1 = findViewById(R.id.progressBar1)
       progressBar2 = findViewById(R.id.progressBar2)
       progressBar3 = findViewById(R.id.progressBar3)
       resetButton1 = findViewById(R.id.resetButton1)
       resetButton2 = findViewById(R.id.resetButton2)
       resetButton3 = findViewById(R.id.resetButton3)
       //decleration

       handler = Handler(Looper.getMainLooper())

       initProgressBar(progressBar1, 300, resetButton1, "Ari has been fed !")
       initProgressBar(progressBar2, 100, resetButton2,"Ari has been cleaned !")
       initProgressBar(progressBar3, 200, resetButton3,"You have played with Ari !")
       //sets how long each progressbar will deplete for and displays message
   }


       private fun initProgressBar(progressBar: ProgressBar, initialValue:Int,resetButton:Button,toastMessage: String){
           var progressBarValue=initialValue
           progressBar.progress=progressBarValue
           val runnable = object:Runnable{
               override fun run() {
                  if (progressBarValue>0){
                       progressBarValue--
                       progressBar.progress=progressBarValue
                       handler.postDelayed(this,100)
                   }
               }
           }
           handler.post(runnable)
           resetButton.setOnClickListener {
               progressBarValue=100
               progressBar.progress=progressBarValue
               handler.removeCallbacks(runnable)
               handler.post(runnable)
               Toast.makeText(this@MainActivity2,toastMessage,Toast.LENGTH_SHORT).show()

           }
       }

    override fun onDestroy() {
        super.onDestroy()
    }



    }
