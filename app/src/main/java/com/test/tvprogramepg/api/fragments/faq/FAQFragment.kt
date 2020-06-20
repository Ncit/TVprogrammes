package com.test.tvprogramepg.api.fragments.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.tvprogramepg.R
import com.test.tvprogramepg.api.fragments.faq.adapter.ExpandableListAdapter
import com.test.tvprogramepg.databinding.FAQFragmentBinding


class FAQFragment : Fragment() {

    private lateinit var binding: FAQFragmentBinding

    private lateinit var viewModel: FAQViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FAQFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureUi()
    }

    private fun configureViewModel()
    {
        viewModel = ViewModelProvider(this).get(FAQViewModel::class.java)
    }

    private fun configureUi()
    {
        buildExpandedList()
        configureBackButton()
    }

    private fun configureBackButton()
    {
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun buildExpandedList()
    {
        val header: MutableList<String> = ArrayList()
        val body: MutableList<MutableList<String>> = ArrayList()

        val season1: MutableList<String> = ArrayList()
        season1.add("answer on first question")

        val season2: MutableList<String> = ArrayList()
        season2.add("answer on second question")

        header.add("First question")
        header.add("Second question")

        body.add(season1)
        body.add(season2)

        binding.questions.setAdapter(ExpandableListAdapter(binding.root.context,binding.questions, header, body))

    }
}