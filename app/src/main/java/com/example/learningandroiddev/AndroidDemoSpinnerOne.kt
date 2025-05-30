package com.example.learningandroiddev

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoSpinnerOneBinding

class AndroidDemoSpinnerOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoSpinnerOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAndroidDemoSpinnerOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var iceCreamFlavors = listOf("Chocolate 🍫", "Vanilla 🍦", "Strawberry 🍓", "Cookies & Cream 🍪", "Matcha 🍵", "Coffee ☕", "Lemon 🍋", "Mint 🌿", "Mango 🥭", "Peach 🍑", "Blue Berry 🫐", "Pineapple 🍍")

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, iceCreamFlavors)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.demoSpinner1.adapter = arrayAdapter

        binding.demoSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var selectedItem = parent?.getItemAtPosition(position).toString()
                binding.demoSpinner1.setSelection(position)

                Toast.makeText(this@AndroidDemoSpinnerOne, "You have selected $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}