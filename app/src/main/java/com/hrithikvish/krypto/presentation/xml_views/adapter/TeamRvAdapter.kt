package com.hrithikvish.krypto.presentation.xml_views.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.krypto.data.remote.dto.TeamMember
import com.hrithikvish.krypto.databinding.TeamMemberItemBinding
import com.hrithikvish.krypto.presentation.xml_views.adapter.TeamRvAdapter.TeamMemberViewHolder

class TeamRvAdapter: RecyclerView.Adapter<TeamMemberViewHolder>() {

    private val team = mutableListOf<TeamMember>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitTeam(teamMemberList: List<TeamMember>) {
        team.clear()
        team.addAll(teamMemberList)
        notifyDataSetChanged()
    }

    inner class TeamMemberViewHolder(val binding: TeamMemberItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding = TeamMemberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        with(holder.binding) {
            teamMember = team[position]
        }
    }

    override fun getItemCount(): Int = team.size

}