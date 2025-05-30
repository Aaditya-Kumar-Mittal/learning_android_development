package com.example.learningandroiddev

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.learningandroiddev.databinding.ActivityAndroidSecondBinding

class AndroidSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAndroidSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonExplicitIntent1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.buttonImplicitIntent1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.google.com".toUri())
            startActivity(intent)
        }

    }
}