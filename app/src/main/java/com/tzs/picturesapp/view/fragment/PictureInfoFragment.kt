package com.tzs.picturesapp.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tzs.picturesapp.R
import com.tzs.picturesapp.viewmodel.PictureInfoViewModel

class PictureInfoFragment : Fragment() {

    companion object {
        fun newInstance() = PictureInfoFragment()
    }

    private lateinit var viewModel: PictureInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picture_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PictureInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}