package com.test.tvprogramepg.api.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.tvprogramepg.R
import com.test.tvprogramepg.Router
import com.test.tvprogramepg.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: SettingsFragmentBinding
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SettingsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureUi()
    }

    private fun configureViewModel()
    {
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
    }

    private fun configureUi()
    {
        binding.FAQ.setOnClickListener {
            findNavController().navigate(R.id.FAQFragment)
        }

        binding.contact.setOnClickListener {
            findNavController().navigate(R.id.companyFragment)
        }
    }
}