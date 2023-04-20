package com.tzs.picturesapp.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tzs.picturesapp.R
import com.tzs.picturesapp.viewmodel.PictureListViewModel

class PictureListFragment : Fragment() {

    companion object {
        fun newInstance() = PictureListFragment()
    }

    private lateinit var viewModel: PictureListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picture_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PictureListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}