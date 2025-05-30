package com.example.learningandroiddev

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoListViewOneBinding

class AndroidDemoListViewOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoListViewOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAndroidDemoListViewOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var androidTopicsList = arrayOf("ListView", "Intents", "Toolbar", "Layout", "Fragments", "RecyclerView", "Material Design", "SplashScreen")

        var listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, androidTopicsList)

        binding.demoListView1.adapter = listAdapter

        binding.demoListView1.setOnItemClickListener { parent, view, position, id ->

            var selectedItem = parent.getItemAtPosition(position) as String

            Toast.makeText(this, "You selected $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}