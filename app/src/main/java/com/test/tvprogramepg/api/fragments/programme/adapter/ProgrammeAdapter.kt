package com.test.tvprogramepg.api.fragments.programme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.tvprogramepg.api.models.ProgrammeModel
import com.test.tvprogramepg.databinding.ProgrammeViewLayoutBinding

class ProgrammeAdapter : RecyclerView.Adapter<ProgrammeViewHolder>() {

    private var programmes: List<ProgrammeModel> = mutableListOf()

    fun setProgrammes(data: List<ProgrammeModel>) {
        programmes = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = ProgrammeViewLayoutBinding.inflate(layoutInflater, parent, false)
        return ProgrammeViewHolder(itemPersonBinding)
    }

    override fun getItemCount(): Int = programmes.size

    override fun onBindViewHolder(holder: ProgrammeViewHolder, position: Int) {

        val programmeModel = programmes[position]

        holder.bind(programmeModel)
    }
}