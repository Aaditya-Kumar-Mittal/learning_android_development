package com.example.learningandroiddev

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.learningandroiddev.databinding.ActivityAndroidDemoAlertDialogBoxOneBinding

class AndroidDemoAlertDialogBoxOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoAlertDialogBoxOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAndroidDemoAlertDialogBoxOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.demoAlertDialogBoxButton1.setOnClickListener { showAlertDialogBox() }

    }

    private fun showAlertDialogBox() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog Box Title")
            .setMessage("Alert Dialog Box Message")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(this, "Alert Dialog Box successfully implemented!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { dialogInterface, which ->
                dialogInterface.dismiss()
            }
            .setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(this, "Alert Dialog Box cancelled!", Toast.LENGTH_SHORT).show()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }
}