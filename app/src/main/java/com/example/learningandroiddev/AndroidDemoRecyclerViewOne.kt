package com.example.learningandroiddev

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroiddev.databinding.ActivityAndroidDemoRecyclerViewOneBinding
import java.util.Locale

class AndroidDemoRecyclerViewOne : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDemoRecyclerViewOneBinding
    private lateinit var recyclerView: RecyclerView

    private var dataList = ArrayList<RecyclerViewDataClassOne>()
    private var searchList = ArrayList<RecyclerViewDataClassOne>()

    private lateinit var imageList: Array<Int>
    private lateinit var descImageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var descList: Array<String>

    private lateinit var myDetailsAdapter: RecyclerViewAdapterClassOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAndroidDemoRecyclerViewOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList = arrayOf(
            R.drawable.ic_list,
            R.drawable.ic_date,
            R.drawable.ic_edit,
            R.drawable.ic_text,
            R.drawable.ic_time,
            R.drawable.ic_rating,
            R.drawable.ic_camera,
            R.drawable.ic_image,
            R.drawable.ic_checkbox,
            R.drawable.ic_toggle,
        )

        titleList = arrayOf(
            "List",
            "Date",
            "Edit",
            "Text",
            "Time",
            "Rating",
            "Camera",
            "Image",
            "Checkbox",
            "Toggle",
        )

        descList = arrayOf(
            getString(R.string.listview),
            getString(R.string.date),
            getString(R.string.edit),
            getString(R.string.textview),
            getString(R.string.time),
            getString(R.string.rating),
            getString(R.string.camera),
            getString(R.string.imageview),
            getString(R.string.checkbox),
            getString(R.string.toggle),
        )

        descImageList = arrayOf(
            R.drawable.list_detail,
            R.drawable.date_detail,
            R.drawable.edit_detail,
            R.drawable.text_detail,
            R.drawable.time_detail,
            R.drawable.rating_detail,
            R.drawable.camera_detail,
            R.drawable.image_detail,
            R.drawable.check_detail,
            R.drawable.toggle_detail,
        )

        recyclerView = binding.demoRecyclerView1
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        getData() // populate dataList & searchList

        binding.demoSearchView1.clearFocus()
        binding.demoSearchView1.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.demoSearchView1.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText = newText?.lowercase(Locale.getDefault()).orEmpty()
                searchList.clear()
                if (searchText.isNotEmpty()) {
                    for (item in dataList) {
                        if (item.dataTitle.lowercase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(item)
                        }
                    }
                } else {
                    searchList.addAll(dataList)
                }
                recyclerView.adapter?.notifyDataSetChanged()
                return false
            }
        })

        myDetailsAdapter = RecyclerViewAdapterClassOne(searchList)
        recyclerView.adapter = myDetailsAdapter

        myDetailsAdapter.onItemClick = {
            val intent = Intent(this, RecyclerViewDetailsActivityOne::class.java)
            intent.putExtra("recycler_data", it)
            startActivity(intent)
        }

    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = RecyclerViewDataClassOne(imageList[i], titleList[i], descList[i], descImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList) // initialize searchList with full data
        recyclerView.adapter = RecyclerViewAdapterClassOne(searchList) // use searchList in adapter
    }
}
