package com.example.learningandroiddev

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoAnimatedSplashScreenOneBinding

class AndroidDemoAnimatedSplashScreenOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoAnimatedSplashScreenOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAndroidDemoAnimatedSplashScreenOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, AndroidSecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}