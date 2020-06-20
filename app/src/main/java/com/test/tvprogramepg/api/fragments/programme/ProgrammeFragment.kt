package com.test.tvprogramepg.api.fragments.programme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.tvprogramepg.R
import com.test.tvprogramepg.api.fragments.programme.adapter.ProgrammeAdapter
import com.test.tvprogramepg.api.models.ProgrammeModel
import com.test.tvprogramepg.databinding.ProgrammeFragmentBinding

class ProgrammeFragment(programmes: List<ProgrammeModel>) : Fragment() {

    private lateinit var binding: ProgrammeFragmentBinding

    private lateinit var viewModel: ProgrammeViewModel

    private val programmeAdapter: ProgrammeAdapter = ProgrammeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProgrammeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureUi()
    }

    private fun configureViewModel()
    {
        viewModel = ViewModelProvider(this).get(ProgrammeViewModel::class.java)
    }

    private fun configureUi()
    {
        configureBackButton()
        configureProgrammes()
    }

    private fun configureProgrammes() {
        binding.programmesList.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = programmeAdapter
        }
    }

    private fun configureBackButton()
    {
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}