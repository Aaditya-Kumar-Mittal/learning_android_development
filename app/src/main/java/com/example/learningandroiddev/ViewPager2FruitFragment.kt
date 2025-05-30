package com.example.learningandroiddev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment


class ViewPager2FruitFragment : Fragment() {

    companion object {
        private const val ARG_IMAGE_RES = "fruit_image"

        fun newInstance(imageResId: Int): ViewPager2FruitFragment {
            val fragment = ViewPager2FruitFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RES, imageResId)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_view_pager2_fruit, container, false)
        val imageView = view.findViewById<ImageView>(R.id.fruitImageView)
        imageView.setImageResource(requireArguments().getInt(ARG_IMAGE_RES))
        return view
    }


}