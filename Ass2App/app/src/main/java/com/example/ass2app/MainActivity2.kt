package com.example.ass2app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private var foodPBarValue=100
    private lateinit var handler:Handler
    private lateinit var runnable:Runnable
    private lateinit var foodPBar:ProgressBar
    private lateinit var feedBtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val feedBtn = findViewById<Button>(R.id.feedBtn)
        val play2Btn = findViewById<Button>(R.id.play2Btn)
        val cleanBtn = findViewById<Button>(R.id.cleanBtn)
        val foodPBar = findViewById<ProgressBar>(R.id.foodPBar)
        val playPBar = findViewById<ProgressBar>(R.id.playPBar)
        val cleanPBar = findViewById<ProgressBar>(R.id.cleanPBar)
        handler = Handler(Looper.getMainLooper())
        runnable =object : Runnable {
            override fun run() {
                if
                        (foodPBarValue > 0) {
                    foodPBarValue -= 1
                    foodPBar.progress = foodPBarValue
                    handler.postDelayed(this, 100)
                }
            }
        }
        handler.post(runnable)
        feedBtn.setOnClickListener {
            foodPBarValue = 100
            foodPBar.progress = foodPBarValue
            handler.removeCallbacks(runnable)
            handler.post(runnable)
        }


        }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)



    }
}