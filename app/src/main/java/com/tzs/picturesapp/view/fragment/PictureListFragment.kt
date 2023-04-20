package com.tzs.picturesapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.tzs.picturesapp.databinding.FragmentPictureListBinding
import com.tzs.picturesapp.model.data.model.Photo
import com.tzs.picturesapp.view.adapter.LoadMoreAdapter
import com.tzs.picturesapp.view.adapter.PhotoAdapter
import com.tzs.picturesapp.viewmodel.PictureListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PictureListFragment : Fragment() {

    private lateinit var binding: FragmentPictureListBinding

    @Inject
    lateinit var photoAdapter: PhotoAdapter

    private val viewModel: PictureListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleScope.launchWhenCreated {
                viewModel.photoList.collect {
                    photoAdapter.submitData(it)
                }
            }

            photoAdapter.setOnItemClickListener {
                val direction = PictureListFragmentDirections.actionPictureListFragmentToPictureInfoFragment(it.id.toInt())
                findNavController().navigate(direction)
            }

            lifecycleScope.launchWhenCreated {
                photoAdapter.loadStateFlow.collect {
                    val state = it.refresh
                    progressBar.isVisible = state is LoadState.Loading
                }
            }

            rvPhotos.apply {
                layoutManager = GridLayoutManager(requireContext(), 1)
                adapter = photoAdapter
            }

            rvPhotos.adapter=photoAdapter.withLoadStateFooter(
                LoadMoreAdapter{
                    photoAdapter.retry()
                }
            )
        }
    }

}