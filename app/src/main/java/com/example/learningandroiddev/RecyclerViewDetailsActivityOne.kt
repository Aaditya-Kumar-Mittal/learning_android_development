package com.example.learningandroiddev

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecyclerViewDetailsActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_details_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getData = intent.getParcelableExtra<RecyclerViewDataClassOne>("recycler_data")
        if (getData != null) {
            findViewById<TextView>(R.id.detailsTitleText1).text = getData.dataTitle
            findViewById<TextView>(R.id.detailsDetailedText1).text = getData.dataDesc
            findViewById<ImageView>(R.id.detailsImage1).setImageResource(getData.dataDetailImage)
        }
    }
}