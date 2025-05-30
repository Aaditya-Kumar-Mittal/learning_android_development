package com.example.learningandroiddev

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoDatePickerOneBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AndroidDemoDatePickerOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoDatePickerOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAndroidDemoDatePickerOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendarBox = Calendar.getInstance()

        val datePickerBox = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendarBox.set(Calendar.YEAR, year)
            calendarBox.set(Calendar.MONTH, month)
            calendarBox.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }

        binding.datePickerButton1.setOnClickListener {
            DatePickerDialog(
                this,
                datePickerBox,
                calendarBox.get(Calendar.YEAR),
                calendarBox.get(Calendar.MONTH),
                calendarBox.get(Calendar.DAY_OF_MONTH)
            ).show()
            updateLabel(calendarBox)
        }
    }

    private fun updateLabel(calendarBox: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.datePickerText1.text = sdf.format(calendarBox.time)
    }
}