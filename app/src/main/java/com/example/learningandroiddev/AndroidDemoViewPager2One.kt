package com.example.learningandroiddev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoViewPager2OneBinding

class AndroidDemoViewPager2One : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoViewPager2OneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAndroidDemoViewPager2OneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitImages = listOf(
            R.drawable.shadow_apple,
            R.drawable.shadow_avacado,
            R.drawable.shadow_banana,
            R.drawable.shadow_blackberry,
            R.drawable.shadow_blueberry,
            R.drawable.shadow_coconut,
            R.drawable.shadow_dragon,
            R.drawable.shadow_fig,
            R.drawable.shadow_guava,
            R.drawable.shadow_kiwi,
            R.drawable.shadow_lychee,
            R.drawable.shadow_mango,
            R.drawable.shadow_orange,
            R.drawable.shadow_papaya,
            R.drawable.shadow_peach,
            R.drawable.shadow_pineapple,
            R.drawable.shadow_pomegranate,
            R.drawable.shadow_raspberry,
            R.drawable.shadow_starfruit,
            R.drawable.shadow_strawberry,
            R.drawable.shadow_watermelon
        )

        binding.demoViewPager2.adapter = ViewPager2FruitPagerAdapter(this, fruitImages)

    }
}