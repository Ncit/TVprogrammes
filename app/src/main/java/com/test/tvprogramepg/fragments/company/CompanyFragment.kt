package com.test.tvprogramepg.fragments.company

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.test.tvprogramepg.R
import com.test.tvprogramepg.databinding.CompanyFragmentBinding


class CompanyFragment : Fragment() {

    private lateinit var binding: CompanyFragmentBinding

    private lateinit var viewModel: CompanyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CompanyFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureViewModel()
        configureUi()
    }

    private fun configureViewModel()
    {
        viewModel = ViewModelProvider(this).get(CompanyViewModel::class.java)

    }

    private fun configureUi()
    {
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.callNumber.setOnClickListener {
            phoneCall()
        }
    }

    private fun phoneCall()
    {
        activity?.let {
            val permission = ContextCompat.checkSelfPermission(it,
                Manifest.permission.CALL_PHONE)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    it.requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), 343)
                }
            }
            else
            {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + resources.getString(R.string.call_number)))
                it.startActivity(intent)
            }
        }
    }

}