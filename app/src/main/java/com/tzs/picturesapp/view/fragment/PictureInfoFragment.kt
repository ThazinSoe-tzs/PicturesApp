package com.tzs.picturesapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tzs.picturesapp.databinding.FragmentPictureInfoBinding
import com.tzs.picturesapp.viewmodel.PictureInfoViewModel

class PictureInfoFragment : Fragment() {

    private lateinit var binding: FragmentPictureInfoBinding
    private var picID = 0
    private val args: PictureInfoFragmentArgs by navArgs()
    private val viewModel: PictureInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        picID = args.pictureID
        Toast.makeText(context, "Pic ID $picID", Toast.LENGTH_SHORT).show()
        //viewModel.loadDetailsMovie(movieId)
    }

}