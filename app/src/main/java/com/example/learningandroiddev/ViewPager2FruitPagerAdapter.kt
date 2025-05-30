package com.example.learningandroiddev

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2FruitPagerAdapter(
    activity: FragmentActivity,
    private val fruitImages: List<Int>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = fruitImages.size

    override fun createFragment(position: Int): Fragment {
        return ViewPager2FruitFragment.newInstance(fruitImages[position])
    }
}