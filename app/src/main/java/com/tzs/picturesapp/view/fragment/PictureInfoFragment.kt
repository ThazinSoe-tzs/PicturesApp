package com.tzs.picturesapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.tzs.picturesapp.R
import com.tzs.picturesapp.databinding.FragmentPictureInfoBinding
import com.tzs.picturesapp.viewmodel.PictureInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        viewModel.loadPhotoInfo(picID)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel.photo.observe(viewLifecycleOwner) { response ->
                ivPic.load(response.downloadUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_image_24)
                    scale(Scale.FILL)
                }
                tvAuthorName.text = "Author - ${response.author}"
                tvWidth.text = "Image Width - ${response.width}"
                tvHeight.text = "Image Height - ${response.height}"

            }

            viewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    pbLoad.visibility = View.VISIBLE
                } else {
                    pbLoad.visibility = View.INVISIBLE
                }
            }


            photoFilters.addOnButtonCheckedListener { group, checkedId, isChecked ->
                when (checkedId) {
                    radioNormal.id -> {
                        ivPic.load(viewModel.normalURL) {
                            crossfade(true)
                            placeholder(R.drawable.ic_baseline_image_24)
                            scale(Scale.FILL)
                        }
                    }

                    radioBlur.id -> {
                        ivPic.load(viewModel.blurURL) {
                            crossfade(true)
                            placeholder(R.drawable.ic_baseline_image_24)
                            scale(Scale.FILL)
                        }
                    }

                    radioGrayscale.id -> {
                        ivPic.load(viewModel.grayscaleURL) {
                            crossfade(true)
                            placeholder(R.drawable.ic_baseline_image_24)
                            scale(Scale.FILL)
                        }
                    }
                }
            }
        }
    }

}