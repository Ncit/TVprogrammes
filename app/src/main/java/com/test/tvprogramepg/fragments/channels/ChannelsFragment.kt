package com.test.tvprogramepg.fragments.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.test.tvprogramepg.DataHolder
import com.test.tvprogramepg.adapter.TVAdapter
import com.test.tvprogramepg.databinding.ChannelsFragmentBinding

class ChannelsFragment : Fragment() {

    private lateinit var binding: ChannelsFragmentBinding

    private lateinit var viewModel: ChannelsViewModel
    private var tvAdapter = TVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChannelsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureUi()
        DataHolder.programmes = mutableListOf()
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this).get(ChannelsViewModel::class.java)
        viewModel.pagedListLiveData.observe(viewLifecycleOwner, Observer { t ->
            tvAdapter.submitList(t)
        })

        viewModel.channelDataSourceFactory.channelDataSource.loadListener = {
            binding.progressPlaceholder.visibility = View.GONE
        }
    }

    private fun configureUi() {
        val gridManager = GridLayoutManager(binding.root.context, 2)
        binding.channelsList.apply {
            layoutManager = gridManager
            adapter = tvAdapter
        }

        tvAdapter.clickPositionListener = { idNo ->
            DataHolder.programmes?.apply {
                val filteredProgrammes = this.filter { programmeModel -> programmeModel.idNo == idNo }
                print(filteredProgrammes)
            }
        }
    }
}